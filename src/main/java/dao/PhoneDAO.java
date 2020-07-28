package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Data;
import model.Person;

@Service
public class PhoneDAO {

	/**
	 * This method will list the phoneNumbers of people supervised by a station.
	 * @param stationNumber
	 * @return a list of String phoneNumber.
	 */
	public List<String> getPhoneForAstationNumber(int stationNumber) {
		List<Person> persons = Data.getInstance().getPersons();
		FirestationDAO firestationDAO = new FirestationDAO();
		List<String> streets = firestationDAO.findById(stationNumber);
		List<String> phonesNumber = new ArrayList<>();

		if (streets != null) {
			for (String street : streets) {
				for (Person person : persons) {
					if (person.getAddress().equals(street)) {
						if (!phonesNumber.contains(person.getPhone())) {
							phonesNumber.add(person.getPhone());
						}
					}
				}
			}
		} else {
			return null;
		}
		return phonesNumber;

	}

}
