package com.hfinoux.SafetyNetAlerts.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hfinoux.SafetyNetAlerts.dao.ChildWithAgeAndMembersOfFamilyDAO;
import com.hfinoux.SafetyNetAlerts.dao.PersonsSupervisedByFirestationDAO;
import com.hfinoux.SafetyNetAlerts.dao.PhoneDAO;
import com.hfinoux.SafetyNetAlerts.model.ChildWithAgeAndMembersOfFamily;

@RestController
public class AlertController {
		
	@Autowired
	PersonsSupervisedByFirestationDAO dao;
	@Autowired
	PhoneDAO phoneDAO;
	@Autowired
	ChildWithAgeAndMembersOfFamilyDAO redao;

	/**
	 * This URL will return the list of chidren living in an address.
	 * The list of the rest of the persons living in this address will be set for each child.
	 * @param address
	 * @return a list of chidren.
	 */
	@GetMapping("/childAlert")
	public ResponseEntity<List<ChildWithAgeAndMembersOfFamily>> getChildrenInThisAddress(
			@RequestParam(value="address", required=true) String address){
		
		List<ChildWithAgeAndMembersOfFamily> children =  redao.findByAddress(address);
		
		if (children == null)
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(children);
	}
	
		
	/**
	 * This URL will return a list of phoneNumber of people supervised by a stationNumber.
	 * A stationNumber supervise several addresses. 
	 * If some people have the same phoneNumber, the list will only show this phoneNumber once.
	 * @param stationNumber
	 * @return a list of phoneNumber.
	 */
	@GetMapping("/phoneAlert")
	public List<String> getPeoplePhoneForAstationNumber(
			@RequestParam(value="firestation", required=true) int stationNumber) {
		return phoneDAO.getPhoneForAstationNumber(stationNumber);				
	}
}
