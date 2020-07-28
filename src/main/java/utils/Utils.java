package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Utility class
 *
 */
public class Utils {

	/**
	 * This method will calculate an age from a birthdate from a pattern MM/dd/yyyy.
	 * @param birthdate
	 * @return a int age.
	 */
	public int calculateAge(String birthdate) {
		LocalDate today = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birth = LocalDate.parse(birthdate, formatter);
	
		int result = Period.between(birth, today).getYears();
		
		return result;
	
	}
}
