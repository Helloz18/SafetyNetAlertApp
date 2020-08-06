package com.hfinoux.SafetyNetAlerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hfinoux.SafetyNetAlerts.dao.InfosDAO;

@RestController
public class CommunityController {
	
	@Autowired
	InfosDAO infosDAO;
	
	/**
	 * This URL returns a list of Email of the persons living in a city.
	 * If several persons have the same Email, the list will show this Email only once.
	 * @param city
	 * @return a list of String "email"
	 */
	@GetMapping("/communityEmail")
	public List<String> getEmaisForAcity(@RequestParam(value="city", required=true) String city) {
		return infosDAO.emailsForAcity(city);		
		}
}
