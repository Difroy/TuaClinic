package com.generation.clinic.repository;

import java.sql.Connection;
import java.sql.DriverManager;

import com.generation.clinic.config.Config;

public class ConnectionFactory {
	
	private static Connection REALCONNECTION;
	
	static {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				REALCONNECTION = DriverManager.getConnection(Config.getConnectionURL());
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}	
	}
	
	
	public static Connection make()
	{
		
		return REALCONNECTION;
		
	}

	
	
	
}
