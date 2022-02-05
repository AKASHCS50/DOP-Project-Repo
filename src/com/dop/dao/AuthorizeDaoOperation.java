/**
 * 
 */
package com.dop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.dop.constants.SQLQueryConstant;
import com.dop.utils.DBUtils;

/**
 * @author asus
 *
 */
public class AuthorizeDaoOperation implements AuthorizeDaoOperationInterface {

	private static Logger logger = Logger.getLogger(AuthorizeDaoOperation.class);

	public int authorizeUser(int userID, String password) {
		DBUtils DBUtils = new DBUtils();
		Connection conn = DBUtils.connectionEstablish();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLQueryConstant.GET_USER_DETAIL);
			stmt.setInt(1, userID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("userId") == userID && rs.getString("password").equals(password)) {
					return userID;
				}
			}
			return -1;
		} catch (SQLException e) {
			logger.debug("Exception raised: " + e.getMessage());
			return -1;
		} finally {
			DBUtils.connectionClose(conn);
		}
	}
}
