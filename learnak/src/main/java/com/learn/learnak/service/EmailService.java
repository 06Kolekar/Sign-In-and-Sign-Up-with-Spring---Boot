package com.learn.learnak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.learn.learnak.model.SendEmail;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendSimpleMail(SendEmail details) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(details.getRecipient());
            mailMessage.setSubject(details.getSubject());
            mailMessage.setText(details.getMessage());

            mailSender.send(mailMessage);
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Error while sending email: " + e.getMessage();
        }
    }
}
