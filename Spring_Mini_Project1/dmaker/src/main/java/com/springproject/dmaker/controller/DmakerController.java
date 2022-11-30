package com.springproject.dmaker.controller;

import com.springproject.dmaker.dto.CreateDeveloper;
import com.springproject.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController // Controller + ResponseBody
@Slf4j
@RequiredArgsConstructor
public class DmakerController {
    // DmakerController가 DmakerService 사용하고 싶을때 (@RequiredArgsConstructor)
    private final DMakerService dMakerService;

    /*
    /developers로 사용자 요청이 온 경우 (GET /developers HTTP/1.1)
    로그 출력
    */
    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        log.info("GET /developers HTTP/1.1)");
        return Arrays.asList("snow", "Elsa", "Olaf");
    }

    /* DmakerService의 객체 생성 함수 수행*/
    @PostMapping("/create_developers")
    public List<String> createDevelopers(
            // RequestBody: requestbody내용을 가져온다
            // @Valid : RequestBody에 들어온값을 request객체에 담아서 validation해보고 문제 생기면 에러메세지 출력
            @Valid @RequestBody CreateDeveloper.Request request
            ) {
        log.info("request : {}", request);
        dMakerService.createDeveloper(request); //user값을 넘김

        return Arrays.asList("Olaf");
    }


}
