package launcher;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import datamodel.Identity;
import exception.DaoCreateException;
import exception.DaoDeleteException;
import exception.DaoUpdateException;
import logger.Logger;
import services.IdentityJDBC;
import services.LoginDAO;

public class Main {

	static Scanner userInput = new Scanner(System.in);
	IdentityJDBC identitydaoc = new IdentityJDBC();

	private static final Logger logger = new Logger(Main.class);

	public static void main(String[] args) throws SQLException, FileNotFoundException {

		DisplayLoginOrSignUp();

	}

	/**
	 * 	 * <h3>Description</h3>
	 * <p>
	 * Displays the user profile once he is successfully logged in and the actions
	 * he can perform
	 * </p>
	 * <h3>Usage</h3>
	 * the display of the menu is done to allow the user to perform certain operations
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
			System.out.println("|   WELCOME TO YOUR PROFILE Id=" + identity.getUid() + "       |");
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

				System.out.println("Enter the display name: (If you dont want to update, press 0)");

				String dispName;
				userInput.nextLine();
				dispName = userInput.nextLine();
				if (dispName.equals("0"))
					System.out.println("Display name not updated!");
				else
					identity.setDisplay_name(dispName);

				System.out.println("Enter the email id: (If you dont want to update, press 0) ");

				String emailId = userInput.nextLine();
				if (emailId.equals("0"))
					System.out.println("Email Id not updated!");
				else
					identity.setEmail_id(emailId);

				try {
					identitydaou.update(identity);
				} catch (DaoUpdateException e) {
					logger.info("Update Unsuccessful" + e.getMessage());
				}

				break;
			case "2":

				IdentityJDBC identitydaod = new IdentityJDBC();
				try {
					identitydaod.delete(identity);

				} catch (DaoDeleteException e) {
					logger.info("Delete Unsuccessful" + e.getMessage());

				}
				deleted = true;
				DisplayLoginOrSignUp();
				break;
			case "3":
				// Display the options to update
				Identity IdentitySearch = new Identity();

				System.out.println("Search a user who is also using this app:");
				System.out.println("Enter display name or part of the name :");
				userInput.nextLine();
				String displayName = userInput.nextLine();
				;
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
	
	 * <h3>Description</h3>
	 * <p>
 * Displays the user menu for creating a new account and passes the values to IdentityJdbc	 
 * </p>
 *  *  <h3>Usage</h3>
 *  the new user account is created and using this, the user can login to his profile later and only the users with the account can access the profile
	 * 
	 */
	public static void createAcc() {
		System.out.println("Create an account:");
		Identity identity1 = new Identity();
		System.out.println("Enter an User Id:(eg:1234)");
		userInput.nextLine();
		identity1.setUid(userInput.nextLine());
		System.out.println("Enter your Display Name:");

		identity1.setDisplay_name(userInput.nextLine());

		System.out.println("Enter your Email Id:");
		identity1.setEmail_id(userInput.nextLine());
		String p1, p2;

		boolean PassMatchCheck = true;
		do {

			System.out.println("Enter your Password:");

			p1 = userInput.nextLine();
			System.out.println("Enter your Password again:");

			p2 = userInput.nextLine();
			if (p1.equals(p2)) {
				identity1.setPassword(p1);
				PassMatchCheck = false;

				logger.info("User created :");
			} else {
				System.out.println("The Passwords dont match! ReEnter!");
			}

		} while (PassMatchCheck);

		// Dbconnection.getconnection();
		IdentityJDBC identitydaoc = new IdentityJDBC();
		try {
			identitydaoc.create(identity1);
		} catch (DaoCreateException e) {
			// TODO Auto-generated catch block
			System.out.println("UserID already exists. Try Again with another UserID " + e.getMessage());
		}

	}

	/**
	 *  * * 	 * <h3>Description</h3>
	 * <p>
	 * Displays the option for the user whether to login to his account or create a new account and become an user
	 * </p>
	 *  <h3>Usage</h3>
	 * This is done using a switch case in which the user can choose what to operation to perform
	 *  and then he is redirected to the option desired
	 * 
	 */
	public static void DisplayLoginOrSignUp() {
		System.out.println("Bienvenue");
		System.out.println("1.Login to your account");
		System.out.println("2.Sign Up");
		System.out.println("3.Exit");
		int LogOrSignUp;
		LogOrSignUp = userInput.nextInt();
		switch (LogOrSignUp) {
		case 1:
			Login();
			break;
		case 2:
			createAcc();
			DisplayLoginOrSignUp();
			break;
		case 3:
			System.exit(0);
	default:
		System.out.println("Invalid choice");
		DisplayLoginOrSignUp();

		}
	}

	/**
	 *  *  * * 	 * <h3>Description</h3>
	 * <p>
	 * Displays the login prompt for the user and performs authentication check
	 * </p>
	 *  *  <h3>Usage</h3>
	 *  This can be used by prompting the user to enter the user id and password and check whether it is correct credentials
	
	 */

	public static void Login() {

		do {

			System.out.println("Login:");
			System.out.println("Enter Your Uid");
			userInput.nextLine();
			String uid = userInput.nextLine();
			System.out.println("Enter Password");
			String password = userInput.nextLine();

			LoginDAO aut = new LoginDAO();
			Identity identity = new Identity();

			if (aut.Authentication(uid, password)) {

				identity.setUid(uid);

				try {

					logger.info("User:" + uid + " logged in");
					System.out.println("Login successful");
					DisplayMenu(identity);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			else {
				logger.error("Login failed");
				DisplayLoginOrSignUp();

			}
		} while (true);

	}

}
