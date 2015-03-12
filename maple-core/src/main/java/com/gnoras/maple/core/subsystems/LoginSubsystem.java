package com.gnoras.maple.core.subsystems;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.CharEncoding;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Restrictions;
import org.jasypt.contrib.org.apache.commons.codec_1_3.binary.Base64;
import org.jasypt.digest.StandardByteDigester;
import org.jasypt.digest.StandardStringDigester;
import org.jasypt.digest.config.SimpleDigesterConfig;
import org.jasypt.salt.FixedByteArraySaltGenerator;
import org.jasypt.salt.RandomSaltGenerator;

import com.gnoras.maple.common.util.ByteConverter;
import com.gnoras.maple.common.util.Pair;
import com.gnoras.maple.core.errors.Errors;
import com.gnoras.maple.core.exceptions.EndUserErrorException;
import com.gnoras.maple.core.exceptions.ErrorIdException;
import com.gnoras.maple.core.exceptions.HackerAlertException;
import com.gnoras.maple.core.exceptions.InternalErrorException;
import com.gnoras.maple.core.exceptions.InvalidParameterException;
import com.gnoras.maple.core.interfaces.ILoginReservation;
import com.gnoras.maple.core.interfaces.ILoginSubsystem;
import com.gnoras.maple.core.interfaces.IQALoginSubsystem;
import com.gnoras.maple.core.interfaces.IRequestContext;
import com.gnoras.maple.core.interfaces.ISessionRequestContext;
import com.gnoras.maple.core.interfaces.ISessionSubsystem;
import com.gnoras.maple.core.validations.Validator;
import com.gnoras.maple.dal.model.EmailAddress;
import com.gnoras.maple.dal.model.EmailVerification;
import com.gnoras.maple.dal.model.User;
import com.gnoras.maple.dal.model.interfaces.IUser;
import com.gnoras.maple.dal.services.DataLayerMaple;
import com.gnoras.maple.dal.services.DataLayerMapleImpl;

public class LoginSubsystem implements ILoginSubsystem, IQALoginSubsystem {

	private final static int numBytesInSalt = 32;
	private final static int numIterationsPhase1 = 1000;
	private final static int numIterationsPhase2 = 10;
	private final static String hashingAlgo = "SHA-256"; // http://download.oracle.com/docs/cd/E17476_01/javase/1.5.0/docs/guide/security/CryptoSpec.html#AppA
	private final static long nMillisDelayAllowed = 10000; // 10 seconds

	private abstract class SessionKeys {
		public final static String LoggedInUserId = "LoginSubsystem.LoggedInUserId";
		public final static String LoggedInEmailAddr = "LoginSubsystem.LoggedInEmailAddr";
		public final static String LoginSeqNo = "LoginSubsystem.LoginSeqNo";
		public final static String ReservedSalt = "LoginSubsystem.LoginReservedSalt";
		public final static String ReservedEmailAddr = "LoginSubsystem.LoginReservedEmailAddr";
	}
	
	private void removeAllLoginSessionData(ISessionSubsystem ss) {
		List<String> names = new ArrayList<String>(5);
		names.add(SessionKeys.LoggedInEmailAddr);
		names.add(SessionKeys.LoggedInUserId);
		names.add(SessionKeys.LoginSeqNo);
		names.add(SessionKeys.ReservedEmailAddr);
		names.add(SessionKeys.ReservedSalt);
		ss.removeAttributes(names);
	}

	public class ReserveLoginResponse implements ILoginReservation {
		public ReserveLoginResponse(String salt, long seqNo) {
			_salt = salt;
			_seqNo = seqNo;
		}

		public String getSalt() {
			return _salt;
		}

		public long getSeqNo() {
			return _seqNo;
		}

		private final String _salt;
		private final long _seqNo;
	}

	private byte[] decodeBase64(String s) throws InternalErrorException {
		try {
			byte[] by = s.getBytes(CharEncoding.UTF_8);
			return Base64.decodeBase64(by);
		} catch (UnsupportedEncodingException e) {
			throw new InternalErrorException("Encoding " + CharEncoding.UTF_8 + " not available. ", e);
		}
	}

	private String encodeBase64(byte[] by) throws InternalErrorException {
		try {
			byte[] eby = Base64.encodeBase64(by);
			return new String(eby, CharEncoding.UTF_8);
		} catch (UnsupportedEncodingException e) {
			throw new InternalErrorException("Encoding " + CharEncoding.UTF_8 + " not available. ", e);
		}
	}

	@Override
	public boolean isLoggedIn(ISessionRequestContext rc) {
		Boolean bLoggedIn = false;
		ISessionSubsystem ss = rc.getSessionSubsystem();
		if (ss.exists()) {
			Object o = ss.getAttribute(SessionKeys.LoggedInUserId);
			bLoggedIn = (o != null && o instanceof String && !((String) o).isEmpty());
		}
		return bLoggedIn;
	}

	@Override
	public String getLoggedUserName(ISessionRequestContext rc) {
		String userName = null;
		ISessionSubsystem ss = rc.getSessionSubsystem();
		if (ss.exists()) {
			userName = (String) ss.getAttribute(SessionKeys.LoggedInEmailAddr);
		}
		return userName;
	}

	@Override
	public String getLoggedUserId(ISessionRequestContext rc) {
		String userId = null;
		ISessionSubsystem ss = rc.getSessionSubsystem();
		if (ss.exists()) {
			userId = (String) ss.getAttribute(SessionKeys.LoggedInUserId);
		}
		return userId;
	}

	@Override
	public void login(String emailAddr, long timeSentNMillis, String encodedCredentials, ISessionRequestContext rc)
			throws Exception {
		long currentNMillis = new Date().getTime();
		if (timeSentNMillis > currentNMillis || timeSentNMillis < currentNMillis - nMillisDelayAllowed) {
			throw new Exception("timestamp is old");
		}
		String strTime = String.valueOf(timeSentNMillis);
		byte[] byTime = strTime.getBytes(CharEncoding.UTF_8);

		// look up username in account system
		// retrieve the salt and digested password from the db for the user
		User u = getActivatedUser(emailAddr);
		if (u == null) {
			throw new Exception("Account does not exist");
		}

		Byte[] byDigestedSaltAndPassword = u.getPassword();
		Byte[] bySalt = u.getSalt();

		// form the message to try and compare against
		byte[] byMsg = ByteConverter.Join(byTime, byDigestedSaltAndPassword);

		// form salt generator
		FixedByteArraySaltGenerator sg = new FixedByteArraySaltGenerator();
		sg.setSalt(ArrayUtils.toPrimitive(bySalt));

		// form the digester
		SimpleDigesterConfig sdc = new SimpleDigesterConfig();
		sdc.setAlgorithm(hashingAlgo);
		sdc.setSaltGenerator(sg);
		sdc.setSaltSizeBytes(numBytesInSalt);
		sdc.setIterations(numIterationsPhase2);

		// produce the digest
		StandardByteDigester sd = new StandardByteDigester();
		sd.setConfig(sdc);
		byte[] byExpectedCredentials = sd.digest(byMsg);
		String strExpectedCredentials = encodeBase64(byExpectedCredentials);
		if (strExpectedCredentials.compareTo(encodedCredentials) == 0) {
			ISessionSubsystem ss = rc.getSessionSubsystem();
			// if (ss.exists()) {
			// ss.invalidate();
			// }
			ss.getOrForceCreate();
			List<Pair<String, Object>> attributes = new ArrayList<Pair<String, Object>>(2);
			attributes.add(new Pair<String, Object>(SessionKeys.LoggedInUserId, emailAddr));
			attributes.add(new Pair<String, Object>(SessionKeys.LoggedInEmailAddr, emailAddr));
			ss.setAttributes(attributes);
		} else {
			throw new Exception("Expected: \"" + strExpectedCredentials + "\" )");
		}
	}

	@Override
	public ILoginReservation reserveTemporarySaltForLogin(String emailAddr, ISessionRequestContext rc) throws Exception {

		// User u = getActivatedUser(emailAddr);
		// if (u != null) {
		// throw new Exception("Account already exists.");
		// }
		// u = getNotActivatedUser(emailAddr);
		// if (u != null) {
		// throw new Exception("Account already reserved.");
		// }

		// generate a salt for this email address / username
		RandomSaltGenerator rsg = new RandomSaltGenerator();
		byte[] bySalt = rsg.generateSalt(numBytesInSalt);

		// store the salt temporarily (life of session)
		List<Pair<String, Object>> attributes = new ArrayList<Pair<String, Object>>();
		Pair<String, Object> attrSalt = new Pair<String, Object>(SessionKeys.ReservedSalt, bySalt);
		Pair<String, Object> attrUserName = new Pair<String, Object>(SessionKeys.ReservedEmailAddr, emailAddr);
		attributes.add(attrSalt);
		attributes.add(attrUserName);

		ISessionSubsystem ss = rc.getSessionSubsystem();
		ss.getOrForceCreate();
		ss.setAttributes(attributes);

		long nMillis = updateLoginSeqNo(rc);
		String strSalt = encodeBase64(bySalt);
		return (ILoginReservation) new ReserveLoginResponse(strSalt, nMillis);
	}

	private User getActivatedUser(String emailAddr) {
		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(User.class);
		criteria.add(Restrictions.eq("deletedAt", 0L));
		criteria.createAlias("email", "ea");
		criteria.add(Restrictions.eq("ea.address", emailAddr));
		criteria.createAlias("ea.emailVerifications", "ev");
		criteria.add(Restrictions.eq("ev.processed", (byte) 1));
		criteria.setLockMode(LockMode.NONE);
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) criteria.list();

		if (users.size() == 0) {
			return null;
		}

		if (users.size() > 1) {
			// TODO log an error... shouldn't be > 1
			return null;
		}

		User u = users.get(0);
		if (u == null) {
			// TODO log an error... it shouldn't be null
			return null;
		}

		return u;
	}

	private User getNotActivatedUser(String emailAddr) {
		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(User.class);
		criteria.add(Restrictions.eq("deletedAt", 0L));
		criteria.createAlias("email", "ea");
		criteria.add(Restrictions.eq("ea.address", emailAddr));
		criteria.createAlias("ea.emailVerifications", "ev");
		criteria.add(Restrictions.eq("ev.processed", (byte) 0));

		criteria.setLockMode(LockMode.NONE);
		@SuppressWarnings("unchecked")
		List<User> users = criteria.list();
		if (users.size() == 0) {
			return null;
		}

		if (users.size() > 1) {
			// TODO log an error... shouldn't be > 1
			return null;
		}

		User u = users.get(0);
		if (u == null) {
			// TODO log an error... it shouldn't be null
			return null;
		}

		return u;
	}

	public boolean isEmailAddressInUse(String emailAddr, ISessionRequestContext rc) {
		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(User.class);
		criteria.add(Restrictions.eq("deletedAt", 0L));
		criteria.createAlias("email", "ea");
		criteria.add(Restrictions.eq("ea.address", emailAddr));

		criteria.setLockMode(LockMode.NONE);
		@SuppressWarnings("unchecked")
		List<User> users = criteria.list();
		return users.size() > 0;
	}

	@Override
	public void createLogin(String emailAddr, String encodedCredentials, ISessionRequestContext rc)
			throws EndUserErrorException, InternalErrorException, ErrorIdException {

		Validator.validateEmailAddressFormat(emailAddr);
		if ( Validator.isNullOrEmpty(encodedCredentials) ) {
			throw new ErrorIdException(Errors.parameterCannotBeNullOrEmpty, rc);
		}

		ISessionSubsystem ss = rc.getSessionSubsystem();
		String reservedEmailAddr = (String) ss.getAttribute(SessionKeys.ReservedEmailAddr);
		if (reservedEmailAddr == null) {
			throw new ErrorIdException(Errors.createLoginRequiresReservedSalt, rc);
		}
		if (!emailAddr.equals(reservedEmailAddr)) {
			throw new ErrorIdException(Errors.reservedEmailAddressDidNotMatch, rc);
		}
		byte bySalt[] = (byte[]) ss.getAttribute(SessionKeys.ReservedSalt);
		if (bySalt == null) {
			throw new InternalErrorException("Salt not reserved in session. ");
		}
		byte[] byEncodedCredentials = this.decodeBase64(encodedCredentials);

		String name = "";
		User u = new User();
		u.setCreatedAt(new Date().getTime());
		u.setDeletedAt(0L);
		u.setId(UUID.randomUUID().toString());
		u.setName(name);
		u.setPassword(ArrayUtils.toObject(byEncodedCredentials));
		u.setSalt(ArrayUtils.toObject(bySalt));
		EmailAddress email = new EmailAddress();
		email.setId(UUID.randomUUID().toString());
		email.setAddress(emailAddr);
		email.setUser(u);
		email.setState((byte)0);
		email.setSentAt(0L);

		@SuppressWarnings("unused")
		Serializable newID = DataLayerMapleImpl.getInstance().save(u);
		// TODO insert into the database the user and email address and email
		// address verification
		// TODO write process to monitor database for new emails to send

		ss.removeAttribute(SessionKeys.ReservedEmailAddr);
		ss.removeAttribute(SessionKeys.ReservedSalt);

	}

	@Override
	public ILoginReservation getSalt(String emailAddr, ISessionRequestContext rc) throws InternalErrorException, EndUserErrorException {
		User u = getActivatedUser(emailAddr);
		if (u == null) { 
			// throw an error for the end user to see the account is not activated in our system
			throw new EndUserErrorException(Errors.emailAddressNotActivatedOrNotRegistered);
		}
		byte[] bySalt = ArrayUtils.toPrimitive(u.getSalt());
		String strSalt = encodeBase64(bySalt);

		long nMillis = updateLoginSeqNo(rc);
		return (ILoginReservation) new ReserveLoginResponse(strSalt, nMillis);
	}

	private long updateLoginSeqNo(ISessionRequestContext rc) {
		long seqNo = new Date().getTime(); // UTC
		ISessionSubsystem ss = rc.getSessionSubsystem();
		ss.getOrForceCreate();
		ss.setAttribute(SessionKeys.LoginSeqNo, seqNo);
		return seqNo;
	}

	@Override
	public void logout(ISessionRequestContext rc) {
		// call into session and clear the user identity
		ISessionSubsystem ss = rc.getSessionSubsystem();
		if (ss.exists()) {
			ss.invalidate();
		}
	}

	@Override
	public void deleteLogin(ISessionRequestContext rc) throws EndUserErrorException {
		// call into session and clear the user identity
		ISessionSubsystem ss = rc.getSessionSubsystem();
		String userId = (String) ss.getAttribute(SessionKeys.LoggedInUserId);
		Validator.validateNotNullAndNotEmpty(userId, Errors.loginSessionDoesNotExist);
		
		DataLayerMaple dl = DataLayerMapleImpl.getInstance();
		User u = dl.loadUser(userId);
		long deletedAt = u.getDeletedAt();
		long now = new Date().getTime();
		if (deletedAt == 0) {
			u.setDeletedAt(now);
			dl.update(u);
		}
		else {
			// if the db update to deleteAt committed in a previous call to deleteLogin, but
			// still returned an exception, session will still be showing the userid.
			
			// TODO log the error/warning
		}
		
		// clear session
		removeAllLoginSessionData(ss);
		
	}

	@Override
	public String generateSalt(ISessionRequestContext rc) throws InternalErrorException {

		// TODO Add check to verify we are NOT in Production environment
		
		RandomSaltGenerator rsg = new RandomSaltGenerator();
		byte[] bySalt = rsg.generateSalt(numBytesInSalt);
		String strSalt = this.encodeBase64(bySalt);
		return strSalt;
	}

	@Override
	public String computePasswordDigest(String strSalt, String strPassword, ISessionRequestContext rc) throws InternalErrorException, InvalidParameterException {

		// TODO Add check to verify we are NOT in Production environment
		
		byte[] bySalt = decodeBase64(strSalt);
		if ( bySalt.length < numBytesInSalt ) {
			throw new InvalidParameterException("Salt length must be > " + numBytesInSalt + ". ");
		}
		
		if ( strPassword.length() == 0 ) {
			throw new InvalidParameterException("Password length must be > 0. ");
		}

		FixedByteArraySaltGenerator sg = new FixedByteArraySaltGenerator();
		sg.setSalt(bySalt);

		SimpleDigesterConfig sdc = new SimpleDigesterConfig();
		sdc.setAlgorithm(hashingAlgo);
		sdc.setSaltGenerator(sg);
		sdc.setSaltSizeBytes(numBytesInSalt);
		sdc.setIterations(numIterationsPhase1);

		StandardStringDigester sd = new StandardStringDigester();
		sd.setConfig(sdc);
		String strDigestPassword = sd.digest(strPassword);

		return strDigestPassword;
	}

	@Override
	public void changeLogin(String emailAddr, String encodedCredentials, ISessionRequestContext rc)
			throws EndUserErrorException, InternalErrorException, ErrorIdException {
		// TODO Auto-generated method stub
		
	}

}
