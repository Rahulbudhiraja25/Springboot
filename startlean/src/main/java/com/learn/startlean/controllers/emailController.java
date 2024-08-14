package com.learn.startlean.controllers;

import com.learn.startlean.service.mailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class emailController {

    private final com.learn.startlean.service.mailService mailService;

    public emailController(mailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam("to") String to,
                           @RequestParam("subject") String subject,
                           @RequestParam("name") String name,
                           @RequestParam("item1") String item1,
                           @RequestParam("item2") String item2){
        try {
            mailService.sendSimpleMail(to,subject,name,item1,item2);
            return "Email sent successfully";
        }
        catch (Exception e) {
            e.printStackTrace();

            return "Failed to send email.";

        }
    }

}
