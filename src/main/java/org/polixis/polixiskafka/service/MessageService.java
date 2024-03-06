package org.polixis.polixiskafka.service;

import org.polixis.polixiskafka.entity.Message;
import org.polixis.polixiskafka.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Transactional
    public void saveMessage(Message message){
        this.messageRepository.save(message);
    }

}
