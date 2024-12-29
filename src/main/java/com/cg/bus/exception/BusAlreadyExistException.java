package com.cg.bus.exception;

public class BusAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusAlreadyExistException(String message) {
		super(message);
	}
}
