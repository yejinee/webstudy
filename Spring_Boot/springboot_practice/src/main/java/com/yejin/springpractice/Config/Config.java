package com.yejin.springpractice.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// 이하에 있는 모든 spring bean들을 스캔
@ComponentScan("com.yejin.springpractice")
@Configuration
public class Config {
}
