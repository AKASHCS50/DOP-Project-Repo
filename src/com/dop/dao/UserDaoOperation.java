/**
 * 
 */
package com.dop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dop.utils.DBUtils;
import com.dop.constants.SQLQueryConstant;
import com.dop.exceptions.ErrorInRegisteringStudentException;
import com.dop.bean.User;

/**
 * @author asus
 *
 */
public class UserDaoOperation implements UserDaoOperationInterface {
	
	public User getUser (int userId) {
		DBUtils DBUtils = new DBUtils();
	    Connection conn = DBUtils.connectionEstablish();
		try {
		    PreparedStatement stmt=conn.prepareStatement(SQLQueryConstant.GET_USER_DETAIL);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery(); 
			
			while (rs.next()) {
				if (rs.getInt("userId")==userId) {
					User user = new User();
					user.setUserId(userId);
					return user;
				}
			}
			return null;
		} catch (SQLException e) {
		    System.out.println("Exception raised: "+e.getMessage());
		    return null;
		} finally {
			DBUtils.connectionClose(conn);	
		}
	}

	public void registerUser(User user) {
		DBUtils connectionSetup = new DBUtils();
		Connection conn = connectionSetup.connectionEstablish();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLQueryConstant.ADD_USER_QUERY);
			stmt.setInt(1, user.getUserId());
		    stmt.setString(2, user.getPassword());
		    stmt.setString(3, user.getName());
		    stmt.setString(4, user.getEmail());
		    
		    int i = stmt.executeUpdate();
		    try{
		    	if(i==0) 
		    		throw new ErrorInRegisteringStudentException();
		    	else
		    		System.out.println("User successfully created with UserID " + user.getUserId());
		    }catch(ErrorInRegisteringStudentException e){
		    	System.out.println(e.getMessage());
		    }

		} catch (SQLException e) {
			System.out.println("Exception raised: " + e.getMessage());
		} finally {
			connectionSetup.connectionClose(conn);
		}
	}
}
