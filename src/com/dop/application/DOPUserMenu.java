/**
 * 
 */
package com.dop.application;

import java.util.Scanner;

import com.dop.bean.Post;
import com.dop.business.PostOperation;
import com.dop.business.PostOperationInterface;

/**
 * @author asus
 *
 */
public class DOPUserMenu {

	private int userID;

	public DOPUserMenu(int new_id) {
		// TODO Auto-generated constructor stub
		this.userID = new_id;
	}

	public void UserMenu() {
		// TODO Auto-generated method stub
		System.out.println("Welcome User " + userID);

		int choice = 0;
		Scanner sc = new Scanner(System.in);

		while (choice != 5) {
			
			System.out.println("Menu");
			System.out.println("Enter 1 to Display All Posts");
			System.out.println("Enter 2 to Update Password");
			System.out.println("Enter 3 to Add Post");
			System.out.println("Enter 4 to Delete Post");
			System.out.println("Enter 5 to Logout");
			
			choice = sc.nextInt();

			switch(choice) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					sc.nextLine();
					System.out.println("Enter Post Title");
					String title = sc.nextLine();
					System.out.println("Enter Post Content");
					String content = sc.nextLine();
					System.out.println("Enter Y to Create Post, N to Cancel");
					char op = sc.next().charAt(0);
					if(op == 'Y' || op == 'y')
					{
						Post post = new Post();
						post.setAuthor(userID);
						post.setTitle(title);
						post.setContent(content);
						PostOperationInterface postOperation = new PostOperation();
						postOperation.addPost(post);
					}
					break;
				case 4: 
					
					break;
				case 5:
					
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		}
		
		sc.close();
	}

}
