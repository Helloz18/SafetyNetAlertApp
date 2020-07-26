package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.Address;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

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

	public Map<String, List<PersonWithAgeAndMedicalRecords>> getPersonsByAddressForAstationNumber(
			List<Integer> stationNumbers) {

		// Map<String, MappingJacksonValue> result = new HashMap<>();
		Map<String, List<PersonWithAgeAndMedicalRecords>> result = new HashMap<>();

		for (int stationNumber : stationNumbers) { // pour chaque numéro de station
			List<String> addresses = firestationDAO.findById(stationNumber);// récupère les addresses (sans doublons)

			for (int i = 0; i < addresses.size(); i++) {// pour chaque addresse
				// récupère la liste des personnes de cette addresse
				List<PersonWithAgeAndMedicalRecords> personsInThisAddress = personWithAgeAndMedicalRecordsDAO
						.findByAddress(addresses.get(i));
				List<PersonWithAgeAndMedicalRecords> p = new ArrayList<>();
				for (int j = 0; j < personsInThisAddress.size(); j++) {

					if (personsInThisAddress.get(j).getStationNumber() == stationNumber) {
						p.add(personsInThisAddress.get(j));
					}
					result.put(addresses.get(i), p);
				}
			}
		}
		return result;
	}
}
