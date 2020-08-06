package com.hfinoux.SafetyNetAlerts.controller;

import java.net.URI;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hfinoux.SafetyNetAlerts.dao.MedicalrecordDAO;
import com.hfinoux.SafetyNetAlerts.model.Medicalrecord;

@RestController
public class MedicalrecordController {
	
	private static Logger LOGGER = LogManager.getLogger(MedicalrecordController.class);

	@Autowired
	MedicalrecordDAO medicalrecordDAO;

	/**
	 * 
	 * @return all medicalrecords.
	 */
	@GetMapping("/allMedicalrecords")
	public List<Medicalrecord> getMedicalrecords() {
		LOGGER.info("The list of medicalrecords.");
		return medicalrecordDAO.findAll();
	}

		/**
	 * A medicalrecord is composed by a firstName, lastName, birthdate, list of medications, list of allergies.
	 * @param medicalrecord
	 */
	@PostMapping("/medicalRecord")
	public ResponseEntity<Void> addMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
		Medicalrecord newMedicalrecord = medicalrecordDAO.save(medicalrecord);

		if (medicalrecord == null)
			return ResponseEntity.noContent().build();

		URI location = 
				ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{firstName}")
				.buildAndExpand(newMedicalrecord.getFirstName())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * This method update a medicalrecord, change birthdate, medications or allergies.
	 * @param medicalrecord
	 */
	@PutMapping("/medicalRecord")
	public ResponseEntity<Void> updateMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
		medicalrecordDAO.update(medicalrecord);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/**
	 * This method removes a medicalrecord from the list of medicalrecords.
	 * @param medicalrecord
	 */
	@DeleteMapping("/medicalRecord")
	public ResponseEntity<Void> removeMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
		medicalrecordDAO.delete(medicalrecord);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
