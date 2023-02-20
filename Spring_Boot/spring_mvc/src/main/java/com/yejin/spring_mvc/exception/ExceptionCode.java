package com.yejin.spring_mvc.exception;

import lombok.Getter;
/* 사용자 정의 예외 */
public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member Not Found"),
    METHOD_NOT_FOUND(405, "Method Not Allowed"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }



}
