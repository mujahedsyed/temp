package com.machine.states;

public class InvalidUserActionException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidUserActionException() {
		super();
	}

	public InvalidUserActionException(String message) {
		super(message);
	}
}
