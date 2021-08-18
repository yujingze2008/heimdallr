package com.gitee.fun2code.jobs;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

public class MySqlCDCJob {

    public static void main(String[] args) {
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .useBlinkPlanner().inStreamingMode().build();
        StreamExecutionEnvironment senv = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment tenv = StreamTableEnvironment.create(senv, settings);

        tenv.executeSql(
                "CREATE TABLE mysql_binlog (\n" +
                        " id INT NOT NULL,\n" +
                        " name STRING,\n" +
                        " description STRING,\n" +
                        " weight DECIMAL(10,3)\n" +
                        ") WITH (\n" +
                        " 'connector' = 'mysql-cdc',\n" +
                        " 'hostname' = '192.168.9.17',\n" +
                        " 'port' = '23306',\n" +
                        " 'username' = 'root',\n" +
                        " 'password' = '123456',\n" +
                        " 'database-name' = 'flink-cdc',\n" +
                        " 'table-name' = 'mysql_binlog'\n" +
                        ")");
        tenv.executeSql("SELECT id, UPPER(name), description, weight FROM mysql_binlog").print();

    }

}
