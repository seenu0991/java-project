package services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import datamodel.Identity;

public class IdenitityJdbcSample implements IdentityDAO {

	public static void main(String ar[])
	{
		
		
	    public void create(Identity user) {
	        try {
	            Connection con = Dbconnection.getconnection();
	            String query = "insert into Identites (USR_FIRST_NAME,USR_LST_NAME,USR_PRIMARY_EMAIL,USR_PASSWORD) values(?,?,?,?)";
	            PreparedStatement pst = con.prepareStatement(query);

	            pst.setString(1, user.getUid());
	            pst.setString(2, user.getDisplay_name());
	            pst.setString(3, user.getEmail_id());
	           
	            pst.executeUpdate();
	        } catch (Exception e) {
	            System.out.println("@@@@Record insertion error in Registration DAO@@@@");
	            e.printStackTrace();
	        }
	    }
	}
}
	
	
	

