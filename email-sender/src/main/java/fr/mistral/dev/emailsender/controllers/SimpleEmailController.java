package fr.mistral.dev.emailsender.controllers;

import fr.mistral.dev.emailsender.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
      Crée par hamza.elidrissi le 23/11/2020
*/
@RestController
public class SimpleEmailController {

    @Autowired
    public JavaMailSender emailSender;


    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {

        // Creation d'un simple message.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Salut je test un simple message");

        // Envoi de message!
        this.emailSender.send(message);

        return "Email Envoyé!";
    }

}
