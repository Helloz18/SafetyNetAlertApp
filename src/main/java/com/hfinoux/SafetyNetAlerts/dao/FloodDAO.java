package com.hfinoux.SafetyNetAlerts.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.hfinoux.SafetyNetAlerts.model.PersonWithAgeAndMedicalRecords;

@Service
public class FloodDAO {
	
	private static Logger LOGGER = LogManager.getLogger(FloodDAO.class);
	
	FirestationDAO firestationDAO = new FirestationDAO();
	PersonWithAgeAndMedicalRecordsDAO personWithAgeAndMedicalRecordsDAO = new PersonWithAgeAndMedicalRecordsDAO();
	
	/**
	 * For a list of stationNumbers, this method will get all the addresses. For each address
	 * there will be a list of people with their age and medicalrecords.
	 * @param stationNumbers
	 * @return a list of addresses that contains a list of people with their age and medicalrecords.
	 */
	public Map<String, List<PersonWithAgeAndMedicalRecords>> getPersonsByAddressForAstationNumber(
			List<Integer> stationNumbers) {

		Map<String, List<PersonWithAgeAndMedicalRecords>> result = new HashMap<>();

		for (int stationNumber : stationNumbers) { 
			List<String> addresses = firestationDAO.findById(stationNumber);

			if(addresses != null) {
			for (int i = 0; i < addresses.size(); i++) {
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
			}else {
				LOGGER.info("Nothing found.");
				return null;
			}
		}
		LOGGER.info("People living in these addresses.");
		return result;
	}
}
