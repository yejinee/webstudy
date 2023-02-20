package com.yejin.spring_mvc.jdbc.service;

import com.yejin.spring_mvc.jdbc.entity.Message;
import com.yejin.spring_mvc.jdbc.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    // 1. 주입
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // 2. DB에 저장
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
}
