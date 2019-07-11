package com.engineering.controller.result;

public class AverageWorkingTime {
	
	private String fullName;
	private String avg;
	
	// CONSTRUCTORS, GETTERS and SETTERS
	
	public AverageWorkingTime() {
		super();
	}
	
	public AverageWorkingTime(String fullName, String avg) {
		super();
		this.fullName = fullName;
		this.avg = avg;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}
	
}
