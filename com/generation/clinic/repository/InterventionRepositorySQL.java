package com.generation.clinic.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.generation.clinic.model.entities.Intervention;

public class InterventionRepositorySQL implements InterventionRepository{
	
	Connection connection;
	PatientRepositorySQL patientRepo = PatientRepositoryFactory.make();
	
	public InterventionRepositorySQL() {
		connection = ConnectionFactory.make();
	}

	@Override
	public void insert(Intervention intervention) {
		String sql = "insert into intervention (cost, nameIntervent, doctor) values (?, ?, ?)";
		
		try 
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, intervention.getCost());
			ps.setString(2, intervention.getNameIntervent());
			ps.setString(3, intervention.getDoctor());
			
			ps.execute();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public List<Intervention> findAll() {
		
		String sql = "select * from intervention";
		
		try 
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Intervention> res = new ArrayList<Intervention>();
			
			while(rs.next())
			{
				Intervention i = new Intervention(rs.getInt("id"), 
									   rs.getInt("cost"), 
									   rs.getString("nameIntervent"), 
									   rs.getString("doctor"));
				
				//Ricercare lista dei pazienti con PatientRepositorySQL
				i.setPatients(patientRepo.findByNameIntervention(i));
				
				res.add(i);
			}
			
			return res;
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Intervention findById(int id) {
		
		String sql = "select * from intervention where id = ?";
		
		try 
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Intervention res = null;
			
			if(rs.next())
			{
				res = new Intervention(rs.getInt("id"), 
									   rs.getInt("cost"), 
									   rs.getString("nameIntervent"), 
									   rs.getString("doctor"));
			
				//Ricercare lista dei pazienti con PatientRepositorySQL
				res.setPatients(patientRepo.findByNameIntervention(res));
			}
			
			return res;
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void update(Intervention intervention) {
		String sql = "update intervention set cost = ?, nameIntervent = ?, doctor = ? where id = ?";
		
		try 
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, intervention.getCost());
			ps.setString(2, intervention.getNameIntervent());
			ps.setString(3, intervention.getDoctor());
			ps.setInt(4, intervention.getId());
			
			ps.execute();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) {
String sql = "delete from intervention where id = ?";
		
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
