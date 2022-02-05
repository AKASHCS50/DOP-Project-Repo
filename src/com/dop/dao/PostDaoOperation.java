/**
 * 
 */
package com.dop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.dop.bean.Post;
import com.dop.constants.SQLQueryConstant;
import com.dop.exceptions.ErrorInDeletingPostException;
import com.dop.exceptions.ErrorInRegisteringStudentException;
import com.dop.utils.DBUtils;

/**
 * @author asus
 *
 */
public class PostDaoOperation implements PostDaoOperationInterface {

	private static Logger logger = Logger.getLogger(PostDaoOperation.class);

	public void showPost() {
		DBUtils DBUtils = new DBUtils();
		Connection conn = DBUtils.connectionEstablish();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLQueryConstant.SHOW_POST_QUERY);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				logger.info("PostID : " + rs.getInt("postId") + "  Author : " + rs.getInt("author")
						+ "  Title : " + rs.getString("title") + "  Content : " + rs.getString("content"));
			}
		} catch (SQLException e) {
			logger.debug("Exception raised: " + e.getMessage());
		} finally {
			DBUtils.connectionClose(conn);
		}
	}

	public void addPost(Post post) {
		// TODO Auto-generated method stub
		DBUtils connectionSetup = new DBUtils();
		Connection conn = connectionSetup.connectionEstablish();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLQueryConstant.ADD_POST_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, post.getAuthor());
			stmt.setString(2, post.getTitle());
			stmt.setString(3, post.getContent());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			try {
				if (rs.next()) {
					int pid = rs.getInt(1);
					logger.info("Post successfully created with PostID " + pid);
				} else
					throw new ErrorInRegisteringStudentException();
			} catch (ErrorInRegisteringStudentException e) {
				logger.debug("Exception raised: " + e.getMessage());
			}

		} catch (SQLException e) {
			logger.debug("Exception raised: " + e.getMessage());
		} finally {
			connectionSetup.connectionClose(conn);
		}
	}

	public void deletePost(int userId, int postId) {
		// TODO Auto-generated method stub
		DBUtils DBUtils = new DBUtils();
		Connection conn = DBUtils.connectionEstablish();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLQueryConstant.SELECT_AUTHOR_QUERY);
			stmt.setInt(1, postId);
			ResultSet rs = stmt.executeQuery();

			if (!rs.isBeforeFirst()) {
				logger.info("Invalid PostId");
			} else {
				while (rs.next()) {
					if (rs.getInt("author") == userId) {
						try {
							PreparedStatement stmt1 = conn.prepareStatement(SQLQueryConstant.DELETE_POST_QUERY);
							stmt1.setInt(1, postId);
							int i = stmt1.executeUpdate();
							try {
								if (i == 0)
									throw new ErrorInDeletingPostException();
								else
									logger.info("Post successfully deletd with PostID " + postId);
							} catch (ErrorInDeletingPostException e) {
								logger.debug("Exception raised: " + e.getMessage());
							}
						} catch (SQLException e) {
							logger.debug("Exception raised: " + e.getMessage());
						}
					} else
						logger.info("You are not the owner of this post");
				}
			}
		} catch (SQLException e) {
			logger.debug("Exception raised: " + e.getMessage());
		} finally {
			DBUtils.connectionClose(conn);
		}
	}

}
