package com.api.restcrud.service;

import com.api.restcrud.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Person findById(int id);

    Person save(Person person);

    void deleteById(int id);
}
