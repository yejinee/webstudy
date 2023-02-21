package com.yejin.spring_mvc.order.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
public class OrderPostDto {
    @Positive
    private long memberId;

    // 여러 잔의 커피를 주문 가능
    @Valid
    private List<OrderCoffeeDto> orderCoffees;
}
