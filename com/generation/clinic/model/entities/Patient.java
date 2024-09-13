package com.generation.clinic.model.entities;

public class Patient {

	protected int id, insurence;
	protected String name, surname, dateOfBirth;
	
	public Patient (int id, int insurence, String name, String surname,String dateOfBirth) {
		
		this.id = id;
		this.insurence = insurence;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInsurence() {
		return insurence;
	}

	public void setInsurence(int insurence) {
		this.insurence = insurence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
}

