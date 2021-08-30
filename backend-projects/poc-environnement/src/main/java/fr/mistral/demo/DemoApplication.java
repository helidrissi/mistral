package fr.mistral.demo;

import fr.mistral.demo.domain.central.Environment;
import fr.mistral.demo.domain.central.UserC;
import fr.mistral.demo.domain.db1.User1;
import fr.mistral.demo.domain.db2.User2;
import fr.mistral.demo.domain.db3.User3;
import fr.mistral.demo.repositories.central.EnvironmentRepository;
import fr.mistral.demo.repositories.central.UserCRepository;
import fr.mistral.demo.repositories.db1.User1Repository;
import fr.mistral.demo.repositories.db2.User2Repository;
import fr.mistral.demo.repositories.db3.User3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private EnvironmentRepository environmentRepository;
    @Autowired
    private User2Repository user2Repository;
    @Autowired
    private User1Repository user1Repository;
    @Autowired
    private UserCRepository userCRepository;
    @Autowired
    private User3Repository user3Repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }


    @Override
    public void run(String... args) throws Exception {

        User1 user1 = new User1();
        user1.setFirstName("USER");
        user1.setLastName("PROD");
        user1.setEmail("prod@mistral.fr");
        user1Repository.save(user1);
        System.out.println("user loaded ....!!!" + user1Repository.count());


        User2 user2 = new User2();
        user2.setFirstName("USER");
        user2.setLastName("PROD");
        user2.setEmail("prod@mistral.fr");
        user2Repository.save(user2);
        System.out.println("user loaded ....!!!" + user2Repository.count());

        User3 user3 = new User3();
        user3.setFirstName("USER");
        user3.setLastName("PROD");
        user3.setEmail("prod@mistral.fr");
        user3Repository.save(user3);
        System.out.println("user loaded ....!!!" + user3Repository.count());

        Environment prod = new Environment();
        prod.setName("PROD");
        environmentRepository.save(prod);
        Environment archive = new Environment();
        archive.setName("ARCHIVE");
        environmentRepository.save(archive);


        UserC userC = new UserC();
        userC.setFirstName("hamza");
        userC.setLastName("elidrissi");
        userC.setEmail("central@mistral.fr");
        userC.setPassword(bCryptPasswordEncoder.encode("123456"));
        userC.getEnvironments().add(prod);
        userC.getEnvironments().add(archive);
        userCRepository.save(userC);
        System.out.println("user loaded ....!!!" + userCRepository.count());
    }
}
