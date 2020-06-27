package model;

import java.util.List;

public class DataParser {

	private List <Persons> persons;
	private List <Firestations> firestations;
	private List <Medicalrecords> medicalrecords;
	
	
	public List<Persons> getPersons() {
		return persons;
	}
	public void setPersons(List<Persons> persons) {
		this.persons = persons;
	}
	public List<Firestations> getFirestations() {
		return firestations;
	}
	public void setFirestations(List<Firestations> firestations) {
		this.firestations = firestations;
	}
	public List<Medicalrecords> getMedicalrecords() {
		return medicalrecords;
	}
	public void setMedicalrecords(List<Medicalrecords> medicalrecords) {
		this.medicalrecords = medicalrecords;
	}
		
}
