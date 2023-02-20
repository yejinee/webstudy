package com.yejin.spring_mvc.jdbc.mapper;

import com.yejin.spring_mvc.jdbc.dto.MessagePostDto;
import com.yejin.spring_mvc.jdbc.dto.MessageResponseDto;
import com.yejin.spring_mvc.jdbc.entity.Message;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-20T16:51:36+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message messageDtoToMessage(MessagePostDto messagePostDto) {
        if ( messagePostDto == null ) {
            return null;
        }

        Message message = new Message();

        message.setMessage( messagePostDto.getMessage() );

        return message;
    }

    @Override
    public MessageResponseDto messageToMessageResponseDto(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageResponseDto messageResponseDto = new MessageResponseDto();

        messageResponseDto.setMessageId( message.getMessageId() );
        messageResponseDto.setMessage( message.getMessage() );

        return messageResponseDto;
    }
}
