package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import datamodel.Identity;

public class LoginDAO {

	
		// TODO Auto-generated method stub
		


public  boolean Authentication(String email, String password) {
	// TODO Auto-generated method stub
	

    boolean res=false;
	try {
        Connection con = Dbconnection.getconnection();
        PreparedStatement statement = con.prepareStatement("select EMAIL_ID, PASSWORD from IDENTITIES where EMAIL_ID=? and PASSWORD=?");
       
        
		statement.setString(1, email);
       
        
		statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
          
            System.out.println("User authenticated successfully");
            res=true;
           
			
            
   
            
            
            
            
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

