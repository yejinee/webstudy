package com.yejin.spring_mvc.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderCoffeeResponseDto {
    // 주문한 커피 정보를 응답으로 제공하기 위한 DTO
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
    private int quantity;
}
