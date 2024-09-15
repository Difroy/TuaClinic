package com.generation.clinic.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Intervention {

	protected int id, cost;
	protected String nameIntervent, doctor;
	Patient patient;
	List<Patient>patients = new ArrayList<>();
	

	
	public Intervention(int id, int cost, String nameIntervent, String doctor, Patient patient, List<Patient> patients) {
		super();
		this.id = id;
		this.cost = cost;
		this.nameIntervent = nameIntervent;
		this.doctor = doctor;
		this.patient = patient;
		this.patients = patients;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getNameIntervent() {
		return nameIntervent;
	}
	public void setNameIntervent(String nameIntervent) {
		this.nameIntervent = nameIntervent;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	} 
	
	
	
	
	
}
