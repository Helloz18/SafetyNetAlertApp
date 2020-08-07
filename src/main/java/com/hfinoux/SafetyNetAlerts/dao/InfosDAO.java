package com.hfinoux.SafetyNetAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface InfosDAO {

	/**
	 * This method will be used to get all the emails of people living in a city.
	 * @param city
	 * @return a list of emails.
	 */
	List<String> emailsForAcity(String city);

}