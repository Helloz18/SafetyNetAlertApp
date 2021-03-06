package com.hfinoux.SafetyNetAlerts.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hfinoux.SafetyNetAlerts.dao.FirestationDAO;
import com.hfinoux.SafetyNetAlerts.model.Data;
import com.hfinoux.SafetyNetAlerts.model.Firestation;

@SpringBootTest
public class FirestationDAOTest {

	@Autowired
	FirestationDAO firestationDAO;
	
	List<Firestation> firestations = Data.getInstance().getFirestations();
	
	@Test
	void firestationDaoFindAll() {
		//GIVEN //WHEN // THEN
		assertNotNull(firestationDAO.findAll());		
	}
	
	@Test
	void findTheAddressOfTheFirstFiresation() {
		//GIVEN
		//WHEN
		String firestation = firestationDAO.findAll().get(0).getAddress();
		//THEN
		assertEquals(firestation,"1509 Culver St");
		
	}
		
	@Test
	void getAddressesSupervisedByAfirestationWithItsStationNumber() {
		//GIVEN
		int station = 1;	
		ArrayList<String> addresses = new ArrayList<>();
		//WHEN
		for (int i=0; i<firestations.size(); i++) {
			if (firestations.get(i).getStation() == (station)) {
				addresses.add(firestations.get(i).getAddress());
			}
		}
		//THEN
		assertEquals(3, addresses.size());
	}
	
}
