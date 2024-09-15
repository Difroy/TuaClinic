package com.generation.clinic.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.generation.clinic.model.entities.Administrator;

public class AdministratorRepositorySQL implements AdministratorRepository 
{
	Connection connection = ConnectionFactory.make();
	

	@Override
	public void insert(Administrator newAdministrator) 
	{
		String sql = "insert into administrator (id, email, password) values (?, ?, ?)";
		
		try 
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, newAdministrator.getId());
			ps.setString(2, newAdministrator.getEmail());
			ps.setString(3, newAdministrator.getPassword());
			
			ps.execute();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public Administrator findById(int id) 
	{
		String sql = "select * from administrator where id = ?";
		try 
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Administrator a = null;
			
			if(rs.next())
			{
				 a = new Administrator(rs.getInt("id"),
													rs.getString("email"),
													rs.getString("password"));
			}
			return a;
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Administrator findByEmailAndPassword(String email, String password) 
	{
	
		String sql = "select * from administrator where email = ? and password = ?";
		try 
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			Administrator a = null;
			
			if(rs.next())
			{
				 a = new Administrator(rs.getInt("id"),
													rs.getString("email"),
													rs.getString("password"));
			}
			return a;
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void update(Administrator oldAdministrator) 
	{
		String sql = "update administrator set email = ?, password = ? where id = ?";
		try 
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, oldAdministrator.getId());
			ps.setString(2, oldAdministrator.getEmail());
			ps.setString(3, oldAdministrator.getPassword());
			
			ps.execute();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void delete(int id) 
	{
		String sql = "delete from administrator where id = ?";
		try 
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}

}
