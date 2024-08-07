package com.learn.j_email_sender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class email_service {
@Autowired
   private JavaMailSender mailSender ;

   public void sendSimpleEmail (String to ,String subject ,String text){
       SimpleMailMessage message =new SimpleMailMessage();
       message.setTo(to);
       message.setSubject(subject);
       message.setText("Hi this is "+text+" from java mail test Service");
       message.setFrom("playerp043@gmail.com");

       mailSender.send(message);
   }

}
