package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import services.Dbconnection;



public class Testdatabase {

	public  static void  main (String[] agr) throws ClassNotFoundException, SQLException {
	update();
		testConnectAndSelect();
		
		
		
	}
		

				
		
		
		/*private static void createTest() throws SQLException, ClassNotFoundException  {
			final Connection connection = getconnection();
try {
	
			final PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO IDENTITIES (DISPLAY_NAME, EMAIL_ID, UID) VALUES (?, ?, ?)");

			preparedStatement.setString(1, "abdjul");
			preparedStatement.setString(2, "cserr@natsystem.fr");
			preparedStatement.setString(3, "098");
			preparedStatement.execute();

			System.out.println("datainserterd");
		}catch(Exception e)
{
			e.printStackTrace();
			System.out.println("data not inserted" );
}finally {
	if (connection!=null) {
		connection.close();
	}
}}*/
private static void update() throws ClassNotFoundException, SQLException 
{
final Connection connection = Dbconnection.getconnection();

try {
	String query = "UPDATE IDENTITIES SET DISPLAY_NAME=?,EMAIL_ID=? WHERE UID=?";

	final PreparedStatement preparedstatement = connection
			.prepareStatement(query);
	preparedstatement.setString(1, "ross");
	preparedstatement.setString(2, "csergmalilcom" );
	preparedstatement.setString(3, "4567");
    preparedstatement.executeUpdate();

	
	
	
	System.out.println("successfully update");
	
}catch (SQLException e) {
	e.printStackTrace();
}finally {
	try {
		if(connection !=null) {
			connection.close();
		}
	}catch(final SQLException e)
	{
		System.out.println(e.getMessage());
		e.printStackTrace();
		
	}
}


	}
		
private static void testConnectAndSelect() throws ClassNotFoundException, SQLException {
	final Connection connection = getconnection();

	final String sqlQuery = "select * from IDENTITIES";

	final PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
	final ResultSet resultSet = preparedStatement.executeQuery();
	while (resultSet.next()) {
		System.out.println(resultSet.getString(1));
		System.out.println(resultSet.getString(2));
		System.out.println(resultSet.getString(3));
		System.out.println(resultSet.getString(4));
	}
	connection.close();
}

		
		
		
		
			

		}
	
	
	
	
	
	

