package com.gnoras.maple.web.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gnoras.maple.core.exceptions.EndUserErrorException;
import com.gnoras.maple.core.exceptions.HackerAlertException;
import com.gnoras.maple.core.exceptions.InternalErrorException;
import com.gnoras.maple.core.exceptions.InvalidParameterException;
import com.gnoras.maple.core.interfaces.ILoginReservation;
import com.gnoras.maple.core.interfaces.ILoginSubsystem;
import com.gnoras.maple.core.interfaces.IQALoginSubsystem;
import com.gnoras.maple.web.WebRequestContext;
import com.gnoras.maple.web.results.SuccessResponse;

import flexjson.JSONSerializer;

@Path("/LoginSvcV1")
public class LoginServiceImpl {

	private ILoginSubsystem ls;

	public void setLoginSubsystem(ILoginSubsystem value) {
		ls = value;
	}

	@GET
	@Produces("application/json")
	@Path("/available")
	public String checkLoginForExistance(@QueryParam("email") String emailAddr) {
		JSONSerializer resultSerializer = new JSONSerializer().exclude("*.class", "*.classType");
		boolean inUse = ls.isEmailAddressInUse(emailAddr, new WebRequestContext());
		return resultSerializer.serialize(new SuccessResponse(inUse));
	}

	@POST
	@Produces("application/json")
	@Path("/reserve")
	public String reserveLogin(@FormParam("email") String emailAddr) throws Exception {
		JSONSerializer resultSerializer = new JSONSerializer().exclude("*.class", "*.classType");
		ILoginReservation rsp = ls.reserveTemporarySaltForLogin(emailAddr, new WebRequestContext());
		return resultSerializer.serialize(new SuccessResponse(rsp));
	}

	@POST
	@Produces("application/json")
	@Path("/create")
	public String createLogin(@FormParam("email") String emailAddr, @FormParam("cred") String encodedCredentials)
			throws HackerAlertException, InvalidParameterException, EndUserErrorException, InternalErrorException {
		JSONSerializer resultSerializer = new JSONSerializer().exclude("*.class", "*.classType");
		ls.createLogin(emailAddr, encodedCredentials, new WebRequestContext());
		return resultSerializer.serialize(new SuccessResponse());
	}

	@GET
	@Produces("application/json")
	@Path("/salt")
	public String getSalt(@QueryParam("email") String emailAddr) throws Exception {
		JSONSerializer resultSerializer = new JSONSerializer().exclude("*.class", "*.classType");
		ILoginReservation rsp = ls.getSalt(emailAddr, new WebRequestContext());
		String s = resultSerializer.serialize(new SuccessResponse(rsp));
		System.out.println(s);
		return s;
	}

	@POST
	@Produces("application/json")
	@Path("/login")
	public String login(@FormParam("email") String emailAddr,
			@FormParam("seqNo") long timeSentNMillis,
			@FormParam("cred") String encodedCredentials) throws Exception {
		JSONSerializer resultSerializer = new JSONSerializer().exclude("*.class", "*.classType");
		ls.login(emailAddr, timeSentNMillis, encodedCredentials, new WebRequestContext());
		System.out.println( resultSerializer.serialize(new SuccessResponse()));
		return resultSerializer.serialize(new SuccessResponse());
	}

	@POST
	@Produces("application/json")
	@Path("/logout")
	public String logout() throws Exception {
		JSONSerializer resultSerializer = new JSONSerializer().exclude("*.class", "*.classType");
		ls.logout(new WebRequestContext());
		return resultSerializer.serialize(new SuccessResponse());
	}

	@GET
	@Produces("application/json")
	@Path("/computePasswordDigest")
	public String computePasswordDigest( @QueryParam("salt") String strSalt, @QueryParam("password") String strPassword) throws InternalErrorException, InvalidParameterException {
		if ( !(ls instanceof IQALoginSubsystem) ) {
			throw new InternalErrorException("LoginSubsystem does not support IQALoginSubsystem. ");
		}
		IQALoginSubsystem qaLs = (IQALoginSubsystem)ls;
		String strPasswordDigest = qaLs.computePasswordDigest(strSalt, strPassword, new WebRequestContext());
		JSONSerializer resultSerializer = new JSONSerializer().exclude("*.class", "*.classType");
		return resultSerializer.serialize(new SuccessResponse(strPasswordDigest));
	}

	@GET
	@Produces("application/json")
	@Path("/generateSalt")
	public String generateSalt() throws InternalErrorException {
		if ( !(ls instanceof IQALoginSubsystem) ) {
			throw new InternalErrorException("LoginSubsystem does not support IQALoginSubsystem. ");
		}
		IQALoginSubsystem qaLs = (IQALoginSubsystem)ls;
		String strSalt = qaLs.generateSalt(new WebRequestContext());
		JSONSerializer resultSerializer = new JSONSerializer().exclude("*.class", "*.classType");
		return resultSerializer.serialize(new SuccessResponse(strSalt));
	}

}
