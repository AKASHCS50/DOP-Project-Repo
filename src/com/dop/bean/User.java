/**
 * 
 */
package com.dop.bean;

import java.util.ArrayList;

/**
 * @author asus
 *
 */
public class User {
	private int userId;
	private String password;
	private String name;
	private String email;
	private ArrayList<Integer> posts = new ArrayList<Integer>();
	

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	/**
	 * @return the password
	 */	
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * @return the posts
	 */
	public ArrayList<Integer> getPosts() {
		return posts;
	}
	/**
	 * @param posts the posts to set
	 */
	public void setPosts(ArrayList<Integer> posts) {
		this.posts = posts;
	}
}
