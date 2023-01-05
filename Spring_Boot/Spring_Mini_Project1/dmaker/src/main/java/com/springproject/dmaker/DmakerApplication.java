package com.springproject.dmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;

/* 사용자 입력이 최초로 받아지는 곳*/
@EnableJpaAuditing
@SpringBootApplication
public class DmakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmakerApplication.class, args);
    }

}
