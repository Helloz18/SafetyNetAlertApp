package controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.FirestationDAO;
import model.Firestation;

@RestController
public class FirestationController {


	FirestationDAO firestationDAO = new FirestationDAO();
	
	@GetMapping("/firestations")
	public List<Firestation> firestation() {
		return firestationDAO.findAll();
	}
}
