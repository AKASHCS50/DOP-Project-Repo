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
	public static final String CHANGE_PASSWORD_QUERY = "update user set password = ? where userId = ?";
	
	// Post	
	public static final String SHOW_POST_QUERY = "select * from post";
	public static final String ADD_POST_QUERY = "insert into post(author, title, content) values(?,?,?)";
	public static final String SELECT_AUTHOR_QUERY = "select author from post where postId = ?";
	public static final String DELETE_POST_QUERY = "delete from post where postId = ?";
}
