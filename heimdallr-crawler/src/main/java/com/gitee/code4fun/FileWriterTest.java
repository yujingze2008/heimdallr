package com.gitee.code4fun;

import com.github.jsonzou.jmockdata.JMockData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

/**
 * Created by Administrator on 2018/11/26.
 */
public class FileWriterTest {

    public static void main(String[] args) throws Exception{
        File  file  = new File("E:\\data.csv");
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i=0;i<2000000;i++){
            bw.write(toLine());
            bw.newLine();
            System.out.println(i);
        }
        bw.close();
        fw.close();
    }

    public static String toLine(){
        StringBuffer buffer = new StringBuffer();
        buffer.append(UUID.randomUUID().toString().replaceAll("-","")).append(",");
        buffer.append(JMockData.mock(String.class)).append(",");
        buffer.append(JMockData.mock(String.class)).append(",");
        buffer.append(JMockData.mock(String.class)).append(",");
        buffer.append(JMockData.mock(String.class)).append(",");
        buffer.append(JMockData.mock(String.class)).append(",");
        buffer.append(JMockData.mock(String.class)).append(",");
        buffer.append(JMockData.mock(String.class)).append(",");
        buffer.append(JMockData.mock(String.class)).append(",");
        buffer.append(JMockData.mock(String.class)).append(",");
        buffer.append(JMockData.mock(Integer.class)).append(",");
        buffer.append(JMockData.mock(Integer.class)).append(",");
        buffer.append(JMockData.mock(Integer.class)).append(",");
        buffer.append(JMockData.mock(Integer.class)).append(",");
        buffer.append(JMockData.mock(Double.class)).append(",");
        buffer.append(JMockData.mock(Double.class)).append(",");
        buffer.append(JMockData.mock(Double.class)).append(",");
        buffer.append(JMockData.mock(Double.class));
        return  buffer.toString();
    }

}
