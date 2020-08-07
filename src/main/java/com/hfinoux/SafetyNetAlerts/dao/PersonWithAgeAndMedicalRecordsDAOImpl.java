package com.hfinoux.SafetyNetAlerts.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hfinoux.SafetyNetAlerts.model.Data;
import com.hfinoux.SafetyNetAlerts.model.Firestation;
import com.hfinoux.SafetyNetAlerts.model.Medicalrecord;
import com.hfinoux.SafetyNetAlerts.model.Person;
import com.hfinoux.SafetyNetAlerts.model.PersonWithAgeAndMedicalRecords;
import com.hfinoux.SafetyNetAlerts.utils.Utils;

@Repository
public class PersonWithAgeAndMedicalRecordsDAOImpl implements PersonWithAgeAndMedicalRecordsDAO {

	private static Logger LOGGER = LogManager.getLogger(PersonWithAgeAndMedicalRecordsDAOImpl.class);
	
	Data data = Data.getInstance();
	List<Person> persons = data.getPersons();
	List<Medicalrecord> medicalrecords = data.getMedicalrecords();
	@Autowired
	PersonDAO personDAO;
	@Autowired
	FirestationDAO firestationDAO;
	Utils utils = new Utils();

	/**
	 * This method will select all people living in an address and return them as a list with their age and medicalrecords.
	 * @param address
	 * @return a list of PersonWithAgeAndMedicalRecords.
	 */
	@Override
	public List<PersonWithAgeAndMedicalRecords> findByAddress(String address) {

		List<PersonWithAgeAndMedicalRecords> result = new ArrayList<>();

		List<Person> personsInThisAddress = personDAO.findByAddress(address);
		List<Firestation> allFirestations = firestationDAO.findAll();

		if (allFirestations != null) {
			for (Firestation firestation : allFirestations) {
				if (firestation.getAddress().equals(address)) {
					int stationNumber = firestation.getStation();

					for (Person person : personsInThisAddress) {
						for (int i = 0; i < medicalrecords.size(); i++) {
							if (person.getFirstName().equals(medicalrecords.get(i).getFirstName())
									&& (person.getLastName().equals(medicalrecords.get(i).getLastName()))) {
								String birthdate = medicalrecords.get(i).getBirthdate();
								int age = utils.calculateAge(birthdate);

								PersonWithAgeAndMedicalRecords p = new PersonWithAgeAndMedicalRecords();

								p.setPerson(person);
								p.setAge(age);
								p.setMedicalrecords(medicalrecords.get(i));
								p.setStationNumber(stationNumber);
								if (!result.contains(p)) {
									result.add(p);
								}
							}
						}
					}
				}
			}
		} else {
			LOGGER.info("No one is living in "+address+".");
			return null;
		}
		LOGGER.info("People living in "+ address+".");
		return result;
	}
}
