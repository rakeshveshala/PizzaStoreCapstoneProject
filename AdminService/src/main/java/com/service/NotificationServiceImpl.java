package com.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
    private JavaMailSender mailSender;
	public void notifyUser(Long userId, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo();
        mailMessage.setSubject("Pizza Store Notification");
        mailMessage.setText("Notification for user " + userId + ": " + message);
        
       mailSender.send(mailMessage);

		System.out.println("Notification to user " + userId + ": " + message);
    }
}
