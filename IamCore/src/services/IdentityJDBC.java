package services;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datamodel.Identity;
import exception.IdentityException;

public class IdentityJDBC implements IdentityDAO {

	@Override
	public void create(Identity identity) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = Dbconnection.getconnection();
			String query = "INSERT INTO  IDENTITIES (uid,display_name,email_id,password)values(?,?,?,?)";
			final PreparedStatement preparedstatement = conn.prepareStatement(query);
			preparedstatement.setString(1, identity.getUid());
			preparedstatement.setString(2, identity.getDisplay_name());
			preparedstatement.setString(3, identity.getEmail_id());
			preparedstatement.setString(4, identity.getPassword());
			preparedstatement.executeUpdate();

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (final SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}
		}

	}

	@Override
	public void update(Identity identity) {
		Connection conn = null;

		try {
			conn = Dbconnection.getconnection();
			String query = "UPDATE IDENTITIES SET DISPLAY_NAME=?,EMAIL_ID=? WHERE UID=?";

			final PreparedStatement preparedstatement = conn.prepareStatement(query);
			preparedstatement.setString(1, identity.getDisplay_name());
			preparedstatement.setString(2, identity.getEmail_id());
			preparedstatement.setString(3, identity.getUid());

			final int noOfRowsUpdated = preparedstatement.executeUpdate();
			
			if(noOfRowsUpdated>0) {
				System.out.println("Updated");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				
			} catch (final SQLException e) {
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

			conn = Dbconnection.getconnection();
			String query = "DELETE FROM IDENTITIES where UID =? ";
			final PreparedStatement preparedstatement = conn.prepareStatement(query);
			preparedstatement.setString(1, identity.getUid());

			int no=preparedstatement.executeUpdate();
			System.out.println("deleted");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (final SQLException e) {
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
			
			final String sqlString = "SELECT DISPLAY_NAME, EMAIL_ID, UID FROM IDENTITIES " + "WHERE (? IS NULL OR DISPLAY_NAME LIKE ?) "
					+ "AND (? IS NULL OR EMAIL_ID LIKE ?) " + "AND (? IS NULL OR UID = ?)";
			
			final PreparedStatement preparedStatement = connection.prepareStatement(sqlString);

			preparedStatement.setString(1, criteria.getDisplay_name());
			preparedStatement.setString(2, criteria.getDisplay_name() + "%");
			preparedStatement.setString(3, criteria.getEmail_id());
			preparedStatement.setString(4, criteria.getEmail_id() + "%");
			preparedStatement.setString(5, criteria.getUid());
			preparedStatement.setString(6, criteria.getUid());
			

			final ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				final Identity identity = new Identity();
				
				identity.setDisplay_name(resultSet.getString(1));
				identity.setEmail_id(resultSet.getString(2));
				identity.setUid(resultSet.getString(3));
				identities.add(identity);
			}
		} catch (SQLException e) {
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
