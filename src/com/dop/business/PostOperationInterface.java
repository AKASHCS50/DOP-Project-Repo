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
	public void addPost(Post post);
	public void deletePost(int postId);
}
