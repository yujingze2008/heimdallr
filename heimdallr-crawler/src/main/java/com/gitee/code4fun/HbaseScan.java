package com.gitee.code4fun;

import jodd.datetime.JStopWatch;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by Administrator on 2018/12/8.
 */
public class HbaseScan {

    static int i =0;
    public static void main(String[] args) throws Exception{
        Table table = HbaseUtils.getConnection().getTable(TableName.valueOf("trade"));
        JStopWatch watch = new JStopWatch();
       /* Get get = new Get("e27beeb9_5550485204945923_20181206".getBytes());
        Result result = table.get(get);
        if(!result.isEmpty()){
            result.listCells().forEach(cell->{
                System.out.println(new String(CellUtil.cloneFamily(cell))+","+new String(CellUtil.cloneQualifier(cell))+","+new String(CellUtil.cloneValue(cell)));
            });
        }*/

        Filter rowFilter = new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator("20181208"));
        Scan scan = new Scan();
        scan.setFilter(rowFilter);
        //scan.setBatch(100);
        //scan.setStartRow(Bytes.toBytes("3fa5fbb1_5532104735598621_20181204"));
        //scan.setStopRow(Bytes.toBytes("7f78e6d3_5126418305859060_20181208"));
        ResultScanner resultScanner = table.getScanner(scan);
        resultScanner.forEach(result -> {
            i++;
        });
        System.out.println("total:"+i);
        System.out.println(watch.elapsed()/1000);

    }

}
