package controller;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dao.FirestationDAO;
import dao.PersonsSupervisedByFirestationDAO;
import model.Firestation;

@RestController
public class FirestationController {


	FirestationDAO firestationDAO = new FirestationDAO();
	
	PersonsSupervisedByFirestationDAO dao = new PersonsSupervisedByFirestationDAO();
	
	@GetMapping("/firestations-infos")
	public List<Firestation> firestations() {
		return firestationDAO.findAll();
	}
	
	@GetMapping("/firestation/{station}")
	public List<String> findByStation(@PathVariable int station) {
		return firestationDAO.findById(station);
	}
	
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
	
	@GetMapping("/firestation")
	public List<String> findPeopleByStation(@RequestParam(value="stationNumber", required=true) int station) {
		List<String> peopleForThisStation = dao.findById(station);
		if (peopleForThisStation == null) {
			return null;
		}
		else return peopleForThisStation;
			
		}

}
