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
		//aujourd'hui
		LocalDate today = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birth = LocalDate.parse(birthdate, formatter);
	
		int result = Period.between(birth, today).getYears();
		 
		assertEquals(20, result);				
	}
	
	@Test
	void testCalculateAge() {
		Utils utils = new Utils();
		int result = utils.calculateAge(birthdate);
		
		assertEquals(20, result);
	}

}
