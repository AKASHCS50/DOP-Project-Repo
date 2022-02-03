/**
 * 
 */
package com.dop.validators;

import com.dop.dao.UserDaoOperation;
import com.dop.dao.UserDaoOperationInterface;

/**
 * @author aditya
 *
 */
public class UserValidator {
	UserDaoOperationInterface userDaoOperation = new UserDaoOperation();
	
	public boolean checkIfExists (int userId) {
		if (userDaoOperation.getUser(userId) != null) {
			return true;
		}
		
		return false;
	}
	
	public boolean equals (String s1, String s2) {
		return s1.equals(s2);
	}
}
