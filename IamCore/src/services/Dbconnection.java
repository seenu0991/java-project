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
	 
	 *  *  * <h3>Description</h3>
	 * <p>
	* Connection method is used to make a connection with the database by taking
	 * the values from the properties file
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 * The variables Connectionstring, username , password are created and then the value for them
	 * is set using the properties file which contains the url,user and password
	 * 
	 * </p>
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
	 *  * <h3>Description</h3>
	 * <p>
	 * This is used to Initialize the properties file
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 * The inputStream is set the value from the conf which has receives the values from the properties file
	 * 
	 * </p>
	 * 
	 * @return properties
	 */
	private static Properties intializeProperties() {

		properties = new Properties();

		try {
			inputStream = new FileInputStream(System.getProperty("conf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Issue of loading property from system property: conf");
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
			System.out.println("The Input stream could not be loaded in  " + "project space");
		}

		// TODO Auto-generated method stub
		return properties;
	}

}
