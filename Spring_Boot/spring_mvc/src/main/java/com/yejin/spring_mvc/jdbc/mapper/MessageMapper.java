package com.yejin.spring_mvc.jdbc.mapper;

import com.yejin.spring_mvc.jdbc.dto.MessagePostDto;
import com.yejin.spring_mvc.jdbc.dto.MessageResponseDto;
import com.yejin.spring_mvc.jdbc.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    // DTO & Entity 매핑
    Message messageDtoToMessage(MessagePostDto messagePostDto);
    MessageResponseDto messageToMessageResponseDto(Message message);

}
