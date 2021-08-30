package com.brightcodinng.appcontactback.services;


import com.brightcodinng.appcontactback.dao.ContactRepository;
import com.brightcodinng.appcontactback.entities.Contact;
import com.brightcodinng.appcontactback.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;


    public Contact getContactById(Long id) throws RecordNotFoundException {
        Optional<Contact> contact = contactRepository.findById(id);

        if (contact.isPresent()) {
            return contact.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public Contact createOrUpdateEmployee(Contact entity) throws RecordNotFoundException {
        Optional<Contact> contact = contactRepository.findById(entity.getId());

        if (contact.isPresent()) {
            Contact newEntity = contact.get();
            newEntity.setName(entity.getName());
            newEntity.setTel(entity.getTel());


            newEntity = contactRepository.save(newEntity);

            return newEntity;
        } else {
            entity = contactRepository.save(entity);

            return entity;
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException {
        Optional<Contact> contact = contactRepository.findById(id);

        if (contact.isPresent()) {
            contactRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
