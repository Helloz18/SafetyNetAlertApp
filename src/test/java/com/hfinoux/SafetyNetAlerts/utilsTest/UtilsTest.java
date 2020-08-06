package com.hfinoux.SafetyNetAlerts.utilsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import com.hfinoux.SafetyNetAlerts.utils.Utils;


public class UtilsTest {
	
	String birthdate = "01/01/2000";
	
	@Test
	void testCalculateAgeFromBirthdayStringShouldReturn20() throws ParseException {
		//GIVEN
		LocalDate today = LocalDate.now();
		//WHEN
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birth = LocalDate.parse(birthdate, formatter);	
		int result = Period.between(birth, today).getYears();
		//THEN
		assertEquals(20, result);				
	}
	
	@Test
	void testCalculateAge() {
		//GIVEN
		Utils utils = new Utils();
		//WHEN
		int result = utils.calculateAge(birthdate);
		//THEN
		assertEquals(20, result);
	}

}
