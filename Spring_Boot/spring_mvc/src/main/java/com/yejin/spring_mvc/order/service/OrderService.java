package com.yejin.spring_mvc.order.service;

import com.yejin.spring_mvc.coffee.service.CoffeeService;
import com.yejin.spring_mvc.member.service.MemberService;
import com.yejin.spring_mvc.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import com.yejin.spring_mvc.order.entity.Order;
import com.yejin.spring_mvc.exception.ExceptionCode;
import com.yejin.spring_mvc.exception.BusinessLogicException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    final private OrderRepository orderRepository;
    final private MemberService memberService;
    final private CoffeeService coffeeService;

    public OrderService(OrderRepository orderRepository, MemberService memberService, CoffeeService coffeeService) {
        this.orderRepository = orderRepository;
        this.memberService = memberService;
        this.coffeeService = coffeeService;
    }

    public Order createOrder(Order order) {
        // 회원이 존재하는지 확인
        memberService.findVerifiedMember(order.getMemberId().getId());

        // 커피가 존재하는지 조회해야 됨
        order.getOrderCoffees()
                .stream()
                .forEach(coffeeRef -> {
                    coffeeService.findVerifiedCoffee(coffeeRef.getCoffeeId());
                });
        return orderRepository.save(order);
    }

    public Order findOrder(long orderId) {
        return findVerifiedOrder(orderId);
    }

    public List<Order> findOrders() {
        return (List<Order>) orderRepository.findAll();
    }


    public void cancelOrder(long orderId) {
        // 주문이 확정되면(상태코드) 커피 주문 취소 불가능
        Order findOrder = findVerifiedOrder(orderId);
        int step = findOrder.getOrderStatus().getStepNumber();

        // OrderStatus의 step이 2미만일 경우(ORDER_CONFIRM)에만 주문취소 가능
        if (step >= 2) {
            throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_ORDER);
        }

        findOrder.setOrderStatus(Order.OrderStatus.ORDER_CANCEL);
        orderRepository.save(findOrder);
    }

    private Order findVerifiedOrder(long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Order findOrder =
                optionalOrder.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));
        return findOrder;
    }

}
