package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Person;
import com.example.Service.PersonService;

@RestController
public class PersonController {
	 @Autowired
	    private PersonService personService;

	    @GetMapping("/all")
	    public List<Person> getAllPeople() {
	        return personService.getAllPeople();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
	        Person person = personService.getPersonById(id);
	        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
	    }

	    @PostMapping("/addperson")
	    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
	        Person addedPerson = personService.addPerson(person);
	        return ResponseEntity.status(HttpStatus.CREATED).body(addedPerson);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
	        Person person = personService.updatePerson(id, updatedPerson);
	        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
	        personService.deletePerson(id);
	        return ResponseEntity.noContent().build();
	    }

}
