package com.webapp.util;

import org.springframework.beans.factory.annotation.Autowired;

// code to sent registration is saved  to email 

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmailService {
//
//	@Autowired
//	private JavaMailSender javaMailSender;
//
//	public void sendEmail(
//			String to, 
//			String subject,
//			String message
//
//	) {
//
//		SimpleMailMessage sm = new SimpleMailMessage();
//		sm.setTo(to);
//		sm.setSubject(subject);
//		sm.setText(message);
//
//		javaMailSender.send(sm);
//	}
//}

//-------------------------------------------------------------------------------------------------------

// code of sending registration details with the msg in eamil :

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {


@Autowired
private JavaMailSender mailSender;

public void sendRegistrationEmail(String to, RegistrationDetails registrationDetails) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject("Welcome to Artich Logitech!");

    String emailContent = String.format(
        "Dear %s,\n\n"
        + "Good Morning ❤️\n\nWelcome to Artich Logitech! We are thrilled to have you on board.\n\n"
        + "Here are your registration details:\n\n"
        + "Username: %s\n"
        + "Email: %s\n"
        + "Mobile: %s\n\n"
        + "Feel free to explore and enjoy the benefits of being part of our community. "
        + "If you have any questions or need assistance, don't hesitate to reach out to us.\n\n"
        + "Best regards,\n"
        + "The Artich Logitech Team\n\n"
        + "Have a wonderful day! ❤️",
        registrationDetails.getUsername(),
        registrationDetails.getUsername(),
        registrationDetails.getEmail(),
        registrationDetails.getMobile()
    );

    message.setText(emailContent);
    mailSender.send(message);
}

    
    public void sendUpdateNotification(String to, RegistrationDetails registrationDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Registration Update");

        String emailContent = String.format(
            "Dear %s,\n\nYour registration details have been updated.\n\nUpdated details are"
            + " :\nUsername: %s\nEmail: %s\nMobile: %s\n\nBest regards,"
            + "\nArtich Logitech,\nHave a Nice day❤️",
            registrationDetails.getUsername(),
            registrationDetails.getUsername(),
            registrationDetails.getEmail(),
            registrationDetails.getMobile()
        );

        message.setText(emailContent);
        mailSender.send(message);
    }
}






