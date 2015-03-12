package com.gnoras.maple.web;

import com.gnoras.maple.core.impl.RequestContext;
import com.gnoras.maple.core.interfaces.ISessionRequestContext;
import com.gnoras.maple.core.interfaces.ISessionSubsystem;

public class WebRequestContext extends RequestContext implements ISessionRequestContext {
	
	public WebRequestContext() {
		sessionSubsystem = new SessionSubsystem();
	}

	private final ISessionSubsystem sessionSubsystem;

	@Override
	public ISessionSubsystem getSessionSubsystem() {
		return sessionSubsystem;
	}

}
