package com.generation.clinic.model.entities;

public class Administrator {

	protected int id;
	protected String email, password;
	
	public Administrator (int id, String email, String password) {
		
		
		this.id = id;
		this.email = email;
		this.password = password;
		
	}
	
	public Administrator() {};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
