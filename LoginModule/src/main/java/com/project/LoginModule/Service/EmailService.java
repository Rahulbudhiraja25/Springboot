package com.project.LoginModule.Service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendThankyouMail(String to, String subject, String templatePath, String recipientName) throws MessagingException, IOException{
        String emailContent = new String(Files.readAllBytes(Paths.get(templatePath)));


        emailContent=emailContent.replace("{{name}}", recipientName);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(emailContent, true); // `true` for HTML content
        helper.setFrom("playerp043@gmail.com");

        // Send the email
        mailSender.send(mimeMessage);
    }

    public void sendSelfMail(String to ,String subject ,String message) throws MessagingException,IOException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(message, false); // `true` for HTML content
        helper.setFrom("playerp043@gmail.com");

        // Send the email
        mailSender.send(mimeMessage);
    }
}
