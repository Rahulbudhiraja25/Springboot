package com.project.ems.controller;

import com.project.ems.service.emailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class MailController {

    @Autowired
    emailService service;


    @PostMapping("/send/message")
    public String sendMessage(String to, String subject, String content , BufferedImage image) throws MessagingException, IOException {

      return service.sendEmail(to, subject, content,image);

    }
}
