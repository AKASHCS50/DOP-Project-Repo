/**
 * 
 */
package com.dop.bean;

/**
 * @author asus
 *
 */

public class Post {
	private int postId;
	private int author;
	private String title;
	private String content;
	
	
	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	
	/**
	 * @return the author
	 */
	public int getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(int author) {
		this.author = author;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
