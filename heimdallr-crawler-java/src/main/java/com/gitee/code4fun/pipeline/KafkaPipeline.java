package com.gitee.code4fun.pipeline;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class KafkaPipeline implements Pipeline {

    static Producer<String, String> producer = null;

    static {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.111.131:9092,192.168.111.131:9093,192.168.111.131:9094");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "-1");
        props.put("retries", 3);
        props.put("batch.size", 323840);
        props.put("linger.ms", 10);
        producer = new KafkaProducer<String, String>(props);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        Iterator iterator = resultItems.getAll().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) iterator.next();
            ProducerRecord record = new ProducerRecord("crawler", entry.getValue());
            System.out.println("send:" + entry.getValue());
            producer.send(record);
            producer.flush();
        }
    }
}
