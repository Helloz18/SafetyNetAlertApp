package com.hfinoux.SafetyNetAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hfinoux.SafetyNetAlerts.model.PersonWithAgeAndMedicalRecords;

@Service
public interface PersonWithAgeAndMedicalRecordsDAO {

	/**
	 * This method will select all people living in an address and return them as a list with their age and medicalrecords.
	 * @param address
	 * @return a list of PersonWithAgeAndMedicalRecords.
	 */
	List<PersonWithAgeAndMedicalRecords> findByAddress(String address);

}