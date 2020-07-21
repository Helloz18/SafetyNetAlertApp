package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PersonWithAgeAndMedicalRecords extends PersonWithAllInfos {
	
	@JsonIgnoreProperties({"address","city", "zip", "email"})
	Person person;
	@JsonIgnoreProperties({"firstName","lastName", "birthdate"})
	Medicalrecord medicalrecords;
	
}
