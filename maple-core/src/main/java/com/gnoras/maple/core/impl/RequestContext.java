package com.gnoras.maple.core.impl;

import java.util.UUID;

import com.gnoras.maple.core.interfaces.IRequestContext;

public class RequestContext implements IRequestContext {

	public RequestContext() {
		id = UUID.randomUUID();
	}

	private final UUID id;
	
	@Override
	public UUID getRequestId() {
		return id;
	}

}
