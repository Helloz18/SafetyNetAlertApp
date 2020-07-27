package com.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.PhoneDAO;

class phoneDAOTest {

	PhoneDAO phoneDAO = new PhoneDAO();
	
	@Test
	void getTheNumberOfChildrenForAfirestation() {
		//GIVEN
		int stationNumber = 1;
		//WHEN
		List<String> phoneNumber = phoneDAO.getPhoneForAstationNumber(stationNumber);
		int numberOfElementOfTheList = phoneNumber.size();
		//THEN
		assertEquals(4, numberOfElementOfTheList);
	}
	
	@Test
	void returnNullIfFirestationDoesntExist() {
		//GIVEN
		int stationNumber = 8;
		//WHEN
		List<String> phoneNumber = phoneDAO.getPhoneForAstationNumber(stationNumber);
		//THEN
		assertNull(phoneNumber);
	}

}
