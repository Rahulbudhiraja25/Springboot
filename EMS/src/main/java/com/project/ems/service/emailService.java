
package com.project.ems.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.activation.DataSource;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

@Service
public class emailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(String to, String subject, String content, BufferedImage image) throws MessagingException, IOException {

        // Convert BufferedImage to byte array
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();


        MimeMessage mimeMessage = mailSender.createMimeMessage();


        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);


        helper.setTo(to);
        helper.setSubject(subject);

        String htmlContent = "<html><body>"
                + "<h1>QR Code for Attendee</h1>"
                + "<p>Here is the QR code for the attendee:</p>"
                + "<img src='cid:qrImage' alt='QR Code' />"
                + "</body></html>";
        helper.setText(htmlContent, true); // Set HTML content

        // Attach the image as inline content
        DataSource dataSource = new ByteArrayDataSource(imageBytes, "image/png");
        helper.addInline("qrImage", dataSource); // "qrImage" matches the 'cid' in the HTML

        // Set the sender's email
        helper.setFrom("playerp043@gmail.com");

        // Send the email
        mailSender.send(mimeMessage);

        return "Email sent to " + to + " successfully";
    }
}

