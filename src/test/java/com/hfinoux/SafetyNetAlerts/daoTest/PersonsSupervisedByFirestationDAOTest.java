package com.hfinoux.SafetyNetAlerts.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hfinoux.SafetyNetAlerts.dao.PersonsSupervisedByFirestationDAO;
import com.hfinoux.SafetyNetAlerts.model.PersonsSupervisedByFirestation;

class PersonsSupervisedByFirestationDAOTest {
	
	PersonsSupervisedByFirestationDAO dao = new PersonsSupervisedByFirestationDAO();

	@Test
	void getTheNumberOfChildrenForAfirestation() {
		//GIVEN
		int stationNumber = 1;
		//WHEN
		int numberOfChildren = dao.findByStationNumber(stationNumber).getChildren();
		//THEN
		assertEquals(1, numberOfChildren);
	}

	@Test
	void getTheNumberOfAdultsForAfirestation() {
		//GIVEN
		int stationNumber = 1;
		//WHEN
		int numberOfAdults = dao.findByStationNumber(stationNumber).getAdults();
		//THEN
		assertEquals(5, numberOfAdults);
	}

	@Test
	void returnNullIfFiresationDoesntExist() {
		//GIVEN
		int stationNumber = 8;
		//WHEN
		PersonsSupervisedByFirestation emptyList = dao.findByStationNumber(stationNumber);
		//THEN
		assertNull(emptyList);
	}

}
