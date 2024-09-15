package com.generation.clinic.test;

import com.generation.clinic.repository.InterventionRepository;
import com.generation.clinic.repository.InterventionRepositoryFactory;

public class MainTest 
{
	private static InterventionRepository intervrepo = InterventionRepositoryFactory.make();
	
	public static void main(String[] args) 
	{
		System.out.println("ciao");
		System.out.println(intervrepo.findById(1));
	}
}
