package be.cegeka.devops.training.controllers;

import be.cegeka.devops.training.model.Person;
import be.cegeka.devops.training.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(method = GET)
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @RequestMapping(method = GET,value = "/{id}")
    public Person getSinglePerson(@PathVariable("id") String id) {
        return personRepository.findOne(id);
    }

    @RequestMapping(method = POST)
    public void insertPerson(@RequestBody Person person) {
        personRepository.save(person);
    }
}
