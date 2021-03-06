package com.hfinoux.SafetyNetAlerts.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hfinoux.SafetyNetAlerts.dao.ChildWithAgeAndMembersOfFamilyDAO;
import com.hfinoux.SafetyNetAlerts.model.ChildWithAgeAndMembersOfFamily;


@SpringBootTest
class ChildWithAgeAndMembersOfFamilyDAOTest {

	@Autowired
	ChildWithAgeAndMembersOfFamilyDAO cWaAmOfDAO;
	
	@Test
	void getTheFirstChildWithHisAgeAndTheMembersOfHisFamilyFromAnAddress() {
		//GIVEN
		String address = "1509 Culver St";
		//WHEN
		String firstChildFirstName = cWaAmOfDAO.findByAddress(address).get(0).getChild().getFirstName();
		String firstChildLastName = cWaAmOfDAO.findByAddress(address).get(0).getChild().getLastName();
		int firstChildAge = cWaAmOfDAO.findByAddress(address).get(0).getAge();
		//THEN
		assertEquals(firstChildFirstName,"Tenley");
		assertEquals(firstChildLastName, "Boyd");
		assertEquals(firstChildAge, 8);
	}

	@Test
	void returnEmptyIfAddressDoesntExist() {
		//GIVEN
		String address = "Unknown";
		//WHEN
		List<ChildWithAgeAndMembersOfFamily> emptyList = cWaAmOfDAO.findByAddress(address);
		//THEN
		assertEquals(emptyList.size(), 0);
	}
}
