package com.gitee.fun2code.jobs.userclick;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

public class ClickStreamJob {

    public static void main(String[] args) {
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .useBlinkPlanner().inStreamingMode().build();
        StreamExecutionEnvironment senv = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment tenv = StreamTableEnvironment.create(senv, settings);

        tenv.executeSql(
                "CREATE TABLE user_click (\n" +
                        " `user` STRING NOT NULL,\n" +
                        " click_time STRING,\n" +
                        /*" ts AS TO_TIMESTAMP(click_time,'yyyy-MM-dd HH:mm:ss'),\n" +*/
                        " url STRING\n" +
                        /*" WATERMARK FOR ts AS ts - INTERVAL '5' SECOND\n" +*/
                        ") WITH (\n" +
                        " 'connector' = 'mysql-cdc',\n" +
                        " 'hostname' = '192.168.9.17',\n" +
                        " 'port' = '23306',\n" +
                        " 'username' = 'root',\n" +
                        " 'password' = '123456',\n" +
                        " 'database-name' = 'flink-cdc',\n" +
                        " 'table-name' = 'user_click'\n" +
                        ")");

        /*Table odsTable = tenv.sqlQuery("select * from user_click");
        tenv.toRetractStream(odsTable, TypeInformation.of(new TypeHint<Tuple3<String, Long, String>>() {
        }));*/
        /*tenv.executeSql(
                "CREATE VIEW click_view (\n" +
                        " `user`,\n" +
                        " click_time,\n" +
                        " url\n" +
                        ") AS SELECT `user`,click_time,url from user_click");*/

        /*tenv.sqlQuery("SELECT `user`,COUNT(url) as cnt\n" +
                " FROM click_view \n" +
                " GROUP BY TUMBLE(click_time,INTERVAL '1' MINUTE),`user`").execute().print();*/
        tenv.sqlQuery("select `user`,count(*) from user_click group by `user`").execute().print();
    }

}
