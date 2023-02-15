package com.yejin.spring_mvc.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponseDto {
    // Response 데이터를 위한 데이터 Dto
    private long memberId;
    private String email;
    private String name;
    private String phone;

}
