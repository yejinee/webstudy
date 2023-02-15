package com.yejin.spring_mvc.coffee.mapper;

import com.yejin.spring_mvc.coffee.dto.CoffeePatchDto;
import com.yejin.spring_mvc.coffee.dto.CoffeePostDto;
import com.yejin.spring_mvc.coffee.dto.CoffeeResponseDto;
import com.yejin.spring_mvc.coffee.entity.Coffee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-15T17:46:04+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class CoffeeMapperImpl implements CoffeeMapper {

    @Override
    public Coffee coffePostDtoToCoffee(CoffeePostDto coffeePostDto) {
        if ( coffeePostDto == null ) {
            return null;
        }

        Coffee coffee = new Coffee();

        coffee.setKorName( coffeePostDto.getKorName() );
        coffee.setEngName( coffeePostDto.getEngName() );
        coffee.setPrice( coffeePostDto.getPrice() );

        return coffee;
    }

    @Override
    public Coffee coffePatchDtoToCoffee(CoffeePatchDto coffeePatchDto) {
        if ( coffeePatchDto == null ) {
            return null;
        }

        Coffee coffee = new Coffee();

        coffee.setCoffeeId( coffeePatchDto.getCoffeeId() );
        coffee.setKorName( coffeePatchDto.getKorName() );
        coffee.setEngName( coffeePatchDto.getEngName() );
        coffee.setPrice( coffeePatchDto.getPrice() );

        return coffee;
    }

    @Override
    public CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee) {
        if ( coffee == null ) {
            return null;
        }

        long coffeeId = 0L;
        String korName = null;
        String engName = null;
        Integer price = null;

        coffeeId = coffee.getCoffeeId();
        korName = coffee.getKorName();
        engName = coffee.getEngName();
        price = coffee.getPrice();

        CoffeeResponseDto coffeeResponseDto = new CoffeeResponseDto( coffeeId, korName, engName, price );

        return coffeeResponseDto;
    }
}
