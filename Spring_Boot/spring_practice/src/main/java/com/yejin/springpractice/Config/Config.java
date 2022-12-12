package com.yejin.springpractice.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan("com.yejin.springpractice")
@Configuration
@EnableWebMvc
public class Config {
}
