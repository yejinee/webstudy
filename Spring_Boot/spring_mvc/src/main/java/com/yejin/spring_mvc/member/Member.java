package com.yejin.spring_mvc.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    /*
    [ Role ]
    - API계층에서 전달받은 요청 데이터 기반으로 서비스 계층에서 비즈니스 로직 처리하기위한 데이터 전달받음
    - 비즈니스 로직 처리 후, 결과값을 api계층으로 리턴
    - 멤버 변수 모두 포함
     */
    private long memberId;
    private String email;
    private String name;
    private String phone;
}
