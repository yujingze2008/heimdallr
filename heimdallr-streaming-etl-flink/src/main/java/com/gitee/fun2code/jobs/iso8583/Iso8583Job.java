package com.gitee.fun2code.jobs.iso8583;

import com.gitee.fun2code.util.PropsUtil;
import com.google.gson.Gson;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.connector.jdbc.JdbcConnectionOptions;
import org.apache.flink.connector.jdbc.JdbcExecutionOptions;
import org.apache.flink.connector.jdbc.JdbcSink;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.math.BigDecimal;
import java.util.Properties;

public class Iso8583Job {

    public static void main(String[] args) throws Exception {
        PropsUtil props = new PropsUtil("jobs/iso8583Job.properties");
        logicByOperators(props);
        //logicBySql(props);
    }

    public static void logicBySql(PropsUtil props) throws Exception {
        EnvironmentSettings settings = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment stenv = StreamTableEnvironment.create(env, settings);

        stenv.executeSql(
                "CREATE TABLE ods_iso8583 (\n" +
                        "    `event_time` TIMESTAMP(3) METADATA FROM 'timestamp',\n" +
                        "    `primaryAccountNumber` STRING,\n" +
                        "    `processingCode` INT,\n" +
                        "    `amountTransaction` DOUBLE,\n" +
                        "    `transmissionDate` STRING,\n" +
                        "    `systemTraceAuditNumber` INT,\n" +
                        "    `dateExpiration` STRING,\n" +
                        "    `merchantType` STRING,\n" +
                        "    `pointOfServiceEntryModeCode` STRING,\n" +
                        "    `cardAcceptorIdentificationCode` STRING,\n" +
                        "    `cardAcceptorNameLocation` STRING,\n" +
                        "    `currencyCode` STRING\n" +
                        ") WITH (\n" +
                        "  'connector' = 'kafka',\n" +
                        "  'topic' = 'iso8583',\n" +
                        "  'properties.bootstrap.servers' = 'kafka1:9097,kafka2:9097,kafka3:9097',\n" +
                        "  'properties.group.id' = 'testGroup',\n" +
                        "  'scan.startup.mode' = 'latest-offset',\n" +
                        "  'format' = 'json'\n" +
                        ")");
        stenv.sqlQuery("select sum(amountTransaction) as cnt,currencyCode as cnc \n" +
                "    from ods_iso8583 group by currencyCode").execute().print();

        env.execute("iso8583JobSQL");
    }

    public static void logicByOperators(PropsUtil props) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(3);
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, props.getString("kafka.bootstrap.servers"));
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, props.getString("kafka.group.id"));
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, props.getString("kafka.rest"));

        final OutputTag<String> detailTag = new OutputTag<String>("side-detail") {
        };

        DataStream<String> stream = env
                .addSource(new FlinkKafkaConsumer<>(props.getString("kafka.topic"), new SimpleStringSchema(), properties));

        SingleOutputStreamOperator<String> out = stream.process(new ProcessFunction<String, String>() {
            @Override
            public void processElement(String s, Context context, Collector<String> collector) throws Exception {
                collector.collect(s);
                context.output(detailTag, s);
            }
        });

        out.map(json -> {
            //转化为对象
            Gson gson = new Gson();
            return gson.fromJson(json, Iso8583Entity.class);
        }).filter(entity -> {
            //过滤非刷卡交易
            return !entity.pointOfServiceEntryModeCode.equals("01");
        }).map(new MapFunction<Iso8583Entity, Tuple2<String, BigDecimal>>() {
            @Override
            public Tuple2 map(Iso8583Entity iso8583Entity) throws Exception {
                return new Tuple2(iso8583Entity.currencyCode, iso8583Entity.amountTransaction);
            }
        }).keyBy(new KeySelector<Tuple2<String, BigDecimal>, String>() {
            @Override
            public String getKey(Tuple2<String, BigDecimal> stringBigDecimalTuple2) throws Exception {
                return stringBigDecimalTuple2.f0;
            }
        }).window(TumblingProcessingTimeWindows.of(Time.seconds(3))).reduce(new ReduceFunction<Tuple2<String, BigDecimal>>() {
            //根据币种进行金额汇总
            @Override
            public Tuple2<String, BigDecimal> reduce(Tuple2<String, BigDecimal> t2, Tuple2<String, BigDecimal> t1) throws Exception {
                return new Tuple2<String, BigDecimal>(t2.f0, t2.f1.add(t1.f1));
            }
        }).print();


        //侧输出明细到doris
        DataStream<String> detailOut = out.getSideOutput(detailTag);
        detailOut.map(json -> new Gson().fromJson(json, Iso8583Entity.class)).
                addSink(JdbcSink.sink(
                        "insert into test.iso8583_detail(" +
                                "primary_account_number," +
                                "processing_code," +
                                "amount_transaction," +
                                "transmission_date," +
                                "system_trace_audit_number," +
                                "date_expiration," +
                                "merchant_type," +
                                "pointofservice_entrymode_code," +
                                "cardacceptor_identification_code," +
                                "cardacceptor_namelocation," +
                                "currency_code) values(?,?,?,?,?,?,?,?,?,?,?)",
                        (ps, entity) -> {
                            //Gson gson = new Gson();
                            //System.out.println("插入");
                            //Iso8583Entity entity = gson.fromJson(t, Iso8583Entity.class);
                            ps.setString(1, entity.getPrimaryAccountNumber());
                            ps.setInt(2, entity.getProcessingCode());
                            ps.setBigDecimal(3, entity.getAmountTransaction());
                            ps.setString(4, entity.getTransmissionDate());
                            ps.setInt(5, entity.getSystemTraceAuditNumber());
                            ps.setString(6, entity.getDateExpiration());
                            ps.setString(7, entity.getMerchantType());
                            ps.setString(8, entity.getPointOfServiceEntryModeCode());
                            ps.setString(9, entity.getCardAcceptorIdentificationCode());
                            ps.setString(10, entity.getCardAcceptorNameLocation());
                            ps.setString(11, entity.getCurrencyCode());
                        }, JdbcExecutionOptions.builder().withBatchSize(1).build()
                        , new JdbcConnectionOptions.
                                JdbcConnectionOptionsBuilder()
                                .withUrl("jdbc:mysql://192.168.9.10:3306/test")
                                .withDriverName("com.mysql.jdbc.Driver")
                                .withUsername("root")
                                .withPassword("123456")
                                .build())).name("insertMySQL").setParallelism(3);

        /*detailOut.map(json -> new Gson().fromJson(json, Iso8583Entity.class))
                .addSink(new JdbcPoolSink("insert into test.iso8583_detail(" +
                        "primary_account_number," +
                        "processing_code," +
                        "amount_transaction," +
                        "transmission_date," +
                        "system_trace_audit_number," +
                        "date_expiration," +
                        "merchant_type," +
                        "pointofservice_entrymode_code," +
                        "cardacceptor_identification_code," +
                        "cardacceptor_namelocation," +
                        "currency_code) values(?,?,?,?,?,?,?,?,?,?,?)", null, new JdbcConnectionOptions.
                        JdbcConnectionOptionsBuilder()
                        .withUrl("jdbc:mysql://192.168.9.10:3306/test")
                        .withDriverName("com.mysql.jdbc.Driver")
                        .withUsername("root")
                        .withPassword("123456")
                        .build()));*/

        env.execute("iso8583Job");
    }

}
