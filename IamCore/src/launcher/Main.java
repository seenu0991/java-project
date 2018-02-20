package launcher;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import datamodel.Identity;
import exception.DaoCreateException;
import logger.LogConfig;
import logger.Logger;
import services.IdentityJDBC;
import services.LoginDAO;

public class Main {

	static Scanner userInput = new Scanner(System.in);
	IdentityJDBC identitydaoc = new IdentityJDBC();
	
	public static final Logger logger = new Logger (Main.class);	
	
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		
		
	
		
		
		Date date = new Date(); 
		System.out.println(date);
		
		DisplayLoginOrSignUp();
		
		
	}

	

	/**
	 * Displays the user profile once he is successfully logged in and the actions he can perform
	 * @param identity
	 * @throws SQLException
	 */
	public static void DisplayMenu(Identity identity) throws SQLException {

		String READ_MENU;
		IdentityJDBC identitydaou = new IdentityJDBC();
		boolean deleted = false;

		while (true) {
			// Display menu graphics
			System.out.println("*****************************************");
			System.out.println("|   WELCOME TO YOUR PROFILE               |");
			System.out.println("*****************************************");
			System.out.println("| Edit your profile:                      |");
			System.out.println("|        1. Update your details           |");
			System.out.println("|        2. Delete your account           |");
			System.out.println("|        3. Search friend users           |");
			System.out.println("|        4. Log out                       |");
			System.out.println("|        5. Exit                          |");
			System.out.println("*****************************************");

			System.out.print("Select option: ");

			READ_MENU = userInput.next();

			// display menu based on user selection

			switch (READ_MENU) {

			case "1":

				System.out.println(identitydaou.search(identity));

				System.out.println("Enter the display name: ");
				identity.setDisplay_name(userInput.next());
				System.out.println("Enter the email id: ");
				identity.setEmail_id(userInput.next());

				identitydaou.update(identity);

				break;
			case "2":

				IdentityJDBC identitydaod = new IdentityJDBC();
				identitydaod.delete(identity);
				deleted = true;
				DisplayLoginOrSignUp();
				break;
			case "3":
				// Display the options to update
				Identity IdentitySearch = new Identity();
				
				System.out.println("Search a user who is also using this app:");
				System.out.println("Enter display name :");
				String displayName=userInput.next();;
				IdentitySearch.setDisplay_name(displayName);
				
				
				
				System.out.println(identitydaou.search(IdentitySearch));
				break;
				
			case "4":
				System.out.println("You have logged out.. Have a nice day!");
				DisplayLoginOrSignUp();

				break;
				
			case "5":
				System.exit(0);
			default:
				System.out.println("Invalid selection");
				break;
			}
			
			if (deleted)
				break;
		}

	}

	/**
	 * Displays the user menu for creating a new account and passes the values to IdentityJdbc
	 */
	public static void createAcc()
	{
		System.out.println("Create an account:");
		Identity identity1 = new Identity();
		System.out.println("Enter your User Id:(eg:1234)");
		identity1.setUid(userInput.next());
		System.out.println("Enter your User Display Name:");
		identity1.setDisplay_name(userInput.next());
		System.out.println("Enter your Email Id:");
		identity1.setEmail_id(userInput.next());
		String p1,p2;
		
		boolean PassMatchCheck=true;
		do{
			
		System.out.println("Enter your Password:");
		p1=userInput.next();
		System.out.println("Enter your Password again:");
		p2=userInput.next();
		if(p1.equals(p2))
		{
			identity1.setPassword(p1);
			PassMatchCheck=false;
			System.out.println("Account creation successful");
			
			logger.info("User created :");
		}	
		else
		{
			System.out.println("The Passwords dont match! ReEnter!");
		}
			
		}while(PassMatchCheck);

		// Dbconnection.getconnection();
		IdentityJDBC identitydaoc = new IdentityJDBC();
		try {
			identitydaoc.create(identity1);
		} catch (DaoCreateException e) {
			// TODO Auto-generated catch block
			System.out.println("UserID already exists. Try Again with another UserID "+e.getMessage());
		}
		
		}	
		
		
	
	/**
	 * Displays the option for the user whether to login or signup
	 */
	public static void DisplayLoginOrSignUp()
	{
		System.out.println("1.Login to your account");
		System.out.println("2.Sign Up");
		int LogOrSignUp;
		LogOrSignUp= userInput.nextInt();
		switch(LogOrSignUp)
	   {
	case 1:
	Login();
	case 2:
		createAcc();
		DisplayLoginOrSignUp();
	
	   }
	}
/**
 * Displays the login prompt for the user and performs authentication check
 */
public static void Login(){
		
		do {

			Scanner sc = new Scanner(System.in);
			System.out.println("Login:");
			System.out.println("Enter Your Uid");
			String uid = sc.next();
			System.out.println("Enter Password");
			String password = sc.next();

			LoginDAO aut = new LoginDAO();
			Identity identity = new Identity();

			if (aut.Authentication(uid, password)) {
				identity.setUid(uid);
				try {
					DisplayMenu(identity);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else {
				DisplayLoginOrSignUp();
				

			}
		} while (true);

	}

	
}
