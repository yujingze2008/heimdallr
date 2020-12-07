package com.gitee.code4fun;

import com.gitee.code4fun.util.HbaseUtils;
import com.gitee.code4fun.util.RandomCreditCardNumberGenerator;
import com.github.jsonzou.jmockdata.JMockData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/5.
 */
public class HbaseTest {

    static Connection connection = null;

    static{
        Configuration conf = HBaseConfiguration.create();
        try {
            connection = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void createTable() throws Exception{
        Admin admin = connection.getAdmin();
        TableName tableName = TableName.valueOf("hbase_test");
        HTableDescriptor descriptor = new HTableDescriptor(tableName);
        descriptor.addFamily(new HColumnDescriptor("cf"));
        admin.createTable(descriptor);
    }

    static void mockData() throws Exception{
        TableName tableName = TableName.valueOf("bigtable2");
        Table table = connection.getTable(tableName);
        List<Put> puts = new ArrayList<Put>();
        for(int i=0;i<1000000;i++){
            String rowKey = UUID.randomUUID().toString().replaceAll("-","");
            Put put = new Put(rowKey.getBytes());
            put.addColumn("c1".getBytes(),"str1".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("c1".getBytes(),"str2".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("c1".getBytes(),"str3".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("c1".getBytes(),"str4".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("c1".getBytes(),"str5".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("c1".getBytes(),"str6".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("c1".getBytes(),"int1".getBytes(),String.valueOf(JMockData.mock(Integer.class)).getBytes());
            put.addColumn("c1".getBytes(),"int2".getBytes(),String.valueOf(JMockData.mock(Integer.class)).getBytes());
            put.addColumn("c1".getBytes(),"long1".getBytes(),String.valueOf(JMockData.mock(Long.class)).getBytes());
            put.addColumn("c1".getBytes(),"long2".getBytes(),String.valueOf(JMockData.mock(Long.class)).getBytes());
            put.addColumn("c2".getBytes(),"str1".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("c2".getBytes(),"str2".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("c2".getBytes(),"str3".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("c2".getBytes(),"int1".getBytes(),String.valueOf(JMockData.mock(Integer.class)).getBytes());
            put.addColumn("c2".getBytes(),"int2".getBytes(),String.valueOf(JMockData.mock(Integer.class)).getBytes());
            puts.add(put);
            if(puts.size()%100==0){
                table.put(puts);
                puts.clear();
            }
        }

    }

    static void putDatas(int total) throws Exception{
        TableName tableName = TableName.valueOf("person");
        Table table = connection.getTable(tableName);
        List<Put> puts = new ArrayList<>();
        for(int i=0;i<total;i++){
            String rowKey = UUID.randomUUID().toString().replaceAll("-","");
            Put put = new Put(rowKey.getBytes());
            put.addColumn("info".getBytes(),"name".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("info".getBytes(),"age".getBytes(),String.valueOf(JMockData.mock(Integer.class)).getBytes());
            put.addColumn("info".getBytes(),"partment".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("other".getBytes(),"addr1".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("other".getBytes(),"addr2".getBytes(),JMockData.mock(String.class).getBytes());
            puts.add(put);
            System.out.println(i);
            if(i != 0 && i%10==0){
                table.put(puts);
                puts.clear();
            }
        }
        if(puts.size() > 0){
            table.put(puts);
        }
    }

    public static void mockBankData() throws Exception{
        String tableName = "trade";
        if(!HbaseUtils.existTable(tableName)){
            HbaseUtils.createTable(tableName,new String[]{"cf"});
        }
        String[] date = new String[]{"20181208","20181207","20181206","20181205","20181204"};

        Table table = connection.getTable(TableName.valueOf(tableName));
        List<Put> puts = new ArrayList<>();
        for(int i=0;i<1000000;i++){
            String card = RandomCreditCardNumberGenerator.generateMasterCardNumber();
            String rowKey = MD5Hash.getMD5AsHex(card.getBytes()).substring(0,8)+"_"+card+"_"+date[new Random().nextInt(date.length)];
            System.out.println(rowKey);
            Put put = new Put(rowKey.getBytes());
            put.addColumn("cf".getBytes(),"name".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("cf".getBytes(),"age".getBytes(),String.valueOf(JMockData.mock(Integer.class)).getBytes());
            put.addColumn("cf".getBytes(),"partment".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("cf".getBytes(),"amount".getBytes(),String.valueOf(JMockData.mock(Integer.class)).getBytes());

            put.addColumn("cf".getBytes(),"da".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("cf".getBytes(),"db".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("cf".getBytes(),"dc".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("cf".getBytes(),"dd".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("cf".getBytes(),"de".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("cf".getBytes(),"df".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("cf".getBytes(),"dg".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("cf".getBytes(),"dh".getBytes(),JMockData.mock(String.class).getBytes());
            put.addColumn("cf".getBytes(),"di".getBytes(),JMockData.mock(String.class).getBytes());


            puts.add(put);
            if(i != 0 && i%30==0){
                table.put(puts);
                puts.clear();
            }
        }
        if(puts.size() > 0){
            table.put(puts);
        }
    }

    static class PutThread extends Thread{

        @Override
        public void run() {
            try {
                //HbaseTest.mockData();
                mockBankData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void getTest() throws Exception{
        for(int i=0;i<100000000;i++){
            Connection myConnection = null;
                Configuration conf = HBaseConfiguration.create();
                try {
                    myConnection = ConnectionFactory.createConnection(conf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        Table table = myConnection.getTable(TableName.valueOf("trade"));
            Get get = new Get(Bytes.toBytes(UUID.randomUUID().toString()));
            Result result = table.get(get);
            System.out.println(result);
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) throws Exception{

        /*for(int i=0;i<5;i++){
            new PutThread().start();
        }*/
        int total = 10000;
        long begin = System.currentTimeMillis();
        putDatas(total);
        long end = System.currentTimeMillis();

        System.out.println("total cast:"+(end-begin)+"ms,avg cast:"+(end-begin)/total+"ms");

        /*for(int i=0;i<8;i++){
            new PutThread().start();
        }*/

        //getTest();

    }

}
