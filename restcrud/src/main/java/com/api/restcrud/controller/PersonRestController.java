package com.api.restcrud.controller;

import com.api.restcrud.entity.Person;
import com.api.restcrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonRestController {
    private PersonService personService;
    @Autowired
    public PersonRestController(PersonService personService){
        this.personService = personService;
    }
    @GetMapping("/persons")
    public List<Person> findAllPersons(){
       return personService.findAll();
    }

    @GetMapping("persons/{id}")
    public Person getPerson(@PathVariable int id){
        Person person = personService.findById(id);

        if(person == null){
            throw new RuntimeException("Not found id "+id);
            }
        return person;
    }



    @PostMapping("/persons")
    public Person add(@RequestBody Person person){
        person.setId(0);
        Person tempPerson = personService.save(person);
        return tempPerson;

    }

    @PutMapping
    public Person update(@RequestBody Person person){
        Person tempPerson  = personService.save(person);
        return tempPerson;
    }

    @DeleteMapping("/persons/{id}")
    public String delete(@PathVariable int personId){
        Person tempPerson = personService.findById(personId);

        if (tempPerson == null) {
            throw new RuntimeException("Employee id not found - " +personId);
        }

        personService.deleteById(personId);

        return "Deleted employee id - " + personId;


    }

}
