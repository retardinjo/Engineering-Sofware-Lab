package com.engineering.controller.result;

public class Bonus {
	
	private String fullName;
	private String month;
	private String bonus;
	
	// CONSTRUCTORS, GETTERS and SETTERS
	
	public Bonus() {
		super();
	}
	
	public Bonus(String fullName, String month, String bonus) {
		super();
		this.fullName = fullName;
		this.month = month;
		this.bonus = bonus;
	}
	
	public String getUserFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

}
