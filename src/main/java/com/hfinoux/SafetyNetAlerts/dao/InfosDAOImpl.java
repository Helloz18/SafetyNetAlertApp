package com.hfinoux.SafetyNetAlerts.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.hfinoux.SafetyNetAlerts.model.Data;
import com.hfinoux.SafetyNetAlerts.model.Person;

@Repository
public class InfosDAOImpl implements InfosDAO {

	private static Logger LOGGER = LogManager.getLogger(InfosDAOImpl.class);
	
	List<Person> persons = Data.getInstance().getPersons();
	
	/**
	 * This method will be used to get all the emails of people living in a city.
	 * @param city
	 * @return a list of emails.
	 */
	@Override
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
		}if(emails.size() == 0) {
			LOGGER.error("No email to write to.");
		} else {
			LOGGER.info("Emails to write to.");
		}	
		return emails;
		
	}
}
