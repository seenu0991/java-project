package test;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import datamodel.Identity;
import fr.epita.iam.exceptions.IdentityCreationException;
import fr.epita.iam.service.IdentityJDBCDAO;
import services.Dbconnection;
import services.IdentityJDBC;



public class Testdatabase {

	public  static void  main (String[] agr) throws SQLException, ClassNotFoundException {
	//update();
		//testConnectAndSelect();
		//createTest();
		//delete();
		testCreateSearchFromDAO();
	}
		//Connection conn = null;
		//final String ConnectionString = properties.getProperty("ConnectionString");
		//final String username = properties.getProperty("username");
		//final String password = properties.getProperty("password");
		
		//final String ConnectionString = "jdbc:derby://localhost:1527/IamDB;create=true";
	//final String username = "admin";
		//final String password = "admin" ;
		
		//try {
			//Class.forName("org.apache.derby.jdbc.ClientDriver");
		//conn  = DriverManager.getConnection(ConnectionString,username,password);
		// System.out.println("connection success");
		//}catch(Exception e)
		//{
		// System.out.println("unable connection");
		 //e.printStackTrace();
		//}finally {
		//	if(conn!=null)
			//{
				//conn.close();
			//}
			//{
				
			//}
		//}
		
	
	//}
		

				
	

	
	
		
		
		/*private static void createTest() throws SQLException, ClassNotFoundException  {
			final Connection connection = Dbconnection.getconnection();
try {
	
			final PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO IDENTITIES (UID,DISPLAY_NAME,EMAIL_ID) VALUES (?, ?, ?)");

			preparedStatement.setString(1, "234");
			preparedStatement.setString(2, "seenu");
			preparedStatement.setString(3, "seenu@microsoft.com");
			preparedStatement.execute();
			final java.sql.Statement st = connection
					.createStatement();
			final ResultSet rs = st.executeQuery("SELECT * FROM IDENTITIES");
while (rs.next()) {
				
				System.out.println(rs.getString("UID"));
				System.out.println(rs.getString("DISPLAY_NAME"));
				System.out.println(rs.getString("EMAIL_ID"));
				System.out.println(rs.getString(4));
			}
			System.out.println("datainserterd");
		}catch(Exception e)
{
			e.printStackTrace();
			System.out.println("data not inserted" );
}finally {
	if (connection!=null) {
		connection.close();
	}
}
}
//private static Connection getconnection() {
		//	// TODO Auto-generated method stub
			//return null;
		//}





/*private static void update() throws ClassNotFoundException, SQLException 
{
final Connection connection = Dbconnection.getconnection();

try {
	String query = "UPDATE IDENTITIES SET DISPLAY_NAME=?,EMAIL_ID=? WHERE UID=?";

	final PreparedStatement preparedstatement = connection
			.prepareStatement(query);
	preparedstatement.setString(1, "val");
	preparedstatement.setString(2, "val@hotmail.com" );
	preparedstatement.setString(3, "098");
    preparedstatement.executeUpdate();
    preparedstatement.close();

	final java.sql.Statement st = connection
					.createStatement();
			final ResultSet rs = st.executeQuery("SELECT * FROM IDENTITIES");
while (rs.next()) {
				
				System.out.println(rs.getString("UID"));
				System.out.println(rs.getString("DISPLAY_NAME"));
				System.out.println(rs.getString("EMAIL_ID"));
				System.out.println(rs.getString(4));
			}
	
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


	}/*
		
/*private static void testConnectAndSelect() throws ClassNotFoundException, SQLException {
	final Connection connection = Dbconnection.getconnection();

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
	
	private static void delete() throws  SQLException {
		// TODO Auto-generated method stub
		
		final Connection connection = Dbconnection.getconnection();
		try {
		 String query = "DELETE FROM IDENTITIES WHERE UID=?";
	
			final PreparedStatement preparedstatement = connection
					.prepareStatement(query);
			preparedstatement.setString(1,"099");
			//preparedstatement.setString(2, "roqe");
			//preparedstatement.setString(3,"098");
			preparedstatement.executeUpdate();
			preparedstatement.close();	
			final java.sql.Statement st = connection
					.createStatement();
			final ResultSet rs = st.executeQuery("SELECT * FROM IDENTITIES");
			while (rs.next()) {
				
				System.out.println(rs.getString("UID"));
				System.out.println(rs.getString("DISPLAY_NAME"));
				System.out.println(rs.getString("EMAIL_ID"));
				System.out.println(rs.getString(4));
			}
			    System.out.println("sucessfully deleted");
			connection.close();
		}catch(SQLException e) {
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
		*/
		
		private static void testCreateSearchFromDAO() {
			// given
			final IdentityJDBC dao = new IdentityJDBC();
			final Identity identity = new Identity();
			identity.setUid("098");
			identity.setDisplay_name("val");
			identity.setEmail_id("");

			dao.create(identity);;

			// when
			final Identity criteria = new Identity();
			criteria.setDisplay_name("roqe");
			final List<Identity> identities = dao.search(criteria);

			// then
			if (identities == null || identities.isEmpty()) {
				System.out.println("failure");
			} else {
				System.out.println("success");
			}
		}
}

		
		
		
		
			

		
	
	
	
	
	
	

