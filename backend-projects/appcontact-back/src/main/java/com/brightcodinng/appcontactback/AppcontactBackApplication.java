package com.brightcodinng.appcontactback;

import com.brightcodinng.appcontactback.dao.ContactRepository;
import com.brightcodinng.appcontactback.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AppcontactBackApplication implements WebMvcConfigurer, CommandLineRunner {
    @Autowired
    ContactRepository contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppcontactBackApplication.class, args);
    }


    public void addCorsMappings(CorsRegistry registry) {

        registry
                .addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*");

    }

    @Override
    public void run(String... args) throws Exception {

        Contact taha = new Contact(null, "taha bennana", "0661176405", false);
        Contact hamza = new Contact(null, "hamza el idrissi", "0612567699", false);
        Contact yas = new Contact(null, "yasmine zemmama", "0611235869", false);

        List<Contact> list = Arrays.asList(taha, hamza, yas);

        contactRepository.saveAll(list);

    }
}
