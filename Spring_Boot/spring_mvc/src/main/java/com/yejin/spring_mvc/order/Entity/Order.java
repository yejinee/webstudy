package com.yejin.spring_mvc.order.Entity;

import com.yejin.spring_mvc.member.entity.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Table("ORDERS")    // 테이블명 변경 (ORDER 사용 못하기 때문)
public class Order {
    @Id
    private long orderId;

    // memberId를 추가해서 Member 테이블 참조 (외래키/1:N관계)
    private AggregateReference<Member, Long> memberId;

    // N:N관계의 애그리거트 매핑 (N:N관계를 1:N , N:1로 풀어줄 엔티티가 필요함)
    @MappedCollection(idColumn = "ORDER_ID", keyColumn = "ORDER_COFFEE_ID")    // Entity 클래스 간에 연관관계 맺어줌
    // (idColumn => 외래키에 해당되는 컬럼명/ keyColumn => 외래키를 포함하고 있는 기본키 컬럼명)
    private Set<CoffeeRef> orderCoffees = new LinkedHashSet<>();

    private OrderStatus orderStatus = OrderStatus.ORDER_REQUEST;    // 주문 상태 정보
    private LocalDateTime createdAt = LocalDateTime.now();  // 주문 등록 시간

    public enum OrderStatus{
        ORDER_REQUEST(1, "주문 요청"),
        ORDER_CONFIRM(2, "주문 확정"),
        ORDER_COMPLETE(3, "주문 완료"),
        ORDER_CANCEL(4, "주문 취소");
        @Getter
        private int stepNumber;

        @Getter
        private String stepDescription;

        OrderStatus(int stepNumber, String stepDescription) {
            this.stepNumber = stepNumber;
            this.stepDescription = stepDescription;
        }
    }
}
