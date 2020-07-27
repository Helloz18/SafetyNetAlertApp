package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.FloodDAO;
import model.PersonWithAgeAndMedicalRecords;

@RestController
public class FloodController {
	
	@Autowired
	FloodDAO floodDAO;

	/**
	 * This URL will arrange people by their addresses
	 * @param stationNumbers : a list of stationNumbers, (for example : 1,2,3)
	 * @return a list of addresses that contains a list of persons with age and medicalrecords
	 */
	@GetMapping("/flood/stations")
	public Map<String, List<PersonWithAgeAndMedicalRecords>> getPersonsByAddressForAstationNumber(
			@RequestParam(value="stations", required=false) List<Integer> stationNumbers ){
		
		return floodDAO.getPersonsByAddressForAstationNumber(stationNumbers);
		   
	}
}
