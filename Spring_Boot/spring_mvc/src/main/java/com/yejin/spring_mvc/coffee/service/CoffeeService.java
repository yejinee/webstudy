package com.yejin.spring_mvc.coffee.service;

import com.yejin.spring_mvc.coffee.entity.Coffee;
import com.yejin.spring_mvc.exception.BusinessLogicException;
import org.springframework.stereotype.Service;
import com.yejin.spring_mvc.exception.ExceptionCode;

import java.util.List;
@Service
public class CoffeeService {
    public Coffee createCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee updateCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee findCoffee(long coffeeId) {
        exists(coffeeId);

        return new Coffee(coffeeId, "아메리카노", "Americano", 2500);
    }

    private void exists(long coffeeId) {

        throw new RuntimeException("does not exist coffee");

    }

    public List<Coffee> findCoffees() {
        return List.of(
                new Coffee(1L, "아메리카노", "Americano", 2500),
                new Coffee(2L, "카라멜 라떼", "Caramel Latte", 5000)
        );
    }

    public void deleteCoffee(long coffeeId) {
    }
}
