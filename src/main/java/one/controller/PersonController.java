package one.controller;

import java.util.List;

import javax.validation.Valid;

import one.domain.Person;
import one.domain.PersonRepository;
import one.domain.Persons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 
 * @author 
 *
 */
@RestController
public class PersonController {

	private static final Logger log =LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonRepository repository;
	 
	// Create -> HTTP.POST
	@RequestMapping(value ="/api/person", method=RequestMethod.POST)
	public Person createPerson(@RequestBody @Valid Person person) {
		log.info("createPerson()");
		
		repository.save(person);
		return person;	
	}
	
	// Retrieve -> HTTP.GET
	@RequestMapping(value ="/api/person/name/{name}", method =RequestMethod.GET)
	public Persons getPersonByName(@PathVariable String name) {
		log.info("findByName()");
		List<Person> persons = repository.findByName(name);
                return new Persons(persons);
	}
	
	// Retrieve -> HTTP.GET
	@RequestMapping(value ="/api/person/age/{age}", method=RequestMethod.GET)
	public Persons getPersonByAge(@PathVariable int age) {
		log.info("findByAge()");
		List<Person> persons= repository.findByAge(age);
                return new Persons(persons);
	}
        
        @RequestMapping(value="/api/person/id/{id}")
        public Person getPersonById(@PathVariable String id) {
            log.info("getPersonById()");
            return repository.findById(id);
        }
	
	// Retrieve -> HTTP.GET
	@RequestMapping(value ="/api/persons", method=RequestMethod.GET)
	public Persons getAllPersons() {
		log.info("getAllPersons()");
		List<Person> persons =repository.findAll();
                return new Persons(persons);
	}
	
	// Update -> HTTP.PUT
	 @RequestMapping(value = "/api/person", method = RequestMethod.PUT)
	 public Person updatePerson(@RequestBody @Valid Person person) {
		 log.info("updatePerson()");
		 repository.save(person);
		 return repository.findById(person.getId());
	 }
	
	// Delete -> HTTP.DELETE
	 @RequestMapping(value="/api/person/id/{id}", method=RequestMethod.DELETE)
	 public Person deletePerson(@PathVariable String id) {
		 Person person =repository.findById(id);
		 repository.delete(person);
		 return person;
	 }
}
