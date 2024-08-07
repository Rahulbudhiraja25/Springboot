package com.learning.SpringConfigBeanLearn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name ,int age){};
record Address(String Firstline ,String city){};

@Configuration
public class SB_CONFIG {
@Bean
    public String name(){
        return "Rahul";
    }
@Bean
    public int age(){
    return 30;
    }

    @Bean
    public Person person(){
    return new  Person("Rahul" , 25);
    }

    @Bean
    public Address address(){
    return new Address("Ram Nagar","Gurgaon");
    }
}
