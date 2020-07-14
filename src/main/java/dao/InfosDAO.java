package dao;

import java.util.ArrayList;
import java.util.List;

import model.Data;
import model.Person;

public class InfosDAO {

	
	List<Person> persons = Data.getInstance().getPersons();
	
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
