/**
 * 
 */
package com.dop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dop.bean.Post;
import com.dop.business.PostOperationInterface;
import com.dop.constants.SQLQueryConstant;
import com.dop.exceptions.ErrorInRegisteringStudentException;
import com.dop.utils.DBUtils;

/**
 * @author asus
 *
 */
public class PostDaoOperation implements PostDaoOperationInterface {

	public void addPost(Post post) {
		// TODO Auto-generated method stub
		DBUtils connectionSetup = new DBUtils();
		Connection conn = connectionSetup.connectionEstablish();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLQueryConstant.ADD_POST_QUERY, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, post.getAuthor());
			stmt.setString(2, post.getTitle());
			stmt.setString(3, post.getContent());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			try {
				if (rs.next()) {
					int pid = rs.getInt(1);
					System.out.println("Post successfully created with PostID " + pid);
				} else
					throw new ErrorInRegisteringStudentException();
			} catch (ErrorInRegisteringStudentException e) {
				System.out.println(e.getMessage());
			}

		} catch (SQLException e) {
			System.out.println("Exception raised: " + e.getMessage());
		} finally {
			connectionSetup.connectionClose(conn);
		}
	}

	public void deletePost(int postId) {
		// TODO Auto-generated method stub

	}

}
