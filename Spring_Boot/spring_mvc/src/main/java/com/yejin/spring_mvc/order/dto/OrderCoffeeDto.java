package com.yejin.spring_mvc.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
public class OrderCoffeeDto {
    @Positive
    private long coffeeId;

    @Positive
    private int quantity;
}
