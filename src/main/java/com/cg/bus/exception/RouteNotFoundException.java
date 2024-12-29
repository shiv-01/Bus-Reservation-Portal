package com.cg.bus.exception;

public class RouteNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4951299708403623304L;

	public RouteNotFoundException(String message) {
		super(message);
	}

}