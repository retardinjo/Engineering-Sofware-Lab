package com.engineering.projekat.maven;

public class Index {

	private String number;
	private String department;
	

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Index [number=" + number + ", department=" + department + "]";
	}
	
	public void number() {
		System.out.println("Hello, number is  " + this.number);
	}
	
}
