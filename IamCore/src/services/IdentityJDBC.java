package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datamodel.Identity;
import exception.*;
import logger.Logger;


public class IdentityJDBC implements IdentityDAO {

	private static final Logger logger = new Logger(IdentityJDBC.class);
	/* 
	 * @see services.IdentityDAO#create(datamodel.Identity)
	 *  * <h3>Description</h3>
	 * <p>
     * This method is used to create an user by creating the identity
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 * the values for the identity is set by getting the values from the user and set using preparestatement
	 */
	@Override
	public void create(Identity identity) throws DaoCreateException{
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
			logger.info("User"+ identity.getUid()+"Created");

			
		} catch (SQLException e) {
		
			DaoCreateException exception = new DaoCreateException();
			exception.initCause(e);
			exception.setFaultObject(identity);
			throw exception;
			
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (final SQLException e) {
				logger.error(e.getMessage());
				e.printStackTrace();

			}
		}

	}

	/* 
	 * @see services.IdentityDAO#update(datamodel.Identity)
	 *  * <h3>Description</h3>
	 * <p>
     *   This method is used to update an account which already exists
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 * The update operation is done by getting the display name and the email id if the user wants to 
	 * perform an operation
	 * </p>
	 */
	@Override
	public void update(Identity identity) throws DaoUpdateException {
		Connection conn = null;

		try {
			conn = Dbconnection.getconnection();
			
	        
	        
	        
			
			if(identity.getDisplay_name()!=null)
			{	
			String query = "UPDATE IDENTITIES SET DISPLAY_NAME=? WHERE UID=?";
			final PreparedStatement preparedstatement = conn.prepareStatement(query);
			preparedstatement.setString(1, identity.getDisplay_name());
			preparedstatement.setString(2, identity.getUid());
			preparedstatement.executeUpdate();
			
			
			
			}
//			
			if(identity.getEmail_id()!=null)
			{
				String query = "UPDATE IDENTITIES SET EMAIL_ID=? WHERE UID=?";
				final PreparedStatement preparedstatement = conn.prepareStatement(query);
				preparedstatement.setString(1, identity.getEmail_id());
				preparedstatement.setString(2, identity.getUid());
				
			
				
			}
			

			
			
		} catch (SQLException e) {
			DaoUpdateException exception = new DaoUpdateException();
			exception.initCause(e);
			exception.setUpdateFailed(identity);
			throw exception;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				
			} catch (final SQLException e) {
				logger.info(e.getMessage());
				e.printStackTrace();

			}
		}

	}

	
	/* (non-Javadoc)
	 * @see services.IdentityDAO#delete(datamodel.Identity)
	 * * <h3>Description</h3>
	 * <p>
     *   This method is used to delete an account 
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 * This can be done by comparing the uid to the database and the corresponding identity can be deleted
	 * </p>
	 * 
	 */
	@Override
	public void delete(Identity identity) throws DaoDeleteException {
		// TODO Auto-generated method stub

		Connection conn = null;
		try {

			conn = Dbconnection.getconnection();
			String query = "DELETE FROM IDENTITIES where UID =? ";
			final PreparedStatement preparedstatement = conn.prepareStatement(query);
			preparedstatement.setString(1, identity.getUid());

			preparedstatement.executeUpdate();
			System.out.println("deleted");

		} catch (SQLException e) {
			DaoDeleteException exception = new DaoDeleteException();
			exception.initCause(e);
			exception.setUpdateFailed(identity);
			throw exception;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (final SQLException e) {
				logger.error(e.getMessage());
				e.printStackTrace();

			}
		}

	}

	/* (non-Javadoc)
	 * @see services.IdentityDAO#search(datamodel.Identity)
	 *  <h3>Description</h3>
	 * <p>
     *   This method is used to search a user who is also a user of our application 
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 * By giving the full name or part of the name and then search it
	 * </p> 
	 */
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
