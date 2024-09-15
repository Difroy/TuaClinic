package com.generation.clinic.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			String row = "INSERT into patient (insurence, name, surname, dateOfBirth, sex) values (?,?,?,?,?)";
			PreparedStatement preparazioneSQL = connection.prepareStatement(row);

			preparazioneSQL.setInt(1, patient.getInsurence());
			preparazioneSQL.setString(2, patient.getName());
			preparazioneSQL.setString(3, patient.getSurname());
			preparazioneSQL.setString(4, patient.getDateOfBirth());
			preparazioneSQL.setString(5, String.valueOf(patient.getSex()));
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

			return patient;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Patient findByNameIntervention(String nameIntevention) {
	
		

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

			return patient;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
		
	

	@Override
	public Patient findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Patient patient) {

		try {
			String row = "UPDATE patient SET insurence = ?, name = ?, surname = ?, dateOfBirth = ? WHERE id=?";
			PreparedStatement preparazioneSQL = connection.prepareStatement(row);

			preparazioneSQL.setInt(1, patient.getInsurence());
			preparazioneSQL.setString(2, patient.getName());
			preparazioneSQL.setString(3, patient.getSurname());
			preparazioneSQL.setString(4, patient.getDateOfBirth());
			preparazioneSQL.setInt(5, patient.getId());
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
