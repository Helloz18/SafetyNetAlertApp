package com.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dao.FirestationDAO;
import model.Firestation;

public class DaoTest {

	FirestationDAO dao = new FirestationDAO();
	
	@Test
	void TestDaoFindAll() {
		assertNotNull(dao.findAll());
		
	}
	
	@Test
	void TestDaoFindTheAddressOfTheFirstFiresation() {
		String firestation = dao.findAll().get(0).getAddress();
		assertEquals(firestation,"1509 Culver St");
		
	}
	
	@Disabled
	@Test
	void TestDaoAddAFirestationAtTheEndOfTheList() {
		
	}
	
	@Test
	void testDAORemoveLastFirestationFromTheList() {
		
		int length = dao.findAll().size();
		assertEquals(12, length);
	}
	
}
