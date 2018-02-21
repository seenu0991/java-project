package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Dbconnection {

	
	
	private static Properties properties;

	private static InputStream inputStream;
	private static Connection conn;

	static {
		properties = intializeProperties();
	}

	
	/**
	 * Connection method is used to make a connection with the database by taking the values from the properties file
	 * 
	 * @return conn
	 */
	public static Connection getconnection() {
		
		final String ConnectionString = properties.getProperty("URL");
		final String username = properties.getProperty("USER");
		final String password = properties.getProperty("PASSWORD");

		try {
			
			Class.forName(properties.getProperty("DRIVER"));
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(ConnectionString, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	/**
	 * This is used to Initialize the properties file
	 * 
	 * @return properties
	 */
	private static Properties intializeProperties() {
		
		properties=new Properties();

		try {
			inputStream = new FileInputStream(System.getProperty("conf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Issue while loading the property from system property: conf");
			e.printStackTrace();
		}

		if (inputStream != null) {
			try {
				properties.load(inputStream);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		} else {
			System.out
					.println("Input stream could not be loaded from both system property or the resource folder in the "
							+ "project space");
		}

		// TODO Auto-generated method stub
		return properties;
	}
	
	
}
