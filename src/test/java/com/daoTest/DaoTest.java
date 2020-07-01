package com.daoTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import dao.FirestationDAO;

public class DaoTest {

	FirestationDAO dao = new FirestationDAO();
	
	@Test
	void TestDaoFindAll() {
		assertNotNull(dao.findAll());
		
	}
	
	
	
}
