package com.hfinoux.SafetyNetAlerts.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.hfinoux.SafetyNetAlerts.dao.FloodDAO;
import com.hfinoux.SafetyNetAlerts.model.PersonWithAgeAndMedicalRecords;

class FloodDAOTest {

	FloodDAO floodDAO = new FloodDAO();
	
	@Test
	void getTheFirstPersonForTheFirstAddressForAstationNumber() {
		//GIVEN
		List<Integer> stationNumbers = new ArrayList<>();
		stationNumbers.add(1);
		stationNumbers.add(2);
		String address = "644 Gershwin Cir";
		//WHEN
		String firstName = floodDAO.getPersonsByAddressForAstationNumber(stationNumbers).get(address).get(0).getPerson().getFirstName();
		//THEN
		assertEquals(firstName, "Peter");
	}

	@Test
	void returnNullIfStationNumbersDontExist() {
		//GIVEN
		List<Integer> stationNumbers = new ArrayList<>();
		stationNumbers.add(10);
		stationNumbers.add(11);
		//WHEN
		Map<String, List<PersonWithAgeAndMedicalRecords>> nullreturn = floodDAO.getPersonsByAddressForAstationNumber(stationNumbers);
		//THEN
		assertNull(nullreturn);
	}
}
