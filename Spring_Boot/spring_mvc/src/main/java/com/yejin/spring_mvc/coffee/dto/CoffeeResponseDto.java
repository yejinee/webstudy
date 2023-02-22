package com.yejin.spring_mvc.coffee.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoffeeResponseDto {
    private long coffeeId;
    private String korName;
    private String engName;
    private Integer price;
}
