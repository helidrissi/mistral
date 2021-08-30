package fr.mistral.demomisframe;

import fr.mistral.misframesecurity.domain.User;
import fr.mistral.misframesecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@ComponentScan(basePackages = {"fr.mistral.demomisframe","fr.mistral.misframesecurity"})
@Configuration
@EnableAutoConfiguration
public class DemoMisframeApplication implements CommandLineRunner {


    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(DemoMisframeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(User.builder().username("hamza").password(passwordEncoder.encode("123456")).build());
    }
}
