package com.example.Rest_example.controller;


import com.example.Rest_example.model.Person;
import com.example.Rest_example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok().body(service.getAllPerson());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id){
        return ResponseEntity.ok().body(service.getPerson(id));
    }

}
