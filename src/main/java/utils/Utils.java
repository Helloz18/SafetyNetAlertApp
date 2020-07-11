package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Utils {

	//TODO méthode qui convertit "01/01/2000" en format date
	
	public int calculateAge(String birthdate) {
		LocalDate today = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birth = LocalDate.parse(birthdate, formatter);
	
		int result = Period.between(birth, today).getYears();
		
		return result;
	
	}
}
