package com.hfinoux.SafetyNetAlerts.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hfinoux.SafetyNetAlerts.model.Data;
import com.hfinoux.SafetyNetAlerts.model.Medicalrecord;
import com.hfinoux.SafetyNetAlerts.model.Person;
import com.hfinoux.SafetyNetAlerts.model.PersonsSupervisedByFirestation;
import com.hfinoux.SafetyNetAlerts.utils.Utils;

@Repository
public class PersonsSupervisedByFirestationDAOImpl implements PersonsSupervisedByFirestationDAO {
	
	private static Logger LOGGER = LogManager.getLogger(PersonsSupervisedByFirestationDAOImpl.class);

	Data data = Data.getInstance();
	List<Person> persons = data.getPersons();
	List<Medicalrecord> medicalrecords = data.getMedicalrecords();

	Utils utils = new Utils();

	@Autowired
	FirestationDAO firestationDAO;

	/**
	 * This method will return a list of people supervised by a station and the number of adults and children.
	 * @param stationNumber
	 * @return a PersonsSupervisedByFirestation
	 */
	@Override
	public PersonsSupervisedByFirestation findByStationNumber(int stationNumber) {

		PersonsSupervisedByFirestation result = new PersonsSupervisedByFirestation();

		List<String> streets = firestationDAO.findById(stationNumber);
		List<Person> peopleSearched = new ArrayList<>();
		int adults = 0;
		int children = 0;

		if (streets != null) {
			for (String street : streets) { // pour chaque rue supervisée par la station
				for (int i = 0; i < persons.size(); i++) { // parcours la liste de toutes les personnes
					if (persons.get(i).getAddress().equals(street)) { // pour trouver celles pour lesquelles la rue est
																		// supervisée
						peopleSearched.add(persons.get(i)); // ajouter chaque personne à la liste
					}
				}
			}

			for (Person person : peopleSearched) { // pour les personnes trouvées
				for (int j = 0; j < medicalrecords.size(); j++) { // parcours la liste des medicalrecords
					if (person.getFirstName().equals(medicalrecords.get(j).getFirstName())
							&& (person.getLastName().equals(medicalrecords.get(j).getLastName()))) // si même prénom,
																									// même nom
					{
						String birthdate = medicalrecords.get(j).getBirthdate(); // récupère la date de naissance pour
																					// calculer l'âge
						int age = utils.calculateAge(birthdate);

						if (age > 18) {
							adults++;
						} else {
							children++;
						}
					}
				}
			}
			result.setPersons(peopleSearched);
			result.setAdults(adults);
			result.setChildren(children);
		} else {
			LOGGER.info("This stationNumber "+stationNumber +" doesn't supervise anyone.");
			return null;
		}	
			LOGGER.info("These people are supervised by the stationNumber "+".");
			return result;
	}

}
