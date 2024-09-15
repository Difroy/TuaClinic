package com.generation.clinic.repository;

import java.util.List;

import com.generation.clinic.model.entities.Intervention;

public interface InterventionRepository 
{
	void insert(Intervention intervention);
	List<Intervention> findAll();
	Intervention findById(int id);
	void update(Intervention intervention);
	void delete(int id);
}
