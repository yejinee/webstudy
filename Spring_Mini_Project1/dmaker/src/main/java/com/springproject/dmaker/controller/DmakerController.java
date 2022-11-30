package com.springproject.dmaker.controller;

import com.springproject.dmaker.dto.CreateDeveloper;
import com.springproject.dmaker.dto.DeveloperDetailDto;
import com.springproject.dmaker.dto.DeveloperDto;
import com.springproject.dmaker.entity.Developer;
import com.springproject.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    // api응답받을 때, 바로 developer에 받지 말고 dto이용해서 받아줄것
    public List<DeveloperDto> getAllDevelopers() {
        log.info("GET /developers HTTP/1.1)");
        return dMakerService.getAllDevelopers();
    }

    // 특정 DEV의 상세정보 불러옴
    @GetMapping("/developer/{memberId}") //값을 가져옴
    // api응답받을 때, 바로 developer에 받지 말고 dto이용해서 받아줄것
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable String memberId // {memberId}를 여기에 담아줌
    ) {
        log.info("GET /developers HTTP/1.1)");
        return dMakerService.getDeveloperDetail(memberId);
    }


    /* DmakerService의 객체 생성 함수 수행*/
    @PostMapping("/create_developers")
    public CreateDeveloper.Response createDevelopers(
            // RequestBody: requestbody내용을 가져온다
            // @Valid : RequestBody에 들어온값을 request객체에 담아서 validation해보고 문제 생기면 에러메세지 출력
            @Valid @RequestBody CreateDeveloper.Request request
            ) {
        log.info("request : {}", request);
        return dMakerService.createDeveloper(request); //user값을 넘김
    }


}
