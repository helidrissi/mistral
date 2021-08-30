package fr.mistral.master.web.web;


import fr.mistral.master.data.domain.Person;
import fr.mistral.master.data.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonController {


    @Autowired
    private PersonService personService;


    @GetMapping("/")
    public List<Person> allPerson() {

        return personService.allPersons();
    }
}
