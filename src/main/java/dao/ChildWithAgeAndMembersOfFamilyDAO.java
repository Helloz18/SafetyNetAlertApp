package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.ChildWithAgeAndMembersOfFamily;
import model.Data;
import model.Medicalrecord;
import model.Person;
import utils.Utils;

@Service
public class ChildWithAgeAndMembersOfFamilyDAO {

	
	Data data = Data.getInstance();
	List<Person> persons = data.getPersons();
	List<Medicalrecord> medicalrecords = data.getMedicalrecords();
	PersonDAO personDAO = new PersonDAO();
	Utils utils = new Utils();
	
	/**
	 * This method will get all the people living in an address, calculate their age and
	 * return a list of children with their age and members of family.
	 * @param address
	 * @return a list of children with their age and members of family
	 */
	public List<ChildWithAgeAndMembersOfFamily> findByAddress(String address) {
	
		List<ChildWithAgeAndMembersOfFamily> childrenWithAge = new ArrayList<>();
		
		List<Person> personsInThisAddress = personDAO.findByAddress(address);

		for (Person person : personsInThisAddress) {
			for (int i = 0; i < medicalrecords.size(); i++) {
				if (person.getFirstName().equals(medicalrecords.get(i).getFirstName())
						&& (person.getLastName().equals(medicalrecords.get(i).getLastName()))) {
					String birthdate = medicalrecords.get(i).getBirthdate();
					int age = utils.calculateAge(birthdate);
					Person child = new Person();

					if (age < 18) {
						ChildWithAgeAndMembersOfFamily p = new ChildWithAgeAndMembersOfFamily();
						p.setAge(age);
						child.setFirstName(medicalrecords.get(i).getFirstName());
						child.setLastName(medicalrecords.get(i).getLastName());
						p.setChild(child);
						personsInThisAddress.remove(child);
						p.setMemberOfFamily(personsInThisAddress);

						childrenWithAge.add(p);
					}
				}
			}
		}
		return childrenWithAge;

	}
}
