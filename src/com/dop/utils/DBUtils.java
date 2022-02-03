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

/**
 * @author asus
 *
 */
public class DBUtils {
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
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Database Connection Established.");
		return connection;
	}

	/**
	 * Terminates connection with the database if instance of connection is not null
	 */
	public void connectionClose(Connection conn) {

		try {

			conn.close();
			System.out.println("Database Connection Closed.");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}

	}
}