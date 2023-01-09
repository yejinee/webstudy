package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RequestLineTest {

    @Test
    void create() {
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&operator=*&operand2=55");
        assertThat(requestLine).isNotNull();
        // 기존에 만든 생성자와 같은지 확인하기 위함 (같지 않음 => why? 객체끼리 비교시 equals & hashcode값이 필요함)
        assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate", "operand1=11&operator=*&operand2=55"));
    }
}
