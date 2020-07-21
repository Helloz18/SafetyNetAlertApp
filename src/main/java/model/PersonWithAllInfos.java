package model;

public class PersonWithAllInfos {

	int stationNumber;
	Person person;
	int age;
	Medicalrecord medicalrecords;
	
	
	public PersonWithAllInfos() {
		super();
	}


	public PersonWithAllInfos(int stationNumber, Person person, int age, Medicalrecord medicalrecords) {
		super();
		this.stationNumber = stationNumber;
		this.person = person;
		this.age = age;
		this.medicalrecords = medicalrecords;
	}


	public int getStationNumber() {
		return stationNumber;
	}


	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Medicalrecord getMedicalrecords() {
		return medicalrecords;
	}


	public void setMedicalrecords(Medicalrecord medicalrecords) {
		this.medicalrecords = medicalrecords;
	}
	
	
}
