package fr.mistral.master.web;


import fr.mistral.master.data.domain.Person;
import fr.mistral.master.data.repositories.PersonRepository;
import fr.mistral.master.web.web.PersonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(value = {"fr.mistral.master.data","fr.mistral.master.sec"},basePackageClasses = PersonController.class)
@EnableJpaRepositories("fr.mistral.master.data.repositories")
@Configuration
@EnableAutoConfiguration
@EntityScan("fr.mistral.master.data.domain")
public class MasterWebApplication implements CommandLineRunner  {

    public static void main(String[] args) {
        SpringApplication.run(MasterWebApplication.class, args);
    }


    @Autowired
    private PersonRepository personRepository;



    @Override
    public void run(String... args) throws Exception {
        loadPerson();
    }

    private void loadPerson() {

        Person hamza = new Person();
        hamza.setFirstName("hamza");
        hamza.setLastName("el idrissi dafali");

        personRepository.save(hamza);


        System.out.println("Person Loaded: " + personRepository.count());
    }
}
