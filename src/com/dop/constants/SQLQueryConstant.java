/**
 * 
 */
package com.dop.constants;

/**
 * @author asus
 *
 */
public class SQLQueryConstant {
	// User	
	public static final String GET_USER_DETAIL = "select * from user where userid = ? limit 1";
	public static final String ADD_USER_QUERY = "insert into user values (?,?,?,?)";
	
	// Post	
	public static final String ADD_POST_QUERY = "insert into post(author, title, content) values(?,?,?)";
}
