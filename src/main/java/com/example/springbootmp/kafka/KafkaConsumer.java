package com.example.springbootmp.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author BCY
 */
@Slf4j
@Component
public class KafkaConsumer {


//    @KafkaListener(topics = {"Hello"} , groupId = "mp")
    public void process(ConsumerRecord<String , String> record){
        log.info("mp  收到消息 ：topic = {} , partition = {} , values = {}" , record.topic() , record.partition() , record.value());
    }
}
