package com.example.Rest_example.service;


import com.example.Rest_example.model.Person;
import com.example.Rest_example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> getAllPerson(){
        return repository.getAll();
    }

    public Person getPerson(int id){
        return repository.getPerson(id);
    }

}
