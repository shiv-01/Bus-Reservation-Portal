package com.cg.bus.exception;

public class UserNotFoundException extends  RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6066321572946071414L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
