package com.yejin.spring_mvc.coffee.mapper;

import com.yejin.spring_mvc.coffee.dto.CoffeePatchDto;
import com.yejin.spring_mvc.coffee.dto.CoffeePostDto;
import com.yejin.spring_mvc.coffee.dto.CoffeeResponseDto;
import com.yejin.spring_mvc.coffee.entity.Coffee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
}
