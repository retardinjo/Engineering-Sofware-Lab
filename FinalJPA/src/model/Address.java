package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String street;
	
	@ManyToOne
	@JoinColumn(name="user_id1", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="city_id", nullable=false)
	private City city;

	public Address() {
		super();
	}

	public Address(int id, String street, User user, City city) {
		super();
		this.id = id;
		this.street = street;
		this.user = user;
		this.city = city;
	}

	public Address(String street, User user, City city) {
		super();
		this.street = street;
		this.user = user;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
}
