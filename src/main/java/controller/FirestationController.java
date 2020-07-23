package controller;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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


	FirestationDAO firestationDAO = new FirestationDAO();
	
	PersonsSupervisedByFirestationDAO dao = new PersonsSupervisedByFirestationDAO();	
	PersonWithAgeAndMedicalRecordsDAO pwamrDAO = new PersonWithAgeAndMedicalRecordsDAO();
	
	/**
	 * This url will return all the addresses with the station-number set to supervise this address.
	 * An address can be supervised by several stations.
	 * @return a list of "adress whith station-number"
	 */
	
	@GetMapping("/firestations-infos")
	public List<Firestation> firestations() {
		return firestationDAO.findAll();
	}
	
	/**
	 * This url returns a list of the differents addresses supervised by a station-number.
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
	 * @return
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

/**TODO	@PutMapping()
 * 		@DeleteMapping()
 */
	
	/**
	 * This url returns a list of persons supervised by a stationNumber.
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
	


	
	@GetMapping("/fire")
	public List <PersonWithAgeAndMedicalRecords> findPeopleFromAddress(@RequestParam(value="address", required=true) String address){
		return pwamrDAO.findByAddress(address);
	}

}
