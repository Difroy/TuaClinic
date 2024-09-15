package com.generation.clinic.model.entities;

public class Patient {

	protected int id, insurence, interventionId;
	protected String name, surname, dateOfBirth;
	protected Sex sex;
	
	Intervention intervention;
	
	
	
	
	
	
	
	
	public Patient (int id, int insurence, String name, String surname,String dateOfBirth, Sex sex, int interventionId) {
		
		this.id = id;
		//tabella Edu è "insurance" darà problemi ma sticazzi
		this.insurence = insurence;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.interventionId = interventionId;
		
		
	}
	
	public int getInterventionId() {
		
	
		
		return interventionId;
	}



	public void setInterventionId(int interventionId) {
		
		this.interventionId = intervention.id;
	}




	public Intervention getIntervention() {
		return intervention;
	}


	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}




	public Patient() {};

	
	
	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
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

