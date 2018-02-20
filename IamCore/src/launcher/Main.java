package launcher;

import java.sql.SQLException;
import java.util.Scanner;

import datamodel.Identity;
import services.IdentityJDBC;
import services.LoginDAO;

public class Main {

	static Scanner userInput = new Scanner(System.in);
	IdentityJDBC identitydaoc = new IdentityJDBC();
	public static void main(String[] args) throws SQLException {
		
	
		
		DisplayLoginOrSignUp();
		
		
	}

	

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
			System.out.println("|        4. Exit the program              |");
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
			default:
				System.out.println("Invalid selection");
				break;
			}
			
			if (deleted)
				break;
		}

	}

	public static void createAcc()
	{
		System.out.println("Create an account:");
		Identity identity1 = new Identity();
		System.out.println("Enter your User Id:");
		identity1.setUid(userInput.next());
		System.out.println("Enter your User Display Name:");
		identity1.setDisplay_name(userInput.next());
		System.out.println("Enter your Email Id:");
		identity1.setEmail_id(userInput.next());
		System.out.println("Enter your Password:");
		identity1.setPassword(userInput.next());

		// Dbconnection.getconnection();
		IdentityJDBC identitydaoc = new IdentityJDBC();
		identitydaoc.create(identity1);
		}	
		
		
	
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
