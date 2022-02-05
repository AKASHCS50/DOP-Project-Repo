/**
 * 
 */
package com.dop.exceptions;

/**
 * @author asus
 *
 */
public class UserAlreadyExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;

	public UserAlreadyExistsException(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return "User with ID " + Integer.toString(userId) + " already Exists";
	}
}
