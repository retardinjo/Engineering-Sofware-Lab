package com.engineering.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
@Table(name="USER_TABLE")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int userId;

	@Column(name="CHECKED")
	private boolean checked;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;

/*	@Column(name="IMAGE_ALT")
	private String imageAlt;

	@Column(name="IMAGE_URL")
	private String imageUrl; */
	
	@Column(name="EMAIL")
	private String email;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	@Column(name="USERNAME", unique = true)
    String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="CARD_ID")
	private String cardId;
	
	
	//bi-directional many-to-one association to Workposition
	@ManyToOne
	private Position position;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	//bi-directional many-to-one association to WorkingHour
	@OneToMany(mappedBy="user", cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<WorkingHour> workingHours;

	
	// CONSTRUCTORS, GETTERS and SETTERS	
	
	public User() {
		super();
	}
	
	public User(int userId) {
		super();
		this.userId = userId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean getChecked() {
		return this.checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

/*	public String getImageAlt() {
		return this.imageAlt;
	}

	public void setImageAlt(String imageAlt) {
		this.imageAlt = imageAlt;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}	*/

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public List<WorkingHour> getWorkingHours() {
		return this.workingHours;
	}

	public void setWorkingHours(List<WorkingHour> workingHours) {
		this.workingHours = workingHours;
	}

	public WorkingHour addWorkingHour(WorkingHour workingHour) {
		getWorkingHours().add(workingHour);
		workingHour.setUser(this);

		return workingHour;
	}

	public WorkingHour removeWorkingHour(WorkingHour workingHour) {
		getWorkingHours().remove(workingHour);
		workingHour.setUser(null);

		return workingHour;
	} 

}