package com.tienda.online.exceptions;

public class UserDataNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserDataNotFoundException() {}

	public UserDataNotFoundException(String message) {
		super(message);
	}
	
}
