package com.generation.clinic.repository;

public class PatientRepositoryFactory 
{
	private static PatientRepositorySQL patientrepo;
	
	public static PatientRepositorySQL make()
	{
		if(patientrepo == null)
			patientrepo = new PatientRepositorySQL();
		
		return patientrepo;
	}
	

}
