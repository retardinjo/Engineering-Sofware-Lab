package com.engineering.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
@Table(name = "POSITION_TABLE")
public class Position implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="POSITION_ID")
	private int positionId;

	@Column(name="POSITION_NAME")
	private String positionName;
	
	//bi-directional many-to-one association to Salary
	@ManyToOne
	private Salary salary;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="position")
	@JsonBackReference
	private List<User> users;


	// CONSTRUCTORS, GETTERS and SETTERS

	public Position() {
		super();
	}
	
	public Position(int positionId) {
		super();
		this.positionId=positionId;
	}	

	public int getPositionId() {
		return this.positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	public Salary getSalary() {
		return this.salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public User addUser(User user) {
		getUsers().add(user);
		user.setPosition(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setPosition(null);

		return user;
	}

}
