package com.gnoras.maple.core.exceptions;

public class ItemNotFoundException extends Throwable {

	private static final long serialVersionUID = 3143675927227167062L;

	public ItemNotFoundException() {
	}

	public ItemNotFoundException(String message) {
		super(message);
	}

	public ItemNotFoundException(Throwable cause) {
		super(cause);
	}

	public ItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
