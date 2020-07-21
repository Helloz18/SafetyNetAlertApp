package model;

import java.util.List;

import parser.DataReader;
/**
 * Data object sets the structure of the file data.json
 *
 */

public class Data {
	
//Singleton
	private static Data data;

//Variables	
	private List <Person> persons;
	private List <Firestation> firestations;
	private List <Medicalrecord> medicalrecords;
		
	
//Constructors	
	public Data() {
	}	
	
	public Data(List<Person> persons, List<Firestation> firestations, List<Medicalrecord> medicalrecords) {
		this.persons = persons;
		this.firestations = firestations;
		this.medicalrecords = medicalrecords;
	}
	
//getters and setters	
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public List<Firestation> getFirestations() {
		return firestations;
	}
	public void setFirestations(List<Firestation> firestations) {
		this.firestations = firestations;
	}
	public List<Medicalrecord> getMedicalrecords() {
		return medicalrecords;
	}
	public void setMedicalrecords(List<Medicalrecord> medicalrecords) {
		this.medicalrecords = medicalrecords;
	}
	

	@Override
	public String toString() {
		return "DataParser [persons=" + persons + ", firestations=" + firestations + ", medicalrecords="
				+ medicalrecords + "]";
	}

//méthode de lecture
	public static Data getInstance() {
	DataReader read = new DataReader();
	data = read.readData();
	return data;
	}
	
}
