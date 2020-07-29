package com.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.MedicalrecordDAO;
import model.Data;
import model.Medicalrecord;

class MedicalrecordDAOTest {

MedicalrecordDAO medicalrecordDAO = new MedicalrecordDAO();
	
	List<Medicalrecord> medicalrecords = Data.getInstance().getMedicalrecords();
	
	@Test
	void medicalrecordDaoFindAll() {
		//GIVEN //WHEN // THEN
		assertNotNull(medicalrecordDAO.findAll());		
	}
	
	@Test
	void findTheFirstNameOfTheFirstPersonFromTheListMedicalrecords() {
		//GIVEN
		//WHEN
		String firstName = medicalrecordDAO.findAll().get(0).getFirstName();
		//THEN
		assertEquals(firstName,"John");
		
	}
		
}
