package com.gitee.fun2code.faker;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class AccessLogFaker {

    static final int[] HTTP_CODES = new int[]{300, 301, 400, 404, 500, 501};
    static final String COLUMN_SPLIT = ",";
    static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] arg) throws Exception {
        String output = "/Users/yujingze/Downloads/data/out.txt";
        Faker faker = new Faker(Locale.CHINA);
        Random random = new Random();
        Date from = DateUtils.parseDate("1990-01-01 00:00:00", PATTERN);
        Date to = DateUtils.parseDate("2021-06-04 23:59:59", PATTERN);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));
        long begin = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 10000000; i++) {
            StringBuffer buffer = new StringBuffer();
            String remote_addr = faker.internet().ipV4Address();
            buffer.append(remote_addr).append(COLUMN_SPLIT);
            String time_local = DateFormatUtils.format(faker.date().between(from, to), PATTERN);
            buffer.append(time_local).append(COLUMN_SPLIT);
            String request = faker.internet().url();
            buffer.append(request).append(COLUMN_SPLIT);
            int status = HTTP_CODES[random.nextInt(HTTP_CODES.length - 1)];
            buffer.append(status).append(COLUMN_SPLIT);
            String http_user_agent = faker.internet().macAddress();
            buffer.append(http_user_agent);
            //System.out.println(buffer.toString());
            if (i % 1000 == 0) {
                System.out.println("creating...");
            }
            bw.write(buffer.toString() + "\n");
            count++;
        }
        if (bw != null) {
            bw.close();
        }
        System.out.println("create " + count + ",cast:" + (System.currentTimeMillis() - begin) / 1000);

    }

}
