/**
 * 
 */
package com.dop.dao;

import com.dop.bean.Post;

/**
 * @author asus
 *
 */
public interface PostDaoOperationInterface {
	public void addPost(Post post);
	public void deletePost(int postId);
}
