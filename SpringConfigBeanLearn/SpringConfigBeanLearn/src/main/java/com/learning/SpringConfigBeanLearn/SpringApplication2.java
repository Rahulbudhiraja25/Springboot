package com.learning.SpringConfigBeanLearn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringApplication2 {
    public static void main(String args[]){
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);

        var context =new AnnotationConfigApplicationContext(SB_CONFIG.class);


        System.out.println(context.getBean("name"));
        System.out.println(context.getBean(Address.class));

    }
}
