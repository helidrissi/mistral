package com.mistral.test.webtop;

import com.mistral.test.webtop.domain.Person;
import com.mistral.test.webtop.domain.PersonRepository;
import com.mistral.test.webtop.domain.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WebtopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebtopApplication.class, args);
    }
     @Autowired
     private PersonRepository personRepository;
    @Override
    public void run(String... args) throws Exception {
        Person hamza=new Person(null,"hamza","dafali");
        Person taha=new Person(null,"taha","bennana");
        Person yas=new Person(null,"yas","zemmama");



        List<Person> team = Arrays.asList(hamza,taha, yas);
        personRepository.saveAll(team);
    }
}
