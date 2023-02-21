package com.yejin.spring_mvc.order.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder
@Table("ORDER_COFFEE")
public class CoffeeRef {
    private long orderCoffeeId;
    private long coffeeId;
    private int quantity;

}
