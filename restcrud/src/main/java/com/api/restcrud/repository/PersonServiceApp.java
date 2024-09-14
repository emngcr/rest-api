package com.api.restcrud.repository;

import com.api.restcrud.entity.Person;
import com.api.restcrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceApp implements PersonService {

    private PersonRepository personRepository;
    @Autowired
    public PersonServiceApp(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
        Optional<Person> result = personRepository.findById(id);
        Person person = null;
        if(result.isPresent()){
            person = result.get();
        }
        else{
           throw  new RuntimeException("Dont find Person ID "+ id);
        }
        return person;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }
}
