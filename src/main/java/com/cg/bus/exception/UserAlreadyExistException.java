package com.cg.bus.exception;

public class UserAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1404511240841640324L;

	public UserAlreadyExistException(String message) {
		super(message);
	}
}
