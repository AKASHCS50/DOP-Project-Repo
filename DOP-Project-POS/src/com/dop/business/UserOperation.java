/**
 * 
 */
package com.dop.business;

import com.dop.dao.UserDaoOperation;
import com.dop.dao.UserDaoOperationInterface;
import com.dop.validators.UserValidator;
import com.dop.exceptions.UserAlreadyExistsException;

import org.apache.log4j.Logger;

import com.dop.bean.User;

/**
 * @author asus
 *
 */
public class UserOperation implements UserOperationInterface {

	UserDaoOperationInterface userDaoOperation = new UserDaoOperation();
	UserValidator userValidator = new UserValidator();
	private static Logger logger = Logger.getLogger(UserOperation.class);

	public void registerUser(User user) {

		try {
			if (userValidator.checkIfExists(user.getUserId())) {
				throw new UserAlreadyExistsException(user.getUserId());
			}
			userDaoOperation.registerUser(user);
		} catch (UserAlreadyExistsException e) {
			logger.debug("Exception raised: " + e.getMessage());
		}
	}

	public void changePassword(int userId, String newp, String newc) {

		if (newp.equals(newc))
			userDaoOperation.changePassword(userId, newp);
		else
			logger.info("Passwords do not match");
	}
}
