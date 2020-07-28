package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Data;
import model.Person;

@Service
public class InfosDAO {

	
	List<Person> persons = Data.getInstance().getPersons();
	
	/**
	 * This method will be used to get all the emails of people living in a city.
	 * @param city
	 * @return a list of emails.
	 */
	public List<String> emailsForAcity(String city){
		
		List <String> allEmails = new ArrayList<>();
		for(int i=0; i<persons.size(); i++) {
			if(!allEmails.contains(persons.get(i).getEmail())) {
			allEmails.add(persons.get(i).getEmail());
			}
		}
		
		List<String> emails = new ArrayList<>();
		
		for(Person person : persons) {
			for(String email : allEmails) {
				if(person.getCity().equals(city)) {
					if(!emails.contains(email)) {
						emails.add(email);
					}
				}
			}
		}
		return emails;
		
	}
}
