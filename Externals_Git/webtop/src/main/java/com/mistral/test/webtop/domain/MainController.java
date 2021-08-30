package com.mistral.test.webtop.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PhotoRepository photoRepository;

    @GetMapping("/list")
    public String allPerson(Model model) {
        List<Person> persons =personRepository.findAll();
        List<Photo> photos=photoRepository.findAll();
        model.addAttribute("persons",persons);
        model.addAttribute("photos",photos);
        return "PersonTemplate";
    }

    @PostMapping("/createuser")
    public String create(Person persons,Model ){


    }
}
