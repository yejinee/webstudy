package com.yejin.spring_mvc.order.dto;

import com.yejin.spring_mvc.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponseDto {
    private long orderId;
    private long memberId;
    private Order.OrderStatus orderStatus;
    private List<OrderCoffeeResponseDto> orderCoffees;  // 주문한 커피 정보를 응답으로 전송 할 수 있도록 함
    private LocalDateTime createdAt;
}
