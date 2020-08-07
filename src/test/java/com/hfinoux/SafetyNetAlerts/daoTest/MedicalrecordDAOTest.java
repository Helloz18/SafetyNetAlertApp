package com.hfinoux.SafetyNetAlerts.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hfinoux.SafetyNetAlerts.dao.MedicalrecordDAO;
import com.hfinoux.SafetyNetAlerts.model.Data;
import com.hfinoux.SafetyNetAlerts.model.Medicalrecord;

@SpringBootTest
class MedicalrecordDAOTest {

	@Autowired
	MedicalrecordDAO medicalrecordDAO;
	
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
