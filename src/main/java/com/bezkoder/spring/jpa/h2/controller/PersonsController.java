package com.bezkoder.spring.jpa.h2.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jpa.h2.model.Person;
import com.bezkoder.spring.jpa.h2.repository.PersonRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class PersonsController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@PostMapping("/persons")
	  public ResponseEntity<Person> createPerson(@RequestBody Person person) {
	    try {
			//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			//Date fecha = formato.parse(person.getBirthDate());
	    	Person _person = personRepository.save(new Person(person.getDni(),person.getFirstName(), person.getLastName(),
			 person.getAddress(), 
			// person.getBirthDate(),
			 person.getEmail(), person.getPhone()));
	      return new ResponseEntity<>(_person, HttpStatus.CREATED);
	    } catch (Exception e) {
	    	e.printStackTrace();
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PutMapping("/persons/{id}")
	  public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
	    Optional<Person> personData = personRepository.findById(id);

	    if (personData.isPresent()) {
	    	Person _person = personData.get();
	    	_person.setDni( person.getDni() );
	    	_person.setFirstName( person.getFirstName() );
	    	_person.setLastName( person.getLastName() );
	    	//_person.setBirthDate( person.getBirthDate() );
	    	_person.setAddress( person.getAddress() );
	    	_person.setEmail( person.getEmail() );
	    	_person.setPhone( person.getPhone() );
	      return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@GetMapping("/persons")
	  public ResponseEntity<List<Person>> getAllTutorials() {
	    try {
	      List<Person> persons = new ArrayList<Person>();
	      personRepository.findAll().forEach(persons::add);
	      if (persons.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(persons, HttpStatus.OK);
	    } catch (Exception e) {
	    	e.printStackTrace();
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@GetMapping("/persons/{id}")
	  public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
	    Optional<Person> tutorialData = personRepository.findById(id);

	    if (tutorialData.isPresent()) {
	      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	@DeleteMapping("/persons/{id}")
	  public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") long id) {
	    try {
	    	personRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
