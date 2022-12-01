package com.springproject.dmaker.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DMakerErrorCode {
    NO_DEVELOPER("해당되는 개발자가 없다"),
    DUPLICATED_MEMBER_ID("MEMBERId가 중복되는 개발자가 있다"),
    LEVEL_EXPERIENCE_YEARS_NOT_MATCHED("개발자 레벨과 연차가 맞지 않습니다."),
    INTERNAL_SEVER_ERROR("서버 오류"),
    INVALID_REQUEST("잘못된 요청")
    ;

    private final String message;


}
