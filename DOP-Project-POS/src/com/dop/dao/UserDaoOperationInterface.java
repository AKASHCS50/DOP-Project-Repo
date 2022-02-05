/**
 * 
 */
package com.dop.dao;

import com.dop.bean.User;

/**
 * @author asus
 *
 */


public interface UserDaoOperationInterface {

	public User getUser (int userId);
	public void registerUser(User user);
	public void changePassword(int userId, String newp);
}
