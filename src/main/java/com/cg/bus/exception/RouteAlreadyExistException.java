package com.cg.bus.exception;

public class RouteAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6923624367749932974L;

	public RouteAlreadyExistException(String message) {
		super(message);
	}
}
