package com.hfinoux.SafetyNetAlerts.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hfinoux.SafetyNetAlerts.dao.PhoneDAO;

@SpringBootTest
class phoneDAOTest {

	@Autowired
	PhoneDAO phoneDAO;
	
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
