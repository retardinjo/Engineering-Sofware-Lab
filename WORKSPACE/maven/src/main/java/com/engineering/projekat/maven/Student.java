package com.engineering.projekat.maven;

public class Student {
	
	private String name;
	private Index index;
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Index getIndex() {
		return index;
	}




	public void setIndex(Index index) {
		this.index = index;
	}




	@Override
	public String toString() {
		return "Student [name=" + name + ", index=" + index + "]";
	}
	
	public void sing() {
		System.out.println("Hello, I am singing  " + this.name);
	}
	
}
