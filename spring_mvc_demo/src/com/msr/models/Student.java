package com.msr.models;

import java.util.LinkedList;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private LinkedList<String> countryOptions;
	
	public Student() {
		countryOptions= new LinkedList<String>();
		countryOptions.add("India");
		countryOptions.add("USA");
		countryOptions.add("Germany");
		countryOptions.add("France");
	}
	
	public LinkedList<String> getCountryOptions() {
		return countryOptions;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
