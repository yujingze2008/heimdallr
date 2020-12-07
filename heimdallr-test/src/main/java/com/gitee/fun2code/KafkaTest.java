package com.gitee.fun2code;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class KafkaTest {

    static Logger logger = LoggerFactory.getLogger(KafkaTest.class);


    public static void main(String[] args){
        produce();
    }

    public static void produce(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.9.16:9093,192.168.9.16:9095,192.168.9.16:9097");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        Producer<String, String> producer = new KafkaProducer<>(props);

        Random rnd = new Random();

        for (long nEvents = 0; nEvents < 20; nEvents++) {
            long runtime = new Date().getTime();
            String ip = "192.168.2." + rnd.nextInt(255);
            String msg = runtime + ",www.example.com," + ip;
            ProducerRecord<String, String> data = new ProducerRecord<String, String>("page_visits5", ip, msg);
            producer.send(data);
            logger.info("send:"+nEvents);
        }
        producer.flush();

        producer.close();

    }

}
