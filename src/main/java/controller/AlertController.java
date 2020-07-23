package controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.PersonsSupervisedByFirestationDAO;
import dao.ChildWithAgeAndMembersOfFamilyDAO;
import dao.PhoneDAO;
import model.PersonsSupervisedByFirestation;
import model.ChildWithAgeAndMembersOfFamily;

@RestController
public class AlertController {
	
	PersonsSupervisedByFirestationDAO dao = new PersonsSupervisedByFirestationDAO();
	PhoneDAO phoneDAO = new PhoneDAO();
	ChildWithAgeAndMembersOfFamilyDAO redao = new ChildWithAgeAndMembersOfFamilyDAO();


	/**
	 * This url will return the list of chidren living in an address.
	 * The list of the rest of the persons living in this address will be set for each child.
	 * @param address
	 * @return
	 */
	@GetMapping("/childAlert")
	public List<ChildWithAgeAndMembersOfFamily> getChildrenInThisAddress(@RequestParam(value="address", required=true) String address){
		return redao.findByAddress(address);
	}
	
	/**
	 * This url will return a list of phoneNumber of people supervised by a stationNumber.
	 * A stationNumber supervise several addresses. 
	 * If some people have the same phoneNumber, the list will only show this phoneNumber once.
	 * @param stationNumber
	 * @return
	 */
	@GetMapping("/phoneAlert")
	public List<String> getPeoplePhoneForAstationNumber(@RequestParam(value="firestation", required=true) int stationNumber) {
		return phoneDAO.getPhoneForAstationNumber(stationNumber);				
	}
}