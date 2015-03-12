package com.gnoras.maple.core.interfaces;

public interface IQALoginActivationSubsystem {
	public String generateEmailAuthenticationUrl(String emailAddress, long dtSentAt, IRequestContext rc);
}
