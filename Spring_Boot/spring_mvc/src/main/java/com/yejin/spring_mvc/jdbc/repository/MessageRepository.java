package com.yejin.spring_mvc.jdbc.repository;

import com.yejin.spring_mvc.jdbc.entity.Message;
import org.springframework.data.repository.CrudRepository;


/*  [ CrudRepository ]
*  - CRUD위해서 지원하는 인터페이스
* ✔ Message
* - Message 클래스 객체에 담긴 data를 DB데이블에 생성/수정
* - DB에서 조회한 데이터를 Message 클래스로 변환 가능
* ✔ Long
* - Message Entity 멤버변수 중 식별자 의미하는 @Id 붙어있는 데이터 의미
* */
public interface MessageRepository extends CrudRepository<Message, Long> {
    // Data Access 계층과 DB의 연동 담당
}
