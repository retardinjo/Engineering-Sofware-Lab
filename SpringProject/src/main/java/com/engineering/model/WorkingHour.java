package com.engineering.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "WORKING_HOUR_TABLE")
public class WorkingHour implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WORKING_HOUR_ID")
	private int workingHourId;
  
	@Temporal(TemporalType.DATE)
	@Column(name="CHECK_IN_TIME")
	private Date checkInTime;

	@Temporal(TemporalType.DATE)
	@Column(name="CHECK_OUT_TIME")
	private Date checkOutTime; 

	@ManyToOne
	private User user; 
	
	
	// CONSTRUCTORS, GETTERS and SETTERS

	public WorkingHour() {
		super();
	}
	
	public int getWorkingHourId() {
		return workingHourId;
	}
	
	public void setWorkingHourId(int workingHourId) {
		this.workingHourId = workingHourId;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Date getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	} 
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 	
	
}
