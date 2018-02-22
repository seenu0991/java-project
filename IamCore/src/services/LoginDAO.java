package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import logger.Logger;


public class LoginDAO {

	private static final Logger logger = new Logger(LoginDAO.class);
	// TODO Auto-generated method stub

	/**
	 * 
	 * @param uid The uid
	 * @param password The password
	 * @return res
	 *  <h3>Description</h3>
	 * <p>
     *   This method is used to perform the authentication and then find out if the user has entered the correct credentials
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 * This can be done by comparing the uid and passaord to the database and check if they are present and they match 
	 * and the user is given access to his account
	 * </p>
	 */
	public boolean Authentication(String uid, String password) {
		// TODO Auto-generated method stub
		

		boolean res = false;
		try {
			Connection con = Dbconnection.getconnection();
			PreparedStatement statement = con
					.prepareStatement("select * from IDENTITIES where UID=? and PASSWORD=?");

			statement.setString(1, uid);

			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if (result.next()) {

			
				res = true;
				

			} else {
				System.out.println("Invalid username or password!");
			}
		} catch (Exception e) {
			logger.error("DB related Error");
			e.printStackTrace();
		}
		return res;

	}
	
	

}
