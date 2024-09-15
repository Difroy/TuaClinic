package com.generation.clinic.repository;

import java.util.List;

import com.generation.clinic.model.entities.Patient;

public interface PatientRepository {
	
	
	
	 void insert (Patient patient);
	 Patient findById (int id);
	 Patient findBySurname (String surname);
	 List<Patient> findByNameIntervention (String nameIntevention);
	 List<Patient> findAll();
	 void update (Patient patient);
	 void delete (int id);
	 
	 
	
	
	
	
	
	

}
