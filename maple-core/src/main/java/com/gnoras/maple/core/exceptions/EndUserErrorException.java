package com.gnoras.maple.core.exceptions;

import com.gnoras.maple.core.interfaces.IError;

public class EndUserErrorException extends Exception {
	
	private static final long serialVersionUID = -8450809111489013366L;

	private final IError error;
	
	public IError getError() {
		return error;
	}
	
	public EndUserErrorException(IError error) {
		super(error.getSystemMessage());
		this.error = error;
	}

	public EndUserErrorException(IError error, Throwable cause) {
		super(error.getSystemMessage(), cause);
		this.error = error;
	}
}
