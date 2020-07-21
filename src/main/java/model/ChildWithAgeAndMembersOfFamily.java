package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ChildWithAgeAndMembersOfFamily {
	@JsonIgnoreProperties({"address","city", "zip","phone", "email"})
	Person child;
	int age;
	@JsonIgnoreProperties({"address","city", "zip","phone", "email"})
	List<Person> memberOfFamily;
	
	public ChildWithAgeAndMembersOfFamily() {
		super();
	}

	public ChildWithAgeAndMembersOfFamily(Person child, int age, List<Person> memberOfFamily) {
		super();
		this.child = child;
		this.age = age;
		this.memberOfFamily = memberOfFamily;
	}

	public Person getChild() {
		return child;
	}

	public void setChild(Person child) {
		this.child = child;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Person> getMemberOfFamily() {
		return memberOfFamily;
	}

	public void setMemberOfFamily(List<Person> memberOfFamily) {
		this.memberOfFamily = memberOfFamily;
	}
		
}
