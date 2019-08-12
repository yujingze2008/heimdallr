package com.gitee.fun2code;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
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

        BatchTableEnvironment bte = BatchTableEnvironment.create(environment);
        Table table = bte.fromDataSet(ds,"id,name,age");
        Table counts = bte.sqlQuery("select id from " + table);
        bte.toDataSet(counts,Row.class).print();
    }
}
