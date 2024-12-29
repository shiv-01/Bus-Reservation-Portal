package com.cg.bus.exception;

public class ReservationNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9033536071499773893L;

	public ReservationNotFoundException(String message) {
		super(message);
	}
}
