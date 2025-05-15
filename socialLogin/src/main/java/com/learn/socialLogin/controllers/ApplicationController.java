package com.learn.socialLogin.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @GetMapping("/")
    public String home(){
        return "Hello! Home";
    }

    @GetMapping("/secured")
    public String secures(){
        return "Hello! Secured";
    }

}
