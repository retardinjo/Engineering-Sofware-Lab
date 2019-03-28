package com.engineering.projekat.maven;

public class Address {

	
	private String street;
	private String postalCode;
	
	
	
	public Address() {
		super();
	}



	public Address(String street, String postalCode) {
		this.street = street;
		this.postalCode = postalCode;
	}



	@Override
	public String toString() {
		return "Address [street=" + street + ", postalCode=" + postalCode + "]";
	}
	
	
	
}
