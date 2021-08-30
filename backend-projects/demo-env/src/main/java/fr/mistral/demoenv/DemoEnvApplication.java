package fr.mistral.demoenv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Arrays;


@PropertySources(value = {
        @PropertySource("classpath:application.properties"),

        @PropertySource("classpath:application-${spring.profiles.active:prod}.properties"),


})
@SpringBootApplication
public class DemoEnvApplication implements CommandLineRunner {
    @Value("${spring.profiles.active:prod}")
    private  String springprofilesactive;

    @Value("${e.s.name}")
    private  String env;
    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(DemoEnvApplication.class, args);




    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello"+env+"  !!!!");
       // System.out.println(Arrays.asList(environment.getActiveProfiles()));

    }
}
