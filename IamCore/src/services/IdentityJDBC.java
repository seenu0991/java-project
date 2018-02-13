package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datamodel.Identity;

public  class IdentityJDBC implements IdentityDAO {

	
	@Override
	public void create(Identity identity) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		try
		{
			String query = "INSERT INTO  IDENTITIES (uid,display_name,email_id)values(?,?,?)";
			conn = Dbconnection.getconnection();
		final PreparedStatement preparedstatement = conn
				.prepareStatement(query);
		preparedstatement.setString(1, identity.getUid());
		preparedstatement.setString(2,identity.getDisplay_name() );
		preparedstatement.setString(3,identity.getEmail_id() );
		
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(conn !=null) {
					conn.close();
				}
			}catch(final SQLException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}
		}
		
	}
	@Override
	public void update(Identity identity) {
		Connection conn = null;
		
		try {
			String query = "UPDATE IDENTITIES SET DISPLAY_NAME=?,EMAIL_ID=? WHERE UID=?";
			conn = Dbconnection.getconnection();
			final PreparedStatement preparedstatement = conn
					.prepareStatement(query);
			preparedstatement.setString(1, identity.getUid());
			preparedstatement.setString(2, identity.getDisplay_name());
			preparedstatement.setString(3, identity.getEmail_id());
			preparedstatement.executeUpdate();
			preparedstatement.close();
			
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null) {
					conn.close();
				}
			}catch(final SQLException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}
		}
		
	}

	@Override
	public void delete(Identity identity) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		try {
			String query = "DELETE FROM IDENTITIES =? ";
			conn = Dbconnection.getconnection();
			final PreparedStatement preparedstatement = conn
					.prepareStatement(query);
			preparedstatement.setString(1, identity.getUid());
			preparedstatement.setString(1, identity.getDisplay_name());
			preparedstatement.setString(1, identity.getEmail_id());
			preparedstatement.executeUpdate();
			preparedstatement.close();	
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null) {
					conn.close();
				}
			}catch(final SQLException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				
			}
		}
		
	}

	@Override
	public List<Identity> search(Identity criteria) {
		
		final List<Identity> identities = new ArrayList<>();
		// TODO reduce the number of lines to avoid repetition
		// the pattern is always the same, improve with your own ideas.
		// check lambda expressions
		Connection connection = null;
		try {
			connection = Dbconnection.getconnection();
			final PreparedStatement preparedStatement = connection
					.prepareStatement("select UID, DISPLAY_NAME, EMAIL FROM IDENTITIES WHERE DISPLAY_NAME = ? OR EMAIL = ? OR UID = ? ");
			preparedStatement.setString(1, criteria.getUid());
			preparedStatement.setString(2, criteria.getDisplay_name());
			preparedStatement.setString(3, criteria.getEmail_id());

			final ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				final Identity identity = new Identity();
				identity.setUid(resultSet.getString(1));
				identity.setDisplay_name(resultSet.getString(2));
				identity.setEmail_id(resultSet.getString(3));
				identities.add(identity);
			}
		} catch (ClassNotFoundException | SQLException e) {
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (final SQLException e) {
				
			}
		}

		return identities;

		
		
		
	}
	
}
