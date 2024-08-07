package com.learning.sb_gamerunner_first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SB_CONFIGURATION {

    @Bean
    public String name(){
        return "Rahul";
    }
}
