package com.hfinoux.SafetyNetAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hfinoux.SafetyNetAlerts.model.Person;
import com.hfinoux.SafetyNetAlerts.model.PersonInfos;

@Service
public interface PersonDAO extends InterfaceDAO<Person> {

	/**
	 * returns a list of all people.
	 */
	List<Person> findAll();

	/**
	 * add a person in the list.
	 */
	Person save(Person person);

	/**
	 * modify a person.
	 */
	void update(Person person);

	/**
	 * remove a person from the list.
	 */
	void delete(Person person);

	/**
	 * 
	 * @param address
	 * @return a list of person living in an address.
	 */
	List<Person> findByAddress(String address);

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @return a list of person named by this firstName an this lastName.
	 * Returns a list cause there can be more than one person with these parameters.
	 */
	List<PersonInfos> findByFirstNameAndLastName(String firstName, String lastName);

}