package com.yejin.spring_mvc.coffee.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class CoffeePostDto {
    @NotBlank
    private String korName;
    @Pattern(regexp = "^[a-zA-Z]+(\\s?[a-zA-Z]+)*$")
    private String engName;
    @Range(min=100, max=50000)
    private int price;
}
