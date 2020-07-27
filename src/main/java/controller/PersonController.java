package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.PersonDAO;
import model.PersonInfos;

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
	
}
