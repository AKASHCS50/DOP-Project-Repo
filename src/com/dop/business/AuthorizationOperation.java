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
	public int authorizeUser(int userID, String password) {
		
		AuthorizeDaoOperationInterface authorizeDaoOperation = new AuthorizeDaoOperation();
		return authorizeDaoOperation.authorizeUser(userID, password);
	}
}
