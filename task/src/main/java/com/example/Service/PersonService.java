package com.example.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Entity.Person;

@Service
public class PersonService {
	private List<Person> people = new ArrayList<>();
    private Long nextId = 1L;

    public List<Person> getAllPeople() {
        return people;
    }

    public Person getPersonById(Long id) {
        return people.stream().filter(person -> person.getId().equals(id)).findFirst().orElse(null);
    }

    public Person addPerson(Person person) {
        person.setId(nextId++);
        people.add(person);
        return person;
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        Person existingPerson = getPersonById(id);
        if (existingPerson != null) {
            existingPerson.setName(updatedPerson.getName());
        }
        return existingPerson;
    }

    public void deletePerson(Long id) {
        people.removeIf(person -> person.getId().equals(id));
    }

}
