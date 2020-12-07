package com.gitee.fun2code;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaTest2 {

    public static void main(String[] args){
        consumer();
    }

    public static void consumer(){
        Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.9.16:9093,192.168.9.16:9095,192.168.9.16:9097");
        props.put(ConsumerConfig.GROUP_ID_CONFIG ,"test1") ;
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        Consumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("page_visits5"));

        while(true){
            ConsumerRecords<String, String> records  = consumer.poll(10);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("offer");
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }

    }

}
