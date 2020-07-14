package controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.PersonsSupervisedByFirestationDAO;
import dao.PhoneDAO;
import model.PersonsSupervisedByFirestation;

@RestController
public class AlertController {
	
	PersonsSupervisedByFirestationDAO dao = new PersonsSupervisedByFirestationDAO();
	PhoneDAO phoneDAO = new PhoneDAO();

	//@GetMapping("/childAlert")
	//public ChildInAddress findByAddress(@PathVariable String address) {
		//return dao.findByStationNumber(station_number);
	//}

	
	@GetMapping("/phoneAlert")
	public List<String> getPeoplePhoneForAstationNumber(@RequestParam(value="firestation", required=true) int stationNumber) {
		return phoneDAO.getPhoneForAstationNumber(stationNumber);	
			
		}
}
