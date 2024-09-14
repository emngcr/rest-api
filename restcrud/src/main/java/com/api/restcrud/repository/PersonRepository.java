package com.api.restcrud.repository;

import com.api.restcrud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PersonRepository extends JpaRepository<Person , Integer> {

}
