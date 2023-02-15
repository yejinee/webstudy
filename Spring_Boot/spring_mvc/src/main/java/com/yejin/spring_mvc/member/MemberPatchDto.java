package com.yejin.spring_mvc.member;

import com.yejin.spring_mvc.validator.NotSpace;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
public class MemberPatchDto {
    @Setter
    private long memberId;
    // 공백 아닌 문자 1개 이상((공백인 문자 0개 또는 1개)(공백이 아닌 문자 1개 이상)) -> 마지막 맨 바깥 쪽 괄호 조건이 0개 이상(즉, 있어도 되고 없어도 된다)
    @NotSpace(message = "회원 이름은 공백이 아니어야 합니다")
    private String name;
    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;
}
