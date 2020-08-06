package com.hfinoux.SafetyNetAlerts.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.hfinoux.SafetyNetAlerts.dao.PersonDAO;
import com.hfinoux.SafetyNetAlerts.model.Data;
import com.hfinoux.SafetyNetAlerts.model.Person;
import com.hfinoux.SafetyNetAlerts.model.PersonInfos;

class PersonDAOTest {

PersonDAO personDAO = new PersonDAO();
	
	List<Person> persons = Data.getInstance().getPersons();
	
	@Test
	void personDaoFindAll() {
		//GIVEN //WHEN // THEN
		assertNotNull(personDAO.findAll());		
	}
	
	@Test
	void findTheAddressOfTheFirstPerson() {
		//GIVEN
		//WHEN
		String person = personDAO.findAll().get(0).getAddress();
		//THEN
		assertEquals(person,"1509 Culver St");
		
	}
	
	@Test
	void findApersonByFirstNameAndLastName() {
		//GIVEN
		String firstName = "John";
		String lastName = "Boyd";
		//WHEN
		String addressOfJohnBoyd = personDAO.findByFirstNameAndLastName(firstName, lastName).get(0).getPerson().getAddress();
		//THEN
		assertEquals(addressOfJohnBoyd, "1509 Culver St" );
	}
}