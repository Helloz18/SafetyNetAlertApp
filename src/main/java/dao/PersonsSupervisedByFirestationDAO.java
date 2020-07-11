package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Data;
import model.Firestation;
import model.Medicalrecord;
import model.Person;
import model.PersonsSupervisedByFirestation;
import utils.Utils;

@Service
public class PersonsSupervisedByFirestationDAO implements InterfaceDAO<PersonsSupervisedByFirestation> {
	
	Data data = Data.getInstance();
	List<Person> persons = data.getPersons();
	List<Firestation> firestations = data.getFirestations();
	List<Medicalrecord> medicalrecords = data.getMedicalrecords();
	
	FirestationDAO firestationDAO = new FirestationDAO();

	@Override
	public List<String> findById(int station) {
		
		List <String> streets = firestationDAO.findById(station);
		List <String> peopleSearched = new ArrayList<>();
		int adults = 0;
		int children = 0;
		for(int j=0; j<streets.size(); j++) {
			for(int i =0; i<persons.size(); i++) {
				if(persons.get(i).getAddress().equals(streets.get(j))) {
					peopleSearched.add(persons.get(i).getFirstName());
					peopleSearched.add(persons.get(i).getLastName());
					peopleSearched.add(persons.get(i).getAddress());
					peopleSearched.add(persons.get(i).getPhone());
			// à revoir : attention si l'ordre ne correspond pas dans le json, il faudrait chercher la date par le prénom + nom
					peopleSearched.add(medicalrecords.get(i).getBirthdate());
			
					Utils utils = new Utils();
					int age = utils.calculateAge(medicalrecords.get(i).getBirthdate());		
			
					if (age > 18) {
						adults++;
						peopleSearched.add("adult" + adults);
					}else {
						children++;
						peopleSearched.add("child" + children);
					}
					
				}
			}
				
		}if (peopleSearched.size() != 0) {
				return peopleSearched;	

				}else {
					return null;
				}
		
	}

	


	@Override
	public PersonsSupervisedByFirestation save(PersonsSupervisedByFirestation model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PersonsSupervisedByFirestation model, String param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PersonsSupervisedByFirestation model) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public List<PersonsSupervisedByFirestation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
