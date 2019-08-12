package com.gitee.fun2code;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.java.BatchTableEnvironment;
import org.apache.flink.types.Row;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        final ExecutionEnvironment environment = ExecutionEnvironment.createLocalEnvironment();
        DataSet<String> ds = environment.readTextFile("hdfs://cdh01.com:8020//user/hive/warehouse/datax_hive");
        /*DataSet<Tuple3<Integer,String,Integer>> newDs = ds.map(new MapFunction<String, Tuple3<Integer,String,Integer>>() {
            @Override
            public Tuple3<Integer,String,Integer> map(String s) throws Exception {
                String[] ss = s.split(",");
                Tuple3 tuple3 = new Tuple3(Integer.parseInt(ss[0]),ss[1],Integer.parseInt(ss[2]));
                return tuple3;
            }
        });*/
        DataSet<NewEntity> newDs = ds.map(new MapFunction<String, NewEntity>() {
            @Override
            public NewEntity map(String s) throws Exception {
                String[] ss = s.split(",");
                return new NewEntity(Integer.parseInt(ss[0]),ss[1],Integer.parseInt(ss[2]));
            }
        });
        BatchTableEnvironment bte = BatchTableEnvironment.create(environment);
        Table table = bte.fromDataSet(newDs,"id,name,age");
        Table counts = bte.sqlQuery("select count(age) from " + table);
        bte.toDataSet(counts,Row.class).print();
    }

}
