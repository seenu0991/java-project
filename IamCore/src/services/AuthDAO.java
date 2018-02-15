package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datamodel.Auth;
import datamodel.Identity;

public class AuthDAO implements AuthInterface {
	
	boolean userFound=false;

	@Override
	public boolean authenticate(Auth auth) {
		try {
			Connection conn = Dbconnection.getconnection();
			
			
			PreparedStatement preparedstatement  = conn
					.prepareStatement("select * from AUTH");
			
		final ResultSet resultSet = preparedstatement.executeQuery();
		while (resultSet.next()) {
			if(resultSet.getInt("IDENTITY_ID")==auth.getIdentityId() && resultSet.getString("PASSWORD").equalsIgnoreCase(auth.getPassword()))
			{	userFound=true;
				break;
				}
				
		}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return userFound;
	}

}
