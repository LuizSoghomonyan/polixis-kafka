package org.polixis.polixiskafka.controller;

import org.polixis.polixiskafka.entity.Message;
import org.polixis.polixiskafka.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody Message message){
        kafkaProducer.sendMessage(message);
    }
}
