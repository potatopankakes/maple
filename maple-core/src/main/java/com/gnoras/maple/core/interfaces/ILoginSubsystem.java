package com.gnoras.maple.core.interfaces;

import java.util.List;

import com.gnoras.maple.core.exceptions.EndUserErrorException;
import com.gnoras.maple.core.exceptions.ErrorIdException;
import com.gnoras.maple.core.exceptions.HackerAlertException;
import com.gnoras.maple.core.exceptions.InternalErrorException;
import com.gnoras.maple.core.exceptions.InvalidParameterException;
import com.gnoras.maple.dal.model.interfaces.IUser;

public interface ILoginSubsystem {

	public boolean isEmailAddressInUse(String emailAddr, ISessionRequestContext rc);
		
	public boolean isLoggedIn(ISessionRequestContext rc);

	public String getLoggedUserId(ISessionRequestContext rc);

	public String getLoggedUserName(ISessionRequestContext rc);

	public ILoginReservation reserveTemporarySaltForLogin(String emailAddr, ISessionRequestContext rc) throws Exception;

	public void createLogin(String emailAddr, String encodedCredentials, ISessionRequestContext rc) throws EndUserErrorException, InternalErrorException, ErrorIdException;

	public ILoginReservation getSalt(String emailAddr, ISessionRequestContext rc) throws Exception;

	public void login(String emailAddr, long timeSentNMillis, String encodedCredentials, ISessionRequestContext rc)
			throws Exception;

	public void logout(ISessionRequestContext rc);

	public void deleteLogin(ISessionRequestContext rc) throws EndUserErrorException;

	public void changeLogin(String emailAddr, String encodedCredentials, ISessionRequestContext rc) throws EndUserErrorException, InternalErrorException, ErrorIdException;
	
}
