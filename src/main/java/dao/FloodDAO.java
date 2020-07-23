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
		for(int stationNumber : stationNumbers) {
		List<String> addresses = firestationDAO.findById(stationNumber);
		
			for(String address : addresses) {
				List<PersonWithAgeAndMedicalRecords> p = personWithAgeAndMedicalRecordsDAO.findByAddress(address);		
				result.put(address, p);		
		}}
		return result;
		}
}
