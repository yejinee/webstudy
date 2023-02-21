package com.yejin.spring_mvc.coffee.controller;

import com.yejin.spring_mvc.coffee.dto.CoffeePatchDto;
import com.yejin.spring_mvc.coffee.dto.CoffeePostDto;
import com.yejin.spring_mvc.coffee.dto.CoffeeResponseDto;
import com.yejin.spring_mvc.coffee.mapper.CoffeeMapper;
import com.yejin.spring_mvc.coffee.service.CoffeeService;
import com.yejin.spring_mvc.coffee.entity.Coffee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/coffees")
@Validated
@Slf4j
public class CoffeeController {
    private final CoffeeService coffeService;
    private final CoffeeMapper coffeeMapper;

    public CoffeeController(CoffeeService coffeService, CoffeeMapper coffeeMapper) {
        this.coffeService = coffeService;
        this.coffeeMapper = coffeeMapper;
    }

    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto) {
        Coffee coffee = coffeeMapper.coffePostDtoToCoffee(coffeePostDto);
        Coffee reponse = coffeService.createCoffee(coffee);

        return new ResponseEntity<>(coffeeMapper.coffeeToCoffeeResponseDto(reponse), HttpStatus.CREATED);
    }
    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeePatchDto coffeePatchDto) {

        coffeePatchDto.setCoffeeId(coffeeId);
        Coffee coffee = coffeeMapper.coffePatchDtoToCoffee(coffeePatchDto);
        Coffee response = coffeService.updateCoffee(coffee);
        return new ResponseEntity<>(coffeeMapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);

    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") @Positive long coffeeId) {
        Coffee response = coffeService.findCoffee(coffeeId);

        return new ResponseEntity<>(coffeeMapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        List<Coffee> coffees = coffeService.findCoffees();
        List<CoffeeResponseDto> response = coffees.stream()
                .map(coffee -> coffeeMapper.coffeeToCoffeeResponseDto(coffee))
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") @Positive long coffeeId) {
        coffeService.deleteCoffee(coffeeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
