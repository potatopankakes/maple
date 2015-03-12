package com.gnoras.maple.core.interfaces;

import com.gnoras.maple.core.exceptions.InternalErrorException;
import com.gnoras.maple.core.exceptions.InvalidParameterException;

public interface IQALoginSubsystem {

	public String generateSalt(ISessionRequestContext rc) throws InternalErrorException;

	public String computePasswordDigest(String strSalt, String strPassword, ISessionRequestContext rc)
			throws InternalErrorException, InvalidParameterException;

}
