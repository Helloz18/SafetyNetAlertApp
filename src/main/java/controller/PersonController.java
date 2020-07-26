package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.FloodDAO;
import dao.PersonDAO;
import model.PersonInfos;
import model.PersonWithAgeAndMedicalRecords;

@RestController
public class PersonController {
	
	@Autowired
	PersonDAO personDao;

	/**
	 * This url returns the informations of a person : address, age and medical-records.
	 * If several people have the same name and first-name, they will appear in the list.
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	@GetMapping("/personInfos")
	public List<PersonInfos> getPersonWithInfos(
			@RequestParam(value="firstName", required= true) String firstName,
			@RequestParam(value="lastName", required=true) 	 String lastName){
			
		return personDao.findByFirstNameAndLastName(firstName, lastName);
		
	}
	
	@GetMapping("/flood/stations")
	public Map<String, List<PersonWithAgeAndMedicalRecords>> gettest(@RequestParam(value="stations", required=false) List<Integer> stationNumbers ){
		FloodDAO flood = new FloodDAO();
		return flood.getPersonsByAddressForAstationNumber(stationNumbers);

		   
	}
}
