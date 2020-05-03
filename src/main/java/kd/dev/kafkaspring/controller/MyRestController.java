package kd.dev.kafkaspring.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MyRestController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("send/{message}/{topic}")
    public String send(@PathVariable(name="message") String message,
                       @PathVariable(name="topic") String topic){
        kafkaTemplate.send(topic, "key = "+message.length(), message);
        return "message sent...";
    }
}
