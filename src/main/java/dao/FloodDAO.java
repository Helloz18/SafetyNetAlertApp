package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Data;
import model.Person;
import model.PersonWithAgeAndMedicalRecords;

public class FloodDAO {
	
	FirestationDAO firestationDAO = new FirestationDAO();
	PersonWithAgeAndMedicalRecordsDAO personWithAgeAndMedicalRecordsDAO = new PersonWithAgeAndMedicalRecordsDAO();
	
	public Map<String, List<Person>> test() {
		
		List<Person> p = Data.getInstance().getPersons();
		
		Map<String, List<Person>> result = new HashMap<>();
		result.put(Data.getInstance().getPersons().get(1).getAddress(), p);
		
		return result;
		
	}

	public Map<String, List<PersonWithAgeAndMedicalRecords>> getPersonsByAddressForAstationNumber(List<Integer> stationNumbers) {
		
		Map<String, List<PersonWithAgeAndMedicalRecords>> result = new HashMap<>();
				
		for (int stationNumber : stationNumbers) { //pour chaque numéro de station
			List<String> addresses = firestationDAO.findById(stationNumber);//récupère les addresses (sans doublons)			

			for (String address : addresses) {// pour chaque addresse
				//récupère la liste des personnes de cette addresse			
				List<PersonWithAgeAndMedicalRecords> personsInThisAddress = personWithAgeAndMedicalRecordsDAO.findByAddress(address);			
				
				
				//Si le numéro de station est différent de ceux demandés, ne mets pas deux fois la même personne
				// pourquoi Ron Peters station 4 apparait toujours lorsque l'on demande la station 3 ??
				for (int i=0; i<personsInThisAddress.size(); i++) {
					if (personsInThisAddress.get(i).getStationNumber() != stationNumber) {
						personsInThisAddress.remove(personsInThisAddress.get(i));
						}				
				}
				result.put(address, personsInThisAddress);					
			}

		}
		return result;
	}
}
