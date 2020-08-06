package com.hfinoux.SafetyNetAlerts.model;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((medicalrecords == null) ? 0 : medicalrecords.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + stationNumber;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonWithAllInfos other = (PersonWithAllInfos) obj;
		if (age != other.age)
			return false;
		if (medicalrecords == null) {
			if (other.medicalrecords != null)
				return false;
		} else if (!medicalrecords.equals(other.medicalrecords))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (stationNumber != other.stationNumber)
			return false;
		return true;
	}
}
