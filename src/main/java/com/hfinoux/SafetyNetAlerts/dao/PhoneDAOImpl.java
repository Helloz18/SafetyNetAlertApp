package com.hfinoux.SafetyNetAlerts.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hfinoux.SafetyNetAlerts.model.Data;
import com.hfinoux.SafetyNetAlerts.model.Person;

@Repository
public class PhoneDAOImpl implements PhoneDAO {

	private static Logger LOGGER = LogManager.getLogger(PhoneDAOImpl.class);

	@Autowired
	FirestationDAO firestationDAO;
	/**
	 * This method will list the phoneNumbers of people supervised by a station.
	 * @param stationNumber
	 * @return a list of String phoneNumber.
	 */
	@Override
	public List<String> getPhoneForAstationNumber(int stationNumber) {
		List<Person> persons = Data.getInstance().getPersons();
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
			LOGGER.info("No phoneNumber to call.");
			return null;
		}
		LOGGER.info("The list of phoneNumbers to call.");
		return phonesNumber;

	}

}
