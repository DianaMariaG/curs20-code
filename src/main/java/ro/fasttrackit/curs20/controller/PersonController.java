package ro.fasttrackit.curs20.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs20.service.PersonService;
import ro.fasttrackit.curs20.entity.Person;

import java.util.List;

@RequestMapping("persons")
@RestController
public class PersonController {
    private final PersonService service;
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    List<Person> getAll() {
        return service.getAll();
    }

    @PostMapping
    Person addPerson(@RequestBody Person person) {
        return service.addPerson(person);
    }
}
