package com.gnoras.maple.core.exceptions;

public class InvalidParameterException extends Exception {

	private static final long serialVersionUID = -3171352328502283995L;

	public InvalidParameterException() {
	}

	public InvalidParameterException(String message) {
		super(message);
	}

	public InvalidParameterException(Throwable cause) {
		super(cause);
	}

	public InvalidParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}
