package fr.mistral.master.data.serviceImlp;

import fr.mistral.master.data.domain.Person;
import fr.mistral.master.data.repositories.PersonRepository;
import fr.mistral.master.data.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> allPersons() {
        return personRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }
}
