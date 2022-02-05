/**
 * 
 */
package com.dop.business;

import com.dop.bean.Post;
import com.dop.dao.PostDaoOperation;
import com.dop.dao.PostDaoOperationInterface;

/**
 * @author asus
 *
 */
public class PostOperation implements PostOperationInterface {

	PostDaoOperationInterface postDaoOperation = new PostDaoOperation();

	public void showPost() {
		// TODO Auto-generated method stub
		postDaoOperation.showPost();
	}

	public void addPost(Post post) {
		// TODO Auto-generated method stub
		postDaoOperation.addPost(post);
	}

	public void deletePost(int userId, int postId) {
		// TODO Auto-generated method stub
		postDaoOperation.deletePost(userId, postId);
	}

}
