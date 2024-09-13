package com.generation.clinic.repository;

import com.generation.clinic.model.entities.Administrator;

public interface AdministratorRepository {

	void insert (Administrator newAdministrator);
	Administrator findById (int id);
	Administrator findByEmailAndPassword (String email, String password);
	void update (Administrator oldAdministrator);
	void delete (int id);
	
	
	
	
}
