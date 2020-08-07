package com.hfinoux.SafetyNetAlerts.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.hfinoux.SafetyNetAlerts.model.Data;
import com.hfinoux.SafetyNetAlerts.model.Medicalrecord;
import com.hfinoux.SafetyNetAlerts.model.Person;
import com.hfinoux.SafetyNetAlerts.model.PersonInfos;
import com.hfinoux.SafetyNetAlerts.utils.Utils;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private static Logger LOGGER = LogManager.getLogger(PersonDAOImpl.class);
	
	List<Person> persons = Data.getInstance().getPersons();
	List<Medicalrecord> medicalrecords = Data.getInstance().getMedicalrecords();
	Utils utils = new Utils();
	
	/**
	 * returns a list of all people.
	 */
	@Override
	public List<Person> findAll() {
		return persons;
	}
	/**
	 * add a person in the list.
	 */
	@Override
	public Person save(Person person) {
		persons.add(person);
		LOGGER.info("add a person.");
		return person;
	}

	/**
	 * modify a person.
	 */
	@Override
	public void update(Person person) {
		for(int i=0; i<persons.size(); i++) {
			if(persons.get(i).getFirstName().equals(person.getFirstName())
					&& (persons.get(i).getLastName().equals(person.getLastName()))) {
				persons.set(i, person);
				LOGGER.info("Person has been modified.");
				return;
			}
		}
		
	}

	/**
	 * remove a person from the list.
	 */
	@Override
	public void delete(Person person) {
		LOGGER.info("Person has been removed.");
		persons.remove(person);
	}

	/**
	 * 
	 * @param address
	 * @return a list of person living in an address.
	 */
	public List<Person> findByAddress(String address) {
		List<Person> personsInThisAddress = new ArrayList<>();
		for(Person person : persons) {
			if(person.getAddress().equals(address)) {
				personsInThisAddress.add(person);				
			}
		}		
		return personsInThisAddress;
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @return a list of person named by this firstName an this lastName.
	 * Returns a list cause there can be more than one person with these parameters.
	 */
	public List<PersonInfos> findByFirstNameAndLastName(String firstName, String lastName) {

		List<PersonInfos> result = new ArrayList<>();

		for (Person person : persons) {
			for (int i = 0; i < medicalrecords.size(); i++) {
				if ((person.getFirstName().equals(firstName))
						&& ((firstName).equals(medicalrecords.get(i).getFirstName()))
						&& (person.getLastName().equals(lastName))
						&& ((lastName).equals(medicalrecords.get(i).getLastName()))) {
					String birthdate = medicalrecords.get(i).getBirthdate();
					int age = utils.calculateAge(birthdate);

					PersonInfos p = new PersonInfos();

					p.setPerson(person);
					p.setAge(age);
					p.setMedicalrecords(medicalrecords.get(i));
					result.add(p);
					
				}
			}
		}
		if(result.size() == 0) {
			LOGGER.error("This person was not found.");
		} else {
			LOGGER.info("Infos about "+firstName+" "+lastName);
		}
		return result;
	}

}
