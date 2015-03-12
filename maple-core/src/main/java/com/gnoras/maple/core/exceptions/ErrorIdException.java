package com.gnoras.maple.core.exceptions;

import com.gnoras.maple.core.interfaces.IError;
import com.gnoras.maple.core.interfaces.ISessionRequestContext;

public class ErrorIdException extends Exception {
	
	private static final long serialVersionUID = -7662622674138209642L;
	
	private final IError error;
	
	public IError getError() {
		return error;
	}
	
	private final ISessionRequestContext requestContext;
	
	public ISessionRequestContext getRequestContext() {
		return requestContext;
	}
	
	public ErrorIdException(final IError e, ISessionRequestContext rc) {
		super(e.getSystemMessage());
		error = e;
		requestContext = rc;
	}

	public ErrorIdException(final IError e, ISessionRequestContext rc, Throwable cause) {
		super(e.getSystemMessage(), cause);
		error = e;
		requestContext = rc;
	}
}
