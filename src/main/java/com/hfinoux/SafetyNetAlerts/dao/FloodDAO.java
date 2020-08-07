package com.hfinoux.SafetyNetAlerts.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hfinoux.SafetyNetAlerts.model.PersonWithAgeAndMedicalRecords;

@Service
public interface FloodDAO {

	/**
	 * For a list of stationNumbers, this method will get all the addresses. For each address
	 * there will be a list of people with their age and medicalrecords.
	 * @param stationNumbers
	 * @return a list of addresses that contains a list of people with their age and medicalrecords.
	 */
	Map<String, List<PersonWithAgeAndMedicalRecords>> getPersonsByAddressForAstationNumber(
			List<Integer> stationNumbers);

}