package fr.mistral.master.data.bootstrap;


import fr.mistral.master.data.domain.Person;
import fr.mistral.master.data.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;




public class Bootstrap implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;



    @Override
    public void run(String... args) throws Exception {
        loadPerson();
    }

    private void loadPerson() {

        Person hamza = new Person();
        hamza.setFirstName("hamza");
        hamza.setLastName("el idrissi ");

        personRepository.save(hamza);


        System.out.println("Person Loaded: " + personRepository.count());
    }
}
