package com.project.LoginModule.Controller;


import com.project.LoginModule.Entity.ContactMailReq;
import com.project.LoginModule.Service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
//    private ContactMailReq contactMailReq;


    @PostMapping("/api/contact")
    public String sendThankYouEmail(@RequestBody ContactMailReq contactMailReq) {
        String subject="Thankyou For Contacting Us";
        String tp="src/main/resources/templates/thank-you-template.html";
        try {
            emailService.sendThankyouMail(contactMailReq.getEmail(),subject,tp, contactMailReq.getName());
            sendSelfMail(contactMailReq.getEmail(), contactMailReq.getMessage());
            return "Thank you email sent successfully to " + contactMailReq.getEmail();
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            return "Failed to send email: " + e.getMessage();
        }

    }

    public void sendSelfMail(String from,String message) throws MessagingException, IOException {
        String subject="Message from "+from;
        String to="playerp043@gmail.com";

        emailService.sendSelfMail(to,subject,message);
    }
}
