package com.yejin.spring_mvc.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class ErrorResponse {
    /*
    DTO 클래스 유효성 검증 실패 시, 실패 필드에 대한 Error정보만 담아서 응답하기 위한 클래스
    * */
    // (1) 에러정보가 배열로 응답되는걸 받아줘야하므로 List로  선언
    private List<FieldError> fieldErrors;

    @Getter
    @AllArgsConstructor
    public static class FieldError {
        private String field;
        private Object rejectedValue;
        private String reason;
    }
}
