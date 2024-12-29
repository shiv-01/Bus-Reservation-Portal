package com.cg.bus.exception;

public class ReservationAlreadyExist extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReservationAlreadyExist(String message) {
		super(message);
	}
}
