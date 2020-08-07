package com.hfinoux.SafetyNetAlerts.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hfinoux.SafetyNetAlerts.dao.PersonWithAgeAndMedicalRecordsDAO;
import com.hfinoux.SafetyNetAlerts.model.PersonWithAgeAndMedicalRecords;

@SpringBootTest
class PersonWithAgeAndMedicalRecordsDAOTest {
	
	@Autowired
	PersonWithAgeAndMedicalRecordsDAO pWaAmRDAO;

	@Test
	void getTheFirstMedicationOfTheFirstPersonFromAnAddress() {
		//GIVEN
		String address = "951 LoneTree Rd";
		//WHEN
		String result = pWaAmRDAO.findByAddress(address).get(0).getMedicalrecords().getMedications().get(0);
		//THEN
		assertEquals(result, "tradoxidine:400mg");
	}

	@Test
	void returnEmptyListIfAddressDoesntExist() {
		//GIVEN
		String address = "unknown";
		//WHEN
		List<PersonWithAgeAndMedicalRecords> result = pWaAmRDAO.findByAddress(address);
		//THEN
		assertEquals(result.size(), 0 );
	}
}
