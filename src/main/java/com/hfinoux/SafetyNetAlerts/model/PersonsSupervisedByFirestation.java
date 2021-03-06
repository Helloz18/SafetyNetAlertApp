package com.hfinoux.SafetyNetAlerts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * This object gets the list of the persons supervised by a firestation.
 * It returns also the number of adults and children from the list.
 */

public class PersonsSupervisedByFirestation {
	@JsonIgnoreProperties({"city", "zip", "email"})
	List <Person> persons;
	int adults;
	int children;
	
	
	public PersonsSupervisedByFirestation() {
	}


	public PersonsSupervisedByFirestation(List<Person> persons, int adults, int children) {
		super();
		this.persons = persons;
		this.adults = adults;
		this.children = children;
	}


	public List<Person> getPersons() {
		return persons;
	}


	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}


	public int getAdults() {
		return adults;
	}


	public void setAdults(int adults) {
		this.adults = adults;
	}


	public int getChildren() {
		return children;
	}


	public void setChildren(int children) {
		this.children = children;
	}


}
