package com.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.ChildWithAgeAndMembersOfFamilyDAO;
import model.ChildWithAgeAndMembersOfFamily;

class ChildWithAgeAndMembersOfFamilyDAOTest {

	ChildWithAgeAndMembersOfFamilyDAO cWaAmOfDAO = new ChildWithAgeAndMembersOfFamilyDAO();
	
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
