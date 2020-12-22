package com.gitee.code4fun.pipeline;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class KafkaPipeline implements Pipeline {

    private static Logger logger = LoggerFactory.getLogger(KafkaPipeline.class);

    private String topic;

    private String bootstrapServers;

    public KafkaPipeline(){}

    public KafkaPipeline(String topic,String servers){
        this.topic = topic;
        this.bootstrapServers = servers;
        this.init();
    }

    Producer<String, String> producer = null;

    private void init(){
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
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
            ProducerRecord record = new ProducerRecord(topic, entry.getValue());
            logger.info("send:" + entry.getValue());
            producer.send(record);
            producer.flush();
        }
    }
}
