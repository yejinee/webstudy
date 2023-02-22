package com.yejin.spring_mvc.coffee.dto;

import com.yejin.spring_mvc.validator.NotSpace;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class CoffeePatchDto {
    /* [ 유효성 검증 ]
    1. korName => 공백만으로 구성X / 공백 불가
    2. engName => 공백만으로 구성X / 영문(대소문자 모두 가능)만 허용 / 한칸의 공백만 포함가능
    3. price => 100이상 50000이하의 숫자
    * */
    @Setter
    private long coffeeId;
    @NotSpace(message = "커피명(한글)은 공백이 아니어야 합니다.")
    private String korName;
    @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$", message = "커피명(영문)은 영문이어야 합니다. 예) Cafe Latte")
    private String engName;
    @Range(min=100, max=50000)
    private int price;

}
