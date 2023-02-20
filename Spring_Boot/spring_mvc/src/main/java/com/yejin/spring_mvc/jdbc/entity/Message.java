package com.yejin.spring_mvc.jdbc.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
public class Message {
    @Id
    private long messageId;
    private String message;
}
