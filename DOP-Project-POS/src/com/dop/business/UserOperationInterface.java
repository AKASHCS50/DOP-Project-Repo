/**
 * 
 */
package com.dop.business;

import com.dop.bean.User;

/**
 * @author asus
 *
 */
public interface UserOperationInterface {
		public void registerUser(User user);
		public void changePassword(int userId, String newp, String newc);
}
