/**
 * 
 */
package com.dop.exceptions;

/**
 * @author asus
 *
 */
public class ErrorInUpdatingPasswordException extends Exception {
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Error in Updating Password";
	}
}
