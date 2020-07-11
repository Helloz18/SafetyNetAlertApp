package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dao.PersonsSupervisedByFirestationDAO;

@RestController
public class PersonsSupervisedController {
	
	PersonsSupervisedByFirestationDAO dao = new PersonsSupervisedByFirestationDAO();

	@GetMapping("/test/{station_number}")
	public List<String> findByStation(@PathVariable int station_number) {
		return dao.findById(station_number);
	}
	
}
