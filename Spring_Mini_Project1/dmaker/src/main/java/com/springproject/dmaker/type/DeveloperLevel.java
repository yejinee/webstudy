package com.springproject.dmaker.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
// ENUM TYPE : 한정된 값만을 가지는 열거 타입
public enum DeveloperLevel {
    NEW("신입개발자"),
    JUNIOR("주니어개발자"),
    JUNGNIOR("중니어개발자"),
    SENIOR("시니어개발자");

    private final String description;

}
