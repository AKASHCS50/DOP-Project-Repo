/**
 * 
 */
package com.dop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.dop.utils.DBUtils;
import com.dop.constants.SQLQueryConstant;
import com.dop.exceptions.ErrorInRegisteringStudentException;
import com.dop.exceptions.ErrorInUpdatingPasswordException;
import com.dop.bean.User;

/**
 * @author asus
 *
 */
public class UserDaoOperation implements UserDaoOperationInterface {

	private static Logger logger = Logger.getLogger(UserDaoOperation.class);

	public User getUser(int userId) {
		DBUtils DBUtils = new DBUtils();
		Connection conn = DBUtils.connectionEstablish();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLQueryConstant.GET_USER_DETAIL);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (rs.getInt("userId") == userId) {
					User user = new User();
					user.setUserId(userId);
					return user;
				}
			}
			return null;
		} catch (SQLException e) {
			logger.debug("Exception raised: " + e.getMessage());
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
			try {
				if (i == 0)
					throw new ErrorInRegisteringStudentException();
				else
					logger.info("User successfully created with UserID " + user.getUserId());
			} catch (ErrorInRegisteringStudentException e) {
				logger.debug("Exception raised: " + e.getMessage());
			}
		} catch (SQLException e) {
			logger.debug("Exception raised: " + e.getMessage());
		} finally {
			connectionSetup.connectionClose(conn);
		}
	}

	public void changePassword(int userId, String newp) {
		DBUtils connectionSetup = new DBUtils();
		Connection conn = connectionSetup.connectionEstablish();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLQueryConstant.CHANGE_PASSWORD_QUERY);
			stmt.setString(1, newp);
			stmt.setInt(2, userId);

			int i = stmt.executeUpdate();
			try {
				if (i == 0)
					throw new ErrorInUpdatingPasswordException();
				else
					System.out.println("Password successfully updated for UserID " + userId);
			} catch (ErrorInUpdatingPasswordException e) {
				logger.debug("Exception raised: " + e.getMessage());
			}
		} catch (SQLException e) {
			logger.debug("Exception raised: " + e.getMessage());
		} finally {
			connectionSetup.connectionClose(conn);
		}

	}
}
