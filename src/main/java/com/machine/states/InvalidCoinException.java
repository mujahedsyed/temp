package com.machine.states;

public class InvalidCoinException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCoinException() {
		super();
	}

	public InvalidCoinException(String message) {
		super(message);
	}

}
