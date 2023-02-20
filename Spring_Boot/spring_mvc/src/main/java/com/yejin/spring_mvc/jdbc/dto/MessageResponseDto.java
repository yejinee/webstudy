package com.yejin.spring_mvc.jdbc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponseDto {
    // Response에 사용할 DTOs
    private long messageId;
    private String message;
}
