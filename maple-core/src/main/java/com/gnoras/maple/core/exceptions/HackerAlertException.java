package com.gnoras.maple.core.exceptions;

public class HackerAlertException extends Exception {

	private static final long serialVersionUID = 4436023656634866869L;

	public HackerAlertException() {
	}

	public HackerAlertException(String message) {
		super(message);
	}

	public HackerAlertException(Throwable cause) {
		super(cause);
	}

	public HackerAlertException(String message, Throwable cause) {
		super(message, cause);
	}

}
