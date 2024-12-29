package com.cg.bus.exception;

public class FeedbackAlreadyExist extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FeedbackAlreadyExist(String message) {
		super(message);
	}
}
