package com.yejin.spring_mvc.order.controller;

import com.yejin.spring_mvc.coffee.service.CoffeeService;
import com.yejin.spring_mvc.order.dto.OrderPostDto;
import com.yejin.spring_mvc.order.entity.Order;
import com.yejin.spring_mvc.order.mapper.OrderMapper;
import com.yejin.spring_mvc.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.yejin.spring_mvc.order.dto.OrderResponseDto;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.net.URI;

@RestController
@RequestMapping("/v1/orders")
@Validated
public class OrderController {

    private final static String ORDER_DEFAULT_URL = "/v10/orders"; // (1) Default URL 경로
    private final OrderService orderService;
    private final OrderMapper mapper;
    private final CoffeeService coffeeService;


    public OrderController(OrderService orderService, OrderMapper mapper, CoffeeService coffeeService) {
        this.orderService = orderService;
        this.mapper = mapper;
        this.coffeeService = coffeeService;
    }

    @PostMapping
    public ResponseEntity postOrder(@Valid @RequestBody OrderPostDto orderPostDto) {
        // client 요청 시, 리소스 db에 저장 & HTTP Status 응답으로 전송 & DB에 저장된 위치도 reponse header에 추가해 응답
        Order order = orderService.createOrder(mapper.orderPostDtoToOrder(orderPostDto));

        // 등록된 주문에 해당하는 URI 객체
        URI location =
                UriComponentsBuilder    // 등록된 리소스의 위치 정보 (URI 객체) 생성
                        .newInstance()
                        .path(ORDER_DEFAULT_URL + "/{order-id}")
                        .buildAndExpand(order.getOrderId())
                        .toUri();               // "/v10/orders/{order-id}"


        return ResponseEntity.created(location).build();    // 응답객체 리턴 ( HTTP 201 Created status )
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId) {
        Order order = orderService.findOrder(orderId);

        return new ResponseEntity<>(mapper.orderToOrderResponseDto(coffeeService, order), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders() {
        List<Order> orders = orderService.findOrders();

        // (5) 주문한 커피 정보를 가져오도록 수정
        List<OrderResponseDto> response =
                orders
                        .stream()
                        .map(order -> mapper.orderToOrderResponseDto(coffeeService, order))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity cancelOrder(@PathVariable("order-id") @Positive long orderId) {
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
