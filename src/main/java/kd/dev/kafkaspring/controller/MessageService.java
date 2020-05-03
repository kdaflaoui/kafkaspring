package kd.dev.kafkaspring.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @KafkaListener(topics = "test4", groupId = "group-ms")
    public void onMessage(ConsumerRecord<String, String> message){
        System.out.println("................");
        System.out.println(message.key() + " - "+message.value());
    }
}
