package com.brightcodinng.appcontactback.web;


import com.brightcodinng.appcontactback.dao.ContactRepository;
import com.brightcodinng.appcontactback.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactRepository contactRepository;

    @GetMapping
    public List<Contact> getAllContact() {

        return contactRepository.findAll();
    }

    @PostMapping
    public String registreUser(@RequestBody Contact contact) {
        Contact c = contactRepository.save(contact);
        return "hey " + c.getName() + " .....coucou";
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable("id") Long id) {
        Optional<Contact> contact = contactRepository.findById(id);

        if (contact == null) {

            return "waloooooooooooooooooo";
        }

        return contact;
    }

    @DeleteMapping("/{id}")
    public String DeleteById(@PathVariable("id") Long id) {


        contactRepository.deleteById(id);

        return "Ok";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Contact> updateVehicle(@PathVariable(value = "id") Long id,
                                                 @RequestBody Contact user) {
        Optional<Contact> userOptional = contactRepository.findById(id);

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setId(id);

        contactRepository.save(user);

        return ResponseEntity.noContent().build();
    }
}
