package com.engineering.controller.result;

public class Hours {
	
	private String hoursPerDay;
	private String fullName;
	private String day;
	
	// CONSTRUCTORS, GETTERS and SETTERS

	public Hours() {
		super();
	}
	
	public Hours(String hoursPerDay, String fullName, String day) {
		super();
		this.hoursPerDay = hoursPerDay;
		this.fullName = fullName;
		this.day = day;
	}
	
	public String getHoursPerDay() {
		return hoursPerDay;
	}

	public void setHoursPerDay(String hoursPerDay) {
		this.hoursPerDay = hoursPerDay;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
}
