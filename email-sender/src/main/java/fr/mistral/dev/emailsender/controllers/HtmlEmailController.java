package fr.mistral.dev.emailsender.controllers;

import fr.mistral.dev.emailsender.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/*
      Crée par hamza.elidrissi le 23/11/2020
*/

@RestController
public class HtmlEmailController {

    @Autowired
    public JavaMailSender emailSender;


    @RequestMapping("/sendHtmlEmail")
    public String sendHtmlEmail() throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<h3>Je test l'envoi d'un email Html</h3>"
                +"<img src='https://lh3.googleusercontent.com/proxy/F_UNJm-M8-Q9GaF5junHTsd5n59Bs1R4k30ksGANLinrkI6S5HuojPpDVm38PK2XLiAGW-viN9g08rzAzB1HA1LrBxud8z9WW4qrYLVzuQT6ucjYQfBa29_IiD1PzJJp-YbbAFOhdNOJyt8'>";

        message.setContent(htmlMsg, "text/html");

        helper.setTo(MyConstants.FRIEND_EMAIL);

        helper.setSubject("Test send HTML email");


        this.emailSender.send(message);

        return "Email envoyé!";
    }

}
