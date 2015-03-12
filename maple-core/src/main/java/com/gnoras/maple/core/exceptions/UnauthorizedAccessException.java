package com.gnoras.maple.core.exceptions;

public class UnauthorizedAccessException extends Throwable {

	private static final long serialVersionUID = -656987922307188731L;

	public UnauthorizedAccessException() {
	}

	public UnauthorizedAccessException(String s) {
		super(s);
	}

	public UnauthorizedAccessException(String s, Throwable e) {
		super(s,e);
	}

	public UnauthorizedAccessException(Throwable e) {
		super(e);
	}

}
