package com.generation.clinic.repository;

import java.sql.PreparedStatement;

import com.generation.clinic.model.entities.Administrator;

public class AdministratorRepositorySQL implements AdministratorRepository 
{
	
	

	@Override
	public void insert(Administrator newAdministrator) 
	{
		String sql = "insert into administrator (id, email, password) values (?, ?, ?)";
		
	}

	@Override
	public Administrator findById(int id) 
	{
		return null;
	}

	@Override
	public Administrator findByEmailAndPassword(String email, String password) 
	{
	
		return null;
	}

	@Override
	public void update(Administrator oldAdministrator) 
	{
		
	}

	@Override
	public void delete(int id) 
	{
		
	}

}
