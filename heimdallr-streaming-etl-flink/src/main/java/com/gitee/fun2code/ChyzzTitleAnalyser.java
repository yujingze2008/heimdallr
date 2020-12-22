package com.gitee.fun2code;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class ChyzzTitleAnalyser {

    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","192.168.9.16:9093,192.168.9.16:9095,192.168.9.16:9097");
        properties.setProperty("group.id","test");

        DataStream<String> kafkaStream = env.addSource(
                new FlinkKafkaConsumer<String>("page_visits5",new SimpleStringSchema(),properties));

        kafkaStream.print();

        env.execute();
    }

}
