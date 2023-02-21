package com.yejin.spring_mvc.coffee.repository;

import com.yejin.spring_mvc.coffee.entity.Coffee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
    // where 절에서 COFFEE_CODE 조건으로 질의
    Optional<Coffee> findByCoffeeCode(String coffeeCode);
    // :coffeeId 는 coffeId의 값이 채워짐
    @Query("SELECT * FROM COFFEE WHERE COFFEE_ID = :coffeeId")
    Optional<Coffee> findByCoffee(Long coffeeId);
}
