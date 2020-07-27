package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Data;
import model.Firestation;
import model.Medicalrecord;
import model.Person;
import model.PersonWithAgeAndMedicalRecords;
import utils.Utils;

@Service
public class PersonWithAgeAndMedicalRecordsDAO {

	Data data = Data.getInstance();
	List<Person> persons = data.getPersons();
	List<Medicalrecord> medicalrecords = data.getMedicalrecords();
	PersonDAO personDAO = new PersonDAO();
	FirestationDAO firestationDAO = new FirestationDAO();
	Utils utils = new Utils();

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
			return null;
		}
		return result;
	}
}
