package com.gitee.fun2code.jobs;

import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;

public class ClickBatchJob {

    public static void main(String[] args) {

        EnvironmentSettings bbSettings = EnvironmentSettings.newInstance().useBlinkPlanner().inBatchMode().build();
        TableEnvironment bbTableEnv = TableEnvironment.create(bbSettings);

        bbTableEnv.executeSql(
                "CREATE TABLE user_click (\n" +
                        " `user` STRING,\n" +
                        " click_time STRING,\n" +
                        " url STRING\n" +
                        ") WITH (\n" +
                        " 'connector' = 'jdbc',\n" +
                        " 'url' = 'jdbc:mysql://192.168.9.17:23306/flink-cdc?useSSL=false',\n" +
                        " 'table-name' = 'user_click',\n" +
                        " 'username' = 'root',\n" +
                        " 'password' = '123456'\n" +
                        ")");
        bbTableEnv.executeSql("select `user`,count(*) from user_click group by `user`").print();

    }

}
