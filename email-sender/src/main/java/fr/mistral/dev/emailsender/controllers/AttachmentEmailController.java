package fr.mistral.dev.emailsender.controllers;


import fr.mistral.dev.emailsender.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


/*
      Crée par hamza.elidrissi le 23/11/2020
*/


@RestController
public class AttachmentEmailController {

    @Autowired
    public JavaMailSender emailSender;


    @RequestMapping("/sendAttachmentEmail")
    public String sendAttachmentEmail() throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);

        helper.setTo(MyConstants.FRIEND_EMAIL);
        helper.setSubject("Test email avec des attachements");

        helper.setText("Salut ,je test un envoi d'un email avec des attachements!");

        // chemin des fichiers
        String path1 = "C:\\Users\\hamza.elidrissi\\Desktop\\ALIAS.txt";
        String path2 = "C:\\Users\\hamza.elidrissi\\Desktop\\edf.pdf";

        // Attachment 1
        FileSystemResource file1 = new FileSystemResource(new File(path1));
        helper.addAttachment("Txt file", file1);

        // Attachment 2
        FileSystemResource file2 = new FileSystemResource(new File(path2));
        helper.addAttachment("Pdf file", file2);

        emailSender.send(message);

        return "Email envoyé!";
    }

}
