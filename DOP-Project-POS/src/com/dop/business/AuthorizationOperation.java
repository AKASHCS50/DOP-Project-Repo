/**
 * 
 */
package com.dop.business;

import com.dop.dao.AuthorizeDaoOperation;
import com.dop.dao.AuthorizeDaoOperationInterface;

/**
 * @author asus
 *
 */
public class AuthorizationOperation implements AuthorizationOperationInterface {

	AuthorizeDaoOperationInterface authorizeDaoOperation = new AuthorizeDaoOperation();

	public int authorizeUser(int userID, String password) {

		return authorizeDaoOperation.authorizeUser(userID, password);
	}
}
