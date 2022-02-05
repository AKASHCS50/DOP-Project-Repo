/**
 * 
 */
package com.dop.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * @author asus
 *
 */
public class DBUtils {
	private static Logger logger = Logger.getLogger(DBUtils.class);

	public Connection connectionEstablish() {

		/**
		 * Fetches and establishes a connection with MySQL server with the mentioned
		 * database and login credentials
		 * 
		 * @return Connection which is used to fire queries to the connected database
		 */
		Connection connection = null;
		try {
			Properties prop = new Properties();
			InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
			prop.load(inputStream);
			@SuppressWarnings("unused")
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		logger.info("Database Connection Established");
		return connection;
	}

	/**
	 * Terminates connection with the database if instance of connection is not null
	 */
	public void connectionClose(Connection conn) {

		try {
			conn.close();
			logger.info("Database Connection Closed");
		} catch (SQLException se) {
			logger.error(se.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				logger.error(se.getMessage());
			}
		}

	}

}
