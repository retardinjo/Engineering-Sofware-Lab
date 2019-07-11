package com.engineering.model.dto;

import com.engineering.model.Position;
import com.engineering.model.Role;

public class UserDto {

	private int userId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String phoneNumber;
	private Role role;
	private Position position;
	private String email;
	
	// CONSTRUCTORS, GETTERS and SETTERS

	public UserDto() {
		super();
	}
	
	public UserDto(int userId) {
		super();
		this.userId = userId;
	}	

	public UserDto(int userId, String firstName, String lastName, String username, String password, String phoneNumber,
			Role role, Position position, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.position = position;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}