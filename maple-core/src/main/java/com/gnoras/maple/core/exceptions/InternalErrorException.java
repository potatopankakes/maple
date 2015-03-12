package com.gnoras.maple.core.exceptions;

public class InternalErrorException extends Exception {

	private static final long serialVersionUID = -8402171241156900657L;

	public InternalErrorException() {
	}

	public InternalErrorException(String message) {
		super(message);
	}

	public InternalErrorException(Throwable cause) {
		super(cause);
	}

	public InternalErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
