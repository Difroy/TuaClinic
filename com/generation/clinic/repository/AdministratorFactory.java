package com.generation.clinic.repository;

public class AdministratorFactory 
{
	private static AdministratorRepositorySQL adminrepo;
	
	public static AdministratorRepositorySQL make()
	{
		if(adminrepo != null)
		{
			adminrepo = new AdministratorRepositorySQL();
		}
		
		return adminrepo;
	}
}
