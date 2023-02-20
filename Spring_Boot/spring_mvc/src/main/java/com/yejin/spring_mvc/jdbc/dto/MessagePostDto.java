package com.yejin.spring_mvc.jdbc.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
@Getter
public class MessagePostDto {
    // ResponseBody로 전달하는 문자열 바인딩하는 DTO
    @NotBlank
    private String message;
}
