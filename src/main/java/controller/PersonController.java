package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.PersonDAO;
import model.PersonInfos;

@RestController
public class PersonController {
	
	PersonDAO personDao = new PersonDAO();

	@GetMapping("/personInfos")
	public List<PersonInfos> getPersonWithInfos(
			@RequestParam(value="firstName", required= true) String firstName,
			@RequestParam(value="lastName", required=true) 	 String lastName){
			
		return personDao.findByFirstNameAndLastName(firstName, lastName);
		
	}
	
}
