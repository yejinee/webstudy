package com.yejin.spring_mvc.order.repository;

import com.yejin.spring_mvc.order.Entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    // CrudRepository에 정의된 기본 쿼리메서드를 서비스 클래스에서 사용 가능
}
