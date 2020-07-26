package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Data;
import model.Medicalrecord;
import model.Person;
import model.PersonInfos;
import utils.Utils;

@Service
public class PersonDAO implements InterfaceDAO<Person>{

	List<Person> persons = Data.getInstance().getPersons();
	List<Medicalrecord> medicalrecords = Data.getInstance().getMedicalrecords();
	Utils utils = new Utils();
	

	@Override
	public List<Person> findAll() {
		return persons;
	}

	@Override
	public Person save(Person model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Person model, String param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Person model) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Person> findByAddress(String address) {
		List<Person> personsInThisAddress = new ArrayList<>();
		for(Person person : persons) {
			if(person.getAddress().equals(address)) {
				personsInThisAddress.add(person);				
			}
		}
		return personsInThisAddress;
	}

	public List<PersonInfos> findByFirstNameAndLastName(String firstName, String lastName) {

		List<PersonInfos> result = new ArrayList<>();

		for (Person person : persons) {
			for (int i = 0; i < medicalrecords.size(); i++) {
				if ((person.getFirstName().equals(firstName))
						&& ((firstName).equals(medicalrecords.get(i).getFirstName()))
						&& (person.getLastName().equals(lastName))
						&& ((lastName).equals(medicalrecords.get(i).getLastName()))) {
					String birthdate = medicalrecords.get(i).getBirthdate();
					int age = utils.calculateAge(birthdate);

					PersonInfos p = new PersonInfos();

					p.setPerson(person);
					p.setAge(age);
					p.setMedicalrecords(medicalrecords.get(i));
					result.add(p);
				}
			}
		}
		return result;
	}

}
