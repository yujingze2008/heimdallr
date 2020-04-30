package com.gitee.code4fun.util;

import javafx.scene.control.Tab;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2018/11/26.
 */
public class HbaseUtils {

    static Connection connection = null;

    static{
        Configuration conf = HBaseConfiguration.create();
        try {
            connection = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Connection getConnection(){
        return connection;
    }

    static void createTable(String tableName,String[] cfs) throws Exception{
        Admin admin = connection.getAdmin();
        TableName tn = TableName.valueOf(tableName);
        HTableDescriptor descriptor = new HTableDescriptor(tn);
        for(String cf :cfs){
            descriptor.addFamily(new HColumnDescriptor(cf));
        }
        admin.createTable(descriptor);
    }

    static boolean existTable(String tableName) throws Exception{
        Admin admin = connection.getAdmin();
        return admin.tableExists(TableName.valueOf(tableName));
    }

}
