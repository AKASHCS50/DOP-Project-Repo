/**
 * 
 */
package com.dop.application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.dop.bean.Post;
import com.dop.business.PostOperation;
import com.dop.business.PostOperationInterface;
import com.dop.business.UserOperation;
import com.dop.business.UserOperationInterface;

/**
 * @author asus
 *
 */
public class DOPUserMenu {

	private int userID;
	private static Logger logger = Logger.getLogger(DOPUserMenu.class);
	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();

	public DOPUserMenu(int new_id) {
		// TODO Auto-generated constructor stub
		this.userID = new_id;
	}

	public void UserMenu() {
		// TODO Auto-generated method stub
		System.out.println("Welcome User " + userID);
		System.out.print("Login Date:- "+ localDate.getDayOfMonth()+" "+localDate.getMonth()+", "+localDate.getYear());
		System.out.println("  Login Time:- " + localTime+"  ");
		
		int choice = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (choice != 5) {

			System.out.println("User Menu");
			System.out.println("Enter 1 to Display All Posts");
			System.out.println("Enter 2 to Update Password");
			System.out.println("Enter 3 to Add Post");
			System.out.println("Enter 4 to Delete Post");
			System.out.println("Enter 5 to Logout");

			choice = sc.nextInt();

			UserOperationInterface userOperation = new UserOperation();
			PostOperationInterface postOperation = new PostOperation();

			switch (choice) {
			case 1:
				postOperation.showPost();
				break;
			case 2:
				System.out.println("Enter New Password");
				String newp = sc.next();
				System.out.println("Confirm New Password");
				String newc = sc.next();
				userOperation.changePassword(userID, newp, newc);
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter Post Title");
				String title = sc.nextLine();
				System.out.println("Enter Post Content");
				String content = sc.nextLine();
				System.out.println("Enter Y to Create Post, N to Cancel");
				char op = sc.next().charAt(0);
				if (op == 'Y' || op == 'y') {
					Post post = new Post();
					post.setAuthor(userID);
					post.setTitle(title);
					post.setContent(content);
					postOperation.addPost(post);
				}
				break;
			case 4:
				System.out.println("Enter PostID of Post to be deleted");
				int postID = sc.nextInt();
				System.out.println("Enter Y to Delete Post, N to Cancel");
				char op1 = sc.next().charAt(0);
				if (op1 == 'Y' || op1 == 'y')
					postOperation.deletePost(userID, postID);
				break;
			case 5:
				logger.info("Logging Out !");
				break;
			default:
				logger.info("Invalid Choice");
				break;
			}
		}

	}

}
