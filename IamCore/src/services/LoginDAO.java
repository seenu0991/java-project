package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import datamodel.Identity;

public class LoginDAO {

	// TODO Auto-generated method stub

	/**
	 * 
	 * @param uid The uid
	 * @param password The password
	 * @return
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

				System.out.println("User authenticated successfully");
				res = true;

			} else {
				System.out.println("Invalid username or password!");
			}
		} catch (Exception e) {
			System.out.println("DB related Error");
			e.printStackTrace();
		}
		return res;

	}

}
