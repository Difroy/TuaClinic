package com.generation.clinic.repository;

public class InterventionRepositoryFactory 
{
	private static InterventionRepositorySQL intervrepo;
	
	public static InterventionRepositorySQL make()
	{
		if(intervrepo == null)
		{
			intervrepo = new InterventionRepositorySQL();
		}
		
		return intervrepo;
	}
}
