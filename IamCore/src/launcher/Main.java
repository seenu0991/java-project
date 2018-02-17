package launcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import datamodel.Identity;
import services.Dbconnection;
import services.IdentityDAO;
import services.IdentityJDBC;
import services.LoginDAO;

public class Main {
	
	  static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) throws SQLException {

		LoginDAO aut = new LoginDAO();
		Identity identity = new Identity();
		 Scanner sc = new Scanner(System.in);
	        System.out.println("Enter email");
	        String email=sc.next();
	        String password=sc.next();
	       identity.getEmail_id()
	       identity.getPassword()
		
		do {
		
			
			
			
		if(aut.Authentication(email,password))
		DisplayMenu(identity);
		else
		{
			System.out.println("Create new user");
			Identity identity1 = new Identity(); 
           	identity1.setUid(userInput.next());
           	identity1.setDisplay_name(userInput.next());
           	identity1.setEmail_id(userInput.next());
           	identity1.setPassword(userInput.next());
           	IdentityJDBC identitydaoc = new IdentityJDBC();
           	//Dbconnection.getconnection();
           	identitydaoc.create(identity1);
          
			
		}
		}while(true);
		
	}
	
	
	
	public static void DisplayMenu(Identity identity) throws SQLException {
      
        String READ_MENU;
        while(true) {
        // Display menu graphics
        System.out.println("*****************************************");
        System.out.println("|   IDENTITY MANAGEMENT                  |");
        System.out.println("*****************************************");
        System.out.println("| Options:                              |");
        System.out.println("|        1. update Database Records       |");
        System.out.println("|        2. delete Database Records       |");
        System.out.println("|        3. Exit                          |");
        System.out.println("*****************************************");

        System.out.print("Select option: ");

        READ_MENU = userInput.next();

//display menu based on user selection
       
        switch (READ_MENU) {
            
            case "1":
       
               	identity.setDisplay_name(userInput.next());
               	identity.setEmail_id(userInput.next());
               	identity.setPassword(userInput.next());
             	IdentityJDBC identitydaou = new IdentityJDBC();
             	
                   	identitydaou.update(identity);
            	
            	
            	
                break;
            case "2":
        
            	
            	
           	
             	IdentityJDBC identitydaod = new IdentityJDBC();
            	identitydaod.delete(identity);
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection");
                break; 
        }
    }
}
	
}
	


