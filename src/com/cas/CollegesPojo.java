package com.cas;

public class CollegesPojo {
	private String collegeName;
	private String city;
	private String state;
	private String zipcode;
	
	public CollegesPojo(String collegeName, String city, String state, String zipcode) {
		super();
		this.collegeName = collegeName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public CollegesPojo() {
		super();
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
