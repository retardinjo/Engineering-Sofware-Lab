package com.engineering.projekat.maven;

public class Person {

	private int jmbg;
	private String name;
	private int age;
	private Address address;
	
	
	
	
	public Person(int jmbg, String name) {
		super();
		this.jmbg = jmbg;
		this.name = name;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Person [jmbg=" + jmbg + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}


	public void speak() {
		System.out.println("Hello, my name is  " + this.name);
	}
	
	public void onCreate() {
		System.out.println("person added " + this);		
	}
	
	public void onDestroy() {
		System.out.println("Person removed " + this);
	}
	
}
