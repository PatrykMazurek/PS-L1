package com.example.Rest_example.repository;

import com.example.Rest_example.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private final List<Person> personList = new ArrayList<>();

    public PersonRepository(){
        initPersonList();
    }

    private void initPersonList(){
        personList.add(new Person(1,"Jan", "Kowalski", 34, "Kraków"));
        personList.add(new Person(2,"Jacek", "Nowacki", 33, "Kraków"));
        personList.add(new Person(3,"Ewa", "Rak", 40, "Poznań"));
        personList.add(new Person(4,"Magda", "Kowalska", 36, "Radom"));
    }

    public List<Person> getAll(){
        return personList;
    }

    public Person getPerson(int id){
        return personList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void savePerson(Person p){
        personList.add(p);
    }

    public boolean removePerson(Person p) {
        return personList.remove(p);
    }

}
