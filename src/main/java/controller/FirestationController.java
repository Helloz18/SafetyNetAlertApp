package controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dao.FirestationDAO;
import dao.PersonWithAgeAndMedicalRecordsDAO;
import dao.PersonsSupervisedByFirestationDAO;
import model.Firestation;
import model.PersonWithAgeAndMedicalRecords;
import model.PersonsSupervisedByFirestation;

@RestController
public class FirestationController {

	@Autowired
	FirestationDAO firestationDAO;
	@Autowired
	PersonsSupervisedByFirestationDAO dao;	
	@Autowired
	PersonWithAgeAndMedicalRecordsDAO pwamrDAO;
	
	/**
	 * This URL will return all the addresses with the station-number set to supervise this address.
	 * An address can be supervised by several stations.
	 * @return a list of "adress with station-number"
	 */
	
	@GetMapping("/firestations-infos")
	public List<Firestation> firestations() {
		return firestationDAO.findAll();
	}
	
	/**
	 * This URL returns a list of the different addresses supervised by a station-number.
	 * @param stationNumber
	 * @return list of addresses
	 */
	@GetMapping("/firestation/{stationNumber}")
	public List<String> findByStation(@PathVariable int stationNumber) {
		return firestationDAO.findById(stationNumber);
	}
	
	/**
	 * A firestation is composed by an address and an station-number.
	 * @param firestation
	 */
	@PostMapping("/firestation")
	public ResponseEntity<Void> addStreetSuperVisedByAstation(@RequestBody Firestation firestation) {
		Firestation streetAndStation = firestationDAO.save(firestation);
		
		if (streetAndStation == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{address}")
                .buildAndExpand(streetAndStation.getAddress())
                .toUri();

        return ResponseEntity.created(location).build();
    }

	/**
	 * This method update a firestation, change an address or an id of a firestation.
	 * @param firestation
	 */
	@PutMapping("/firestation")
	public ResponseEntity<Void> updateFirestationByAstation(@RequestBody Firestation firestation) {
		firestationDAO.update(firestation);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * This method removes a firestation from the list of firestations.
	 * @param firestation
	 */
	@DeleteMapping("/firestation")
	public ResponseEntity<Void> removeFirestationByAstation(@RequestBody Firestation firestation) {
		firestationDAO.delete(firestation);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * This URL returns a list of persons supervised by a stationNumber.
	 * A stationNumber supervise several addresses.
	 * @param stationNumber
	 * @return
	 */
	@GetMapping("/firestation")
	public ResponseEntity<PersonsSupervisedByFirestation> findPeopleByStation(
			@RequestParam(value="stationNumber", required=true) int stationNumber) {
		PersonsSupervisedByFirestation peopleForThisStation = dao.findByStationNumber(stationNumber);
		if (peopleForThisStation == null) {
			return null;
		}
		else return ResponseEntity.ok(peopleForThisStation);
			
	}	

	/**
	 * This URL will returns a list of "personWithAgeAndMedicalRecords" living at this address.
	 * @param address
	 * @return a list of person with age and medicalrecords.
	 */
	@GetMapping("/fire")
	public List <PersonWithAgeAndMedicalRecords> findPeopleFromAddress(@RequestParam(value="address", required=true) String address){
		return pwamrDAO.findByAddress(address);
	}

}
