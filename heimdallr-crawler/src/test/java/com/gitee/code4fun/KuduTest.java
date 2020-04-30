package com.gitee.code4fun;

import com.github.jsonzou.jmockdata.JMockData;
import org.apache.kudu.ColumnSchema;
import org.apache.kudu.Schema;
import org.apache.kudu.Type;
import org.apache.kudu.client.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2019/1/10.
 */
public class KuduTest extends Thread{

    private static final String KUDU_MASTERS = "node4:7051,node5:7051,node6:7051";

    public static void createTable(KuduClient client) throws KuduException{
        String tableName = "test_kudu";
        if(client.tableExists(tableName)){
            System.out.println("table已存在");
            return;
        }
        List<ColumnSchema> columns = new ArrayList<>();
        columns.add(new ColumnSchema.ColumnSchemaBuilder("id", Type.STRING).key(true).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name1", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name2", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name3", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name4", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name5", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name6", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name7", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name8", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name9", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name10", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name11", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name12", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name13", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name14", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name15", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name16", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name17", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name18", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name19", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("name20", Type.STRING).build());
        columns.add(new ColumnSchema.ColumnSchemaBuilder("age", Type.INT32).key(false).build());
        Schema schema = new Schema(columns);
        CreateTableOptions cto = new CreateTableOptions();
        List<String> hashKeys = new ArrayList<>(1);
        hashKeys.add("id");
        int numBuckets = 3;
        cto.addHashPartitions(hashKeys, numBuckets);
        client.createTable(tableName,schema,cto);
        System.out.println("Created table " + tableName);
    }

    public static void insertRows(KuduClient client) throws Exception{
        KuduTable table = client.openTable("test_kudu");
        KuduSession session = client.newSession();
        for (int i = 0; i < 10000; i++) {
            Insert insert = table.newInsert();
            PartialRow row = insert.getRow();
            row.addString("id", UUID.randomUUID().toString().replaceAll("-",""));
            row.addString("name1", JMockData.mock(String.class));
            row.addString("name2", JMockData.mock(String.class));
            row.addString("name3", JMockData.mock(String.class));
            row.addString("name4", JMockData.mock(String.class));
            row.addString("name5", JMockData.mock(String.class));
            row.addString("name6", JMockData.mock(String.class));
            row.addString("name7", JMockData.mock(String.class));
            row.addString("name8", JMockData.mock(String.class));
            row.addString("name9", JMockData.mock(String.class));
            row.addString("name10", JMockData.mock(String.class));
            row.addString("name11", JMockData.mock(String.class));
            row.addString("name12", JMockData.mock(String.class));
            row.addString("name13", JMockData.mock(String.class));
            row.addString("name14", JMockData.mock(String.class));
            row.addString("name15", JMockData.mock(String.class));
            row.addString("name16", JMockData.mock(String.class));
            row.addString("name17", JMockData.mock(String.class));
            row.addString("name18", JMockData.mock(String.class));
            row.addString("name19", JMockData.mock(String.class));
            row.addString("name20", JMockData.mock(String.class));
            row.addInt("age", JMockData.mock(Integer.class));
            session.apply(insert);
        }
        session.flush();

        if (session.countPendingErrors() != 0) {
            System.out.println("errors inserting rows");
            org.apache.kudu.client.RowErrorsAndOverflowStatus roStatus = session.getPendingErrors();
            org.apache.kudu.client.RowError[] errs = roStatus.getRowErrors();
            int numErrs = Math.min(errs.length, 5);
            System.out.println("there were errors inserting rows to Kudu");
            System.out.println("the first few errors follow:");
            for (int i = 0; i < numErrs; i++) {
                System.out.println(errs[i]);
            }
            if (roStatus.isOverflowed()) {
                System.out.println("error buffer overflowed: some errors were discarded");
            }
        }
        session.close();
    }

    KuduClient client;

    public KuduTest(KuduClient client){
        this.client = client;
    }

    @Override
    public void run() {
        try {
            long begin = System.currentTimeMillis();
            KuduTest.insertRows(client);
            System.out.println("cast："+(System.currentTimeMillis()-begin));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scan(KuduClient client) throws Exception{
        KuduTable table = client.openTable("test_kudu");
        KuduScanner scanner = client.newScannerBuilder(table)
                .build();
        int count = 0;
        while(scanner.hasMoreRows()){
            RowResultIterator results = scanner.nextRows();
            while(results.hasNext()){
                RowResult result = results.next();
                count ++;
            }
        }
        System.out.println("total:"+count);

    }

    public static void main(String[] args) throws Exception{
        KuduClient client = new KuduClient.KuduClientBuilder(KUDU_MASTERS).build();
        //client.deleteTable("test_kudu");
        //createTable(client);
        /*for(int i=0;i<50;i++){
            new KuduTest(client).start();
        }*/
        scan(client);
    }

}
