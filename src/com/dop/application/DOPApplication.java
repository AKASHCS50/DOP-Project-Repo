/**
 * 
 */
package com.dop.application;

import java.util.Scanner;

import com.dop.bean.User;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to DOP Application");

		int choice = 0;
		Scanner sc = new Scanner(System.in);

		while (choice != 3) {
			System.out.println("Menu");
			System.out.println("Enter 1 to Register");
			System.out.println("Enter 2 to Login");
			System.out.println("Enter 3 to Exit");

			choice = sc.nextInt();
			
			UserOperationInterface userOperation = new UserOperation();

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
				userOperation.registerUser(user);
				break;
			case 2:
				System.out.println("Enter UserID");
				int id = sc.nextInt();
				System.out.println("Enter Password");
				String pass = sc.next();
				break;
			case 3:
				System.out.println("Exiting !");
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
		
		sc.close();
	}

}
