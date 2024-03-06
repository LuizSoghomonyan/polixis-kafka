package org.polixis.polixiskafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.polixis.polixiskafka.entity.Message;
import org.polixis.polixiskafka.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class KafkaConsumerService {
    private MessageService messageService;
    public KafkaConsumerService(MessageService messageService){
        this.messageService = messageService;
    }

    @KafkaListener(topics = "kafka-test", groupId = "kafka-test")
    public void consumeMessage(Message message) {
        System.out.println(message);
        this.messageService.saveMessage(message);
    }
}
