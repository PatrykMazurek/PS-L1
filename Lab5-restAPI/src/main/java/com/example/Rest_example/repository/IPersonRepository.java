package com.example.Rest_example.repository;

import com.example.Rest_example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Long> {
}
