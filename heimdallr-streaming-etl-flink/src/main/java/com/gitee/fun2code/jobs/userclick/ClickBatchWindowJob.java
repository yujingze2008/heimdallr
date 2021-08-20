package com.gitee.fun2code.jobs.userclick;

import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;

public class ClickBatchWindowJob {

    public static void main(String[] args) {
        EnvironmentSettings bbSettings = EnvironmentSettings.newInstance().useBlinkPlanner().inBatchMode().build();
        TableEnvironment bbTableEnv = TableEnvironment.create(bbSettings);

        bbTableEnv.executeSql(
                "CREATE TABLE user_click (\n" +
                        " `user` STRING,\n" +
                        " click_time STRING,\n" +
                        " url STRING,\n" +
                        " ts AS TO_TIMESTAMP(click_time,'yyyy-MM-dd HH:mm:ss'),\n" +
                        " WATERMARK FOR ts AS ts - INTERVAL '5' SECOND\n" +
                        ") WITH (\n" +
                        " 'connector' = 'jdbc',\n" +
                        " 'url' = 'jdbc:mysql://192.168.9.17:23306/flink-cdc?useSSL=false',\n" +
                        " 'table-name' = 'user_click',\n" +
                        " 'username' = 'root',\n" +
                        " 'password' = '123456'\n" +
                        ")");
        /*bbTableEnv.executeSql(
                "select \n" +
                    " tumble_start(ts,interval '1' minute),\n" +
                    " tumble_end(ts,interval '1' minute),\n" +
                    " `user`,\n" +
                    "  count(url)\n" +
                    " from user_click\n" +
                    " group by tumble(ts,interval '1' minute),`user`").print();*/

        /*bbTableEnv.executeSql("select `user`,count(*) from user_click group by `user`").print();*/
        /*bbTableEnv.executeSql("select * from user_click").print();*/

        bbTableEnv.executeSql(
                " SELECT window_start, window_end, SUM(url)\n" +
                    "  FROM TABLE(\n" +
                    "    CUMULATE(TABLE user_click, DESCRIPTOR(ts), INTERVAL '2' MINUTES, INTERVAL '10' MINUTES))\n" +
                    "  GROUP BY window_start, window_end").print();


    }

}
