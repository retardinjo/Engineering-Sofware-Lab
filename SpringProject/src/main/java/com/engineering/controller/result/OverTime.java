package com.engineering.controller.result;

public class OverTime {
	
	private String fullName;
	private String date;
	private String overTimeWork;
	
	// CONSTRUCTORS, GETTERS and SETTERS
	
	public OverTime() {
		super();
	}
	
	public OverTime(String fullName, String date, String overTimeWork) {
		super();
		this.fullName = fullName;
		this.date = date;
		this.overTimeWork = overTimeWork;
	}
		
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public String getOverTimeWork() {
		return overTimeWork;
	}

	public void setOverTimeWork(String overTimeWork) {
		this.overTimeWork = overTimeWork;
	}

}
