package com.generation.clinic.repository;

import com.generation.clinic.model.entities.Patient;

public interface PatientRepository {
	
	
	
	 void insert (Patient patient);
	 Patient findById (int id);
	 Patient findBySurname (String surname);
	 
	 
	 
	
	
	
	
	
	

}
