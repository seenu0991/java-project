package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

	
	//private static Properties properties;
	
		//private static InputStream inputStream;
		//private static Connection conn;
		
		/*static
		{
			properties = intializeProperties();
		}
		*/

		public static Connection getconnection() throws SQLException{
			 
			final String ConnectionString = "jdbc:derby://localhost:1527/sample;create=true";
			final String username = "root";
				final String password = "root";
				try {
					Class.forName("org.apache.derby.jdbc.ClientDriver");
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				 final Connection conn = DriverManager.getConnection(ConnectionString,username,password);
				
				 
			//}
			return conn;
		
			
		}
				
				

		}
		/*
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
					System.out.println("prop loaded successfully");
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
		}*/
		

	

