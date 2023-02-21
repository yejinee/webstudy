package com.yejin.spring_mvc.member.repository;

import com.yejin.spring_mvc.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
// CrudRepository 통해 db테이블에 CRUD 기능 구현 가능 (Member = Entity클래스 의미 / Long => @Id 붙은 멤버변수 타입 의미)
public interface MemberRepository extends CrudRepository<Member, Long> {
    // JDBC에서 지원하는 쿼리 메서드 이용해 데이터 조회
    Optional<Member> findByEmail(String email);
}
