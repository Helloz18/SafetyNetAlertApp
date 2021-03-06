package com.hfinoux.SafetyNetAlerts.controller;

import java.net.URI;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hfinoux.SafetyNetAlerts.dao.PersonDAO;
import com.hfinoux.SafetyNetAlerts.model.Person;
import com.hfinoux.SafetyNetAlerts.model.PersonInfos;

@RestController
public class PersonController {
	
	private static Logger LOGGER = LogManager.getLogger(PersonController.class);

	@Autowired
	PersonDAO personDAO;

	/**
	 * @return all people.
	 */
	@GetMapping("/allPersons")
	public List<Person> getPersonWithInfos() {
		LOGGER.info("The list of people.");
		return personDAO.findAll();
	}

	/**
	 * This URL returns the informations of a person : address, age and
	 * medical-records. If several people have the same name and first-name, they
	 * will appear in the list.
	 * @param firstName
	 * @param lastName
	 * @return a person : address, age and medical-records.
	 */
	@GetMapping("/personInfo")
	public List<PersonInfos> getPersonWithInfos(
			@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName) {

		return personDAO.findByFirstNameAndLastName(firstName, lastName);
	}

	/**
	 * A person is composed by a firstName, lastName, address, city, zip, phone,
	 * email.
	 * @param person
	 */
	@PostMapping("/person")
	public ResponseEntity<Void> addPerson(@RequestBody Person person) {
		Person newPerson = personDAO.save(person);

		if (newPerson == null)
			return ResponseEntity.noContent().build();

		URI location = 
				ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{firstName}")
				.buildAndExpand(newPerson.getFirstName())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * This method update a person, change an address, city, zip, phone, email.
	 * @param person
	 */
	@PutMapping("/person")
	public ResponseEntity<Void> updatePerson(@RequestBody Person person) {
		personDAO.update(person);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/**
	 * This method removes a person from the list of persons.
	 * @param person
	 */
	@DeleteMapping("/person")
	public ResponseEntity<Void> removePerson(@RequestBody Person person) {
		personDAO.delete(person);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
