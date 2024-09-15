package com.generation.clinic.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.generation.clinic.model.entities.Patient;
import com.generation.clinic.model.entities.Sex;

public class PatientRepositorySQL implements PatientRepository {

	Connection connection;

	public PatientRepositorySQL() {

		this.connection = ConnectionFactory.make();

	}

	@Override
	public void insert(Patient patient) {

		try {
			String row = "INSERT into patient (insurence, name, surname, dateOfBirth, sex, interventionId) values (?,?,?,?,?,?)";
			PreparedStatement preparazioneSQL = connection.prepareStatement(row);

			preparazioneSQL.setInt(1, patient.getInsurence());
			preparazioneSQL.setString(2, patient.getName());
			preparazioneSQL.setString(3, patient.getSurname());
			preparazioneSQL.setString(4, patient.getDateOfBirth());
			preparazioneSQL.setString(5, String.valueOf(patient.getSex()));
			preparazioneSQL.setInt(6,patient.getInterventionId());
			preparazioneSQL.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());

		}

	}

	@Override
	public Patient findById(int id) {

		try {

			String row = "Select * from patient where id = ?";
			PreparedStatement preparazioneSQL = connection.prepareStatement(row);
			preparazioneSQL.setInt(1, id);

			ResultSet returnDalDB = preparazioneSQL.executeQuery();

			Patient patient = new Patient();

			patient.setName(returnDalDB.getString("name"));
			patient.setSurname(returnDalDB.getString("surname"));
			patient.setDateOfBirth(returnDalDB.getString("dateOfBirth"));
			patient.setSex(Sex.valueOf(returnDalDB.getString("sex")));
			patient.setInsurence(returnDalDB.getInt("insurence"));
			patient.setInterventionId(returnDalDB.getInt("insurenceId"));

			return patient;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());

		}
	}

	@Override
	public Patient findBySurname(String surname) {

		try {

			String row = "Select * from patient where surname = ?";
			PreparedStatement preparazioneSQL = connection.prepareStatement(row);
			preparazioneSQL.setString(1, surname);

			ResultSet returnDalDB = preparazioneSQL.executeQuery();

			Patient patient = new Patient();

			patient.setName(returnDalDB.getString("name"));
			patient.setSurname(returnDalDB.getString("surname"));
			patient.setDateOfBirth(returnDalDB.getString("dateOfBirth"));
			patient.setSex(Sex.valueOf(returnDalDB.getString("sex")));
			patient.setInsurence(returnDalDB.getInt("insurence"));
			patient.setInterventionId(returnDalDB.getInt("insurenceId"));
			
			

			return patient;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	
	
	@Override
	public List<Patient> findByNameIntervention(String nameIntervention) {
	
		

		try {

			String row = "select * from patient join intervention where patient.interventionid = intervention.id and intervention.name = ?";
			PreparedStatement preparazioneSQL = connection.prepareStatement(row);
			
			
			
			preparazioneSQL.setString(1, nameIntervention);

			ResultSet returnDalDB = preparazioneSQL.executeQuery();
			List<Patient> patients = new ArrayList<>();
			while (returnDalDB.next()){
				
			Patient patient = new Patient();

			patient.setName(returnDalDB.getString("name"));
			patient.setSurname(returnDalDB.getString("surname"));
			patient.setDateOfBirth(returnDalDB.getString("dateOfBirth"));
			patient.setSex(Sex.valueOf(returnDalDB.getString("sex")));
			patient.setInsurence(returnDalDB.getInt("insurence"));
			patient.setInterventionId(returnDalDB.getInt("interventionId"));
			
			
			patients.add(patient);
			
			}
			return patients;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		
	}
		
	

	@Override
	public List<Patient> findAll() {
	

		try {

			String row = "select * from patient";
			PreparedStatement preparazioneSQL = connection.prepareStatement(row);
			
			
			
			

			ResultSet returnDalDB = preparazioneSQL.executeQuery();
			List<Patient> patients = new ArrayList<>();
			while (returnDalDB.next()){
				
			Patient patient = new Patient();

			patient.setName(returnDalDB.getString("name"));
			patient.setSurname(returnDalDB.getString("surname"));
			patient.setDateOfBirth(returnDalDB.getString("dateOfBirth"));
			patient.setSex(Sex.valueOf(returnDalDB.getString("sex")));
			patient.setInsurence(returnDalDB.getInt("insurence"));
			patient.setInterventionId(returnDalDB.getInt("interventionId"));
			
			
			patients.add(patient);
			
			}
			return patients;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		
		
		
	}

	@Override
	public void update(Patient patient) {

		try {
			String row = "UPDATE patient SET insurence = ?, name = ?, surname = ?, dateOfBirth = ?, interventionId = ? WHERE id=?";
			PreparedStatement preparazioneSQL = connection.prepareStatement(row);

			preparazioneSQL.setInt(1, patient.getInsurence());
			preparazioneSQL.setString(2, patient.getName());
			preparazioneSQL.setString(3, patient.getSurname());
			preparazioneSQL.setString(4, patient.getDateOfBirth());
			preparazioneSQL.setInt(5,patient.getInterventionId());
			preparazioneSQL.setInt(6, patient.getId());
			
			preparazioneSQL.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());

		}

	}

	@Override
	public void delete(int id) {

		try {
			String row = "delete from PATIENT where id = ? ";
			PreparedStatement preparazioneSQL = connection.prepareStatement(row);

			preparazioneSQL.setInt(1, id);

			preparazioneSQL.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());

		}
	}
}
