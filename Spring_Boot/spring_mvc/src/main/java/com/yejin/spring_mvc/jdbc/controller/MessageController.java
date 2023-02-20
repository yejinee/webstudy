package com.yejin.spring_mvc.jdbc.controller;

import com.yejin.spring_mvc.jdbc.dto.MessagePostDto;
import com.yejin.spring_mvc.jdbc.entity.Message;
import com.yejin.spring_mvc.jdbc.mapper.MessageMapper;
import com.yejin.spring_mvc.jdbc.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/v1/messages")
@RestController
public class MessageController {
    // client의 문자열 데이터 전달받음
    private final MessageService messageService;
    private final MessageMapper messageMapper;

    public MessageController(MessageService messageService, MessageMapper messageMapper) {
        this.messageService = messageService;
        this.messageMapper = messageMapper;
    }

    @PostMapping
    public ResponseEntity postMessage(@Valid @RequestBody MessagePostDto messagePostDto){
        Message message = messageService.createMessage(messageMapper.messageDtoToMessage(messagePostDto));

        return ResponseEntity.ok(messageMapper.messageToMessageResponseDto(message));
    }



}
