package com.learn.j_email_sender.controllers;

import com.learn.j_email_sender.service.email_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class mail_controller {

    @Autowired
    private email_service Email_Service;
@PostMapping("/send")
    public String sendEmail(@RequestParam String to , @RequestParam String subject ,@RequestParam String text){
        try {
            Email_Service.sendSimpleEmail(to, subject, text);
        return "Email sent sucessfully";
        }
        catch (Exception e){

            return e.toString();
        }
        }

    @GetMapping("/test")
    public String test(){
        return "Controller created test working this is a testing Api";
    }
}
