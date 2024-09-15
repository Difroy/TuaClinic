package com.generation.clinic.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Config {

	private static Map<String, String> configValues = new HashMap<String, String>();

	static {

		try {

			Scanner reader = new Scanner(new File("application.properties"));

			while (reader.hasNextLine()) {
				String row = reader.nextLine();
				// row = DBSERVER=localhost
				String[] parts = row.split("=");
				configValues.put(parts[0], parts[1]);

			}
			reader.close();
		} catch (FileNotFoundException e) {

			System.out.println("Non trovo il file application.properties.Termino");
			System.out.println(
					"E TI HO DETTO CHE NON C'E'!!! HO RAGIONE IO! NON INSISTERE! CONTROLLA LA CARTELLA!!!1111!!111 (KAFFEEE'')");

			e.printStackTrace();
			System.exit(-1);

		}
	}

	public static String getKey(String key) {
		return configValues.get(key);
	}

	public static String getConnectionURL() {
		String server = getKey("DBSERVER");
		if (server == null)
			throw new RuntimeException("Missing key DBSERVER in application.properties");

		String user = getKey("DBUSER");
		if (user == null)
			throw new RuntimeException("Missing key DBUSER in application.properties");

		String password = getKey("DBPASSWORD");
		if (password == null)
			throw new RuntimeException("Missing key DBPASSWORD in application.properties");

		String dbname = getKey("DBNAME");
		if (dbname == null)
			throw new RuntimeException("Missing key DBNAME in application.properties");

		return "jdbc:mysql://[server]:3306/[dbname]?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&user=[user]&password=[password]"
				.replace("[server]", server).replace("[dbname]", dbname).replace("[user]", user)
				.replace("[password]", password);
	}

}
