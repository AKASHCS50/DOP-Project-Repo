/**
 * 
 */
package com.dop.application;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.dop.bean.User;
import com.dop.business.AuthorizationOperation;
import com.dop.business.AuthorizationOperationInterface;
import com.dop.business.UserOperation;
import com.dop.business.UserOperationInterface;

/**
 * @author asus
 *
 */
public class DOPApplication {

	/**
	 * @param args
	 */

	private static Logger logger = Logger.getLogger(DOPApplication.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to DOP Application");

		int choice = 0;
		Scanner sc = new Scanner(System.in);

		while (choice != 3) {
			System.out.println("Main Menu");
			System.out.println("Enter 1 to Register");
			System.out.println("Enter 2 to Login");
			System.out.println("Enter 3 to Exit");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				User user = new User();
				System.out.println("Enter UserID");
				int userId = sc.nextInt();
				user.setUserId(userId);
				System.out.println("Enter Password");
				String password = sc.next();
				user.setPassword(password);
				System.out.println("Enter Name");
				String name = sc.next();
				user.setName(name);
				System.out.println("Enter Email");
				String email = sc.next();
				user.setEmail(email);
				UserOperationInterface userOperation = new UserOperation();
				userOperation.registerUser(user);
				break;
			case 2:
				System.out.println("Enter UserID");
				int id = sc.nextInt();
				System.out.println("Enter Password");
				String pass = sc.next();
				AuthorizationOperationInterface authorizationOperation = new AuthorizationOperation();
				int new_id = authorizationOperation.authorizeUser(id, pass);
				if (new_id != -1) {
					logger.info("User logged in as " + new_id);
					DOPUserMenu dopusermenu = new DOPUserMenu(new_id);
					dopusermenu.UserMenu();
					break;
				} else
					logger.info("Invalid UserID or Password");
				break;
			case 3:
				logger.info("Exiting !");
				break;
			default:
				logger.info("Invalid Choice");
				break;
			}
		}

		sc.close();
	}

}
