package com.tienda.online.exceptions;

// checked Exception, 
public class UserNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException() {
		super("No user found with provided data");
	}
}
