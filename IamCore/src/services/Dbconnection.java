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
	
	static
	{
		properties = intializeProperties();
	}
	

	public static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		
		if(inputStream != null && properties!=null)
		{
			final String ConnectionString = properties.getProperty("connectionString");
			final String username = properties.getProperty("username");
			final String password = properties.getProperty("password");
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			 conn = DriverManager.getConnection(ConnectionString,username,password);
		}
		
		return conn;
		
	}


	private static Properties intializeProperties() {
		
		
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
			System.out.println("Input stream could not be loaded from both system property or the resource folder in the "
					+ "project space");
		}
		
		// TODO Auto-generated method stub
		return properties;
	}

	
	

}
