package com.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dao.FirestationDAO;
import model.Firestation;
import parser.DataReader;

public class DaoTest {

	FirestationDAO dao = new FirestationDAO();
	
	private DataReader read = new DataReader();
	List<Firestation> firestations = read.readData().getFirestations();
	
	@Test
	void testDaoFindAll() {
		assertNotNull(dao.findAll());		
	}
	
	@Test
	void testDaoFindTheAddressOfTheFirstFiresation() {
		String firestation = dao.findAll().get(0).getAddress();
		assertEquals(firestation,"1509 Culver St");
		
	}
	
	@Test
	void testDaoAddAFirestationAtTheEndOfTheList() {
		Firestation firestation = new Firestation("nouvelle adresse2", 6);
		dao.save(firestation);
		assertEquals(14,firestations.size());
	}
	
	@Test
	void testDAORemoveLastFirestationFromTheList() {
		
	}
	
	@Test
	void testGetAddressesSupervisedByAfirestationWithItsStationNumber() {
		int station = 1;	
		ArrayList<String> addresses = new ArrayList<>();
		for (int i=0; i<firestations.size(); i++) {
			if (firestations.get(i).getStation() == (station)) {
				addresses.add(firestations.get(i).getAddress());
			}
		}
		assertEquals(3, addresses.size());
	}
}
