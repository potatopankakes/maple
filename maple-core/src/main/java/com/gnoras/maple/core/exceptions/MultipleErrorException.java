package com.gnoras.maple.core.exceptions;

import java.util.List;

import com.gnoras.maple.core.errors.Error;

public class MultipleErrorException extends Exception {

	private static final long serialVersionUID = 6226418480134586716L;

	private final List<Error> errorCodes;

	public List<Error> getErrorCodes() {
		return errorCodes;
	}

	private static String errorCodeListToString(List<Error> errorCodes) {
		int len = 0;
		for (Error errorCode : errorCodes) {
			len += errorCode.getSystemMessage().length() + 2;
		}
		StringBuilder sb = new StringBuilder(len);
		for (Error errorCode : errorCodes) {
			sb.append(errorCode.getSystemMessage()).append("\r\n");
		}
		sb.setLength(len - 2);
		return sb.toString();
	}

	public MultipleErrorException(final List<Error> listErrorCodes) {
		super(errorCodeListToString(listErrorCodes));
		errorCodes = listErrorCodes;
	}

	public MultipleErrorException(final List<Error> listErrorCodes, Throwable cause) {
		super(errorCodeListToString(listErrorCodes), cause);
		errorCodes = listErrorCodes;
	}
}
