package com.machine.entity;

public class CoinNotAllowedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CoinNotAllowedException() {
		super();
	}

	public CoinNotAllowedException(String message) {
		super(message+" is not a valid coin");
	}
}
