package fr.mistral.trainig.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LoggingApplication {


    Logger log = LoggerFactory.getLogger(LoggingApplication.class);

    @GetMapping("/test/{name}")
    public String greeting(@PathVariable String name) {

        log.debug("Request{}", name);
        String response = "Hi" + name + "Welcome to mistral";
        log.debug("Response{}", response);
        return response;
    }


    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class, args);
    }

}
