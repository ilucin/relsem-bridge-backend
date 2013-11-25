package com.etk.network.client;

public class Student {

	private int id;
	private String name;
	private String surname;

	public Student(int id,String name,String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "My name is " + this.name + "my surname is " + this.surname + "my ID is " + this.id;
	}
}