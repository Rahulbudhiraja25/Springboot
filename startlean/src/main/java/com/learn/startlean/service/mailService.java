package com.learn.startlean.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class mailService {

    @Autowired
    public JavaMailSender mailSender;
    @Autowired
    private JacksonAutoConfiguration jacksonAutoConfiguration;
    @Autowired
    private TemplateEngine templateEngine;
    public void sendSimpleMail(String to, String subject, String name, String item1, String item2) throws Exception{
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        helper.setFrom("playerp043@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);

       Context context = new Context();
       context.setVariable("name",name);
       context.setVariable("item1",item1);
       context.setVariable("item2",item2);


        String html = templateEngine.process("Template.html", context);

        helper.setText(html, true);


        mailSender.send(message);

    }
}
