/**
 * 
 */
package com.dop.business;

import com.dop.bean.Post;

/**
 * @author asus
 *
 */
public interface PostOperationInterface {
	public void showPost();
	public void addPost(Post post);
	public void deletePost(int userId, int postId);
}
