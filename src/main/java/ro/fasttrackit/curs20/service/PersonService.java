package ro.fasttrackit.curs20.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs20.entity.Person;
import ro.fasttrackit.curs20.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository; //repository e clasa care se ocupa de entitatea Person

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAll() {
        return repository.findAll();
    }

    public Person addPerson(Person person) {
        return repository.save(person);
    }

}
