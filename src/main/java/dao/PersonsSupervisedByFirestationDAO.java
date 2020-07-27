package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Data;
import model.Medicalrecord;
import model.Person;
import model.PersonsSupervisedByFirestation;
import utils.Utils;

@Service
public class PersonsSupervisedByFirestationDAO {

	Data data = Data.getInstance();
	List<Person> persons = data.getPersons();
	List<Medicalrecord> medicalrecords = data.getMedicalrecords();

	Utils utils = new Utils();

	FirestationDAO firestationDAO = new FirestationDAO();

	public PersonsSupervisedByFirestation findByStationNumber(int station) {

		PersonsSupervisedByFirestation result = new PersonsSupervisedByFirestation();

		List<String> streets = firestationDAO.findById(station);
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
			return null;
		}	
			return result;
	}

}
