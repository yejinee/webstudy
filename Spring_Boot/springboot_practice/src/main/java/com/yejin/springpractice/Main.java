package com.yejin.springpractice;

import com.yejin.springpractice.Config.Config;
import com.yejin.springpractice.Service.SortService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        // Annotation 기반으로 동작하는 spring container
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);  // Bean등록
        // context에서 Bean꺼내기
//        Sort<String> sort = context.getBean(Sort.class); // 구현체 바로 사용
//        System.out.println("result is " + sort.sort(Arrays.asList(args)));

        SortService sortService = context.getBean(SortService.class); // 인터페이스 이용해 접근
        System.out.println("result is " + sortService.doSort(Arrays.asList(args)));

    }
}