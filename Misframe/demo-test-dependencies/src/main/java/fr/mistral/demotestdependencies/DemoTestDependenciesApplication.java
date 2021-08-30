package fr.mistral.demotestdependencies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan("fr.mistral")
@Configuration
@EnableAutoConfiguration
public class DemoTestDependenciesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTestDependenciesApplication.class, args);
    }

}
