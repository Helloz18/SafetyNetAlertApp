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



	@GetMapping("/childAlert")
	public List<ChildWithAgeAndMembersOfFamily> getChildrenInThisAddress(@RequestParam(value="address", required=true) String address){
		return redao.findByAddress(address);
	}
	
	@GetMapping("/phoneAlert")
	public List<String> getPeoplePhoneForAstationNumber(@RequestParam(value="firestation", required=true) int stationNumber) {
		return phoneDAO.getPhoneForAstationNumber(stationNumber);	
			
		}
}
