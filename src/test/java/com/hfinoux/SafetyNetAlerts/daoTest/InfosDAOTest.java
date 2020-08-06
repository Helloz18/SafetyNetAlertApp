package com.hfinoux.SafetyNetAlerts.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.hfinoux.SafetyNetAlerts.dao.InfosDAO;

class InfosDAOTest {

	InfosDAO infosDAO = new InfosDAO();
	
	@Test
	void getsTheFirstEmailForTheCity() {
		//GIVEN
		String city = "Culver";
		//WHEN
		String email = infosDAO.emailsForAcity(city).get(0);
		//THEN
		assertEquals(email, "jaboyd@email.com" );
	}

	@Test
	void returnEmptyIfTheCityDoesntExist() {
		//GIVEN
		String city = "Unknown";
		//WHEN
		List<String> emails = infosDAO.emailsForAcity(city);
		//THEN
		assertEquals(emails.size(), 0);
	}

}
