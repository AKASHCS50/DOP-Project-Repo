/**
 * 
 */
package com.dop.constants;

/**
 * @author asus
 *
 */
public class SQLQueryConstant {
	public static final String GET_USER_DETAIL = "select * from user where userid = ?";
	public static final String ADD_USER_QUERY = "insert into user values (?,?,?,?)";
}
