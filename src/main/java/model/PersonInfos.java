package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PersonInfos extends PersonWithAllInfos {
	@JsonIgnore
	int stationNumber;
	@JsonIgnoreProperties({"phone"})
	Person person;
	@JsonIgnoreProperties({"firstName", "lastName","birthdate"})
	Medicalrecord medicalrecords;
	
}
