/**
 * 
 */
package com.dop.business;

import com.dop.dao.UserDaoOperation;
import com.dop.dao.UserDaoOperationInterface;
import com.dop.validators.UserValidator;
import com.dop.exceptions.UserAlreadyExistsException;
import com.dop.bean.User;

/**
 * @author asus
 *
 */
public class UserOperation implements UserOperationInterface {

	public void registerUser(User user) {

		UserDaoOperationInterface userDaoOperation = new UserDaoOperation();
		UserValidator userValidator = new UserValidator();
		
		try {
			if (userValidator.checkIfExists(user.getUserId())) {
				throw new UserAlreadyExistsException(user.getUserId());
			}
			userDaoOperation.registerUser(user);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}
}
