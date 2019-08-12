package com.gitee.fun2code;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SocketTextStreamFunction;

/**
 * Created by Administrator on 2019/7/31.
 */
public class WordCount {

    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment see = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> ds = see.addSource(new SocketTextStreamFunction("localhost",9999,",",5));
        ds.print();
        see.execute("WorldCount app");
    }

}
