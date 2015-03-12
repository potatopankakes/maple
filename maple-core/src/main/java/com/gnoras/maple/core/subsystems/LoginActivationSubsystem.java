package com.gnoras.maple.core.subsystems;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.annotations.Index;
import org.hibernate.criterion.Restrictions;
import org.jasypt.digest.StandardByteDigester;
import org.jasypt.digest.config.SimpleDigesterConfig;
import org.jasypt.salt.FixedByteArraySaltGenerator;
import org.jasypt.salt.RandomSaltGenerator;

import com.gnoras.maple.common.util.ByteConverter;
import com.gnoras.maple.core.interfaces.ILoginActivationSubsystem;
import com.gnoras.maple.core.interfaces.IQALoginActivationSubsystem;
import com.gnoras.maple.core.interfaces.IRequestContext;
import com.gnoras.maple.dal.model.EmailAddress;
import com.gnoras.maple.dal.model.User;
import com.gnoras.maple.dal.model.interfaces.IEmailAddress;
import com.gnoras.maple.dal.model.interfaces.IUser;
import com.gnoras.maple.dal.services.DataLayerMaple;
import com.gnoras.maple.dal.services.DataLayerMapleImpl;

public class LoginActivationSubsystem implements ILoginActivationSubsystem, IQALoginActivationSubsystem {

	@Override
	public List<IEmailAddress> getEmailAddressesRequiringConfirmation(long maxNumberOf, IRequestContext rc) {
		List<IEmailAddress> iEmailAddresses = new ArrayList<IEmailAddress>();
		if ( maxNumberOf > 0 ) {
			Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(EmailAddress.class);
			criteria.add(Restrictions.eq("sentAt", 0L));
			criteria.add(Restrictions.eq("state", (byte) 0));
			criteria.createAlias("user", "u");
			criteria.add(Restrictions.eq("u.deletedAt", 0L));
			criteria.setLockMode(LockMode.NONE);
			criteria.setFetchSize((int)maxNumberOf);
			@SuppressWarnings("unchecked")
			List<EmailAddress> emailAddresses = (List<EmailAddress>) criteria.list();
			Iterator<EmailAddress> iterator = emailAddresses.iterator();
			while ( iterator.hasNext() && maxNumberOf-- > 0 ) {
				iEmailAddresses.add(iterator.next());
			}
		}
		return iEmailAddresses;
	}
	
	private int numBytesInSalt = 32;
	private final static String hashingAlgo = "SHA-256";
	private final static int numIterations = 10;

	@Override
	public void markConfirmationEmailSent(String emailId, long dtSentAt, IRequestContext rc) {
		DataLayerMaple dl = DataLayerMapleImpl.getInstance();
		EmailAddress e = dl.loadEmailAddress(emailId);
		User u = e.getUser();
		
		Byte bySalt[] = u.getSalt();
		FixedByteArraySaltGenerator sg = new FixedByteArraySaltGenerator();
		sg.setSalt(ArrayUtils.toPrimitive(bySalt));
		
		SimpleDigesterConfig sdc = new SimpleDigesterConfig();
		sdc.setAlgorithm(hashingAlgo);
		sdc.setSaltGenerator(sg);
		sdc.setSaltSizeBytes(numBytesInSalt);
		sdc.setIterations(numIterations);

		StandardByteDigester sd = new StandardByteDigester();
		sd.setConfig(sdc);
		
		// I suppose it is questionable whether I need to hash a number that is already random
		RandomSaltGenerator rsg = new RandomSaltGenerator();
		byte[] byRandomNumber = rsg.generateSalt(numBytesInSalt);
		byte[] byResponseCode = sd.digest(byRandomNumber);

		e.setSentAt(new Date().getTime());
		e.setResponseCode(ArrayUtils.toObject(byResponseCode));
		dl.update(e);
	}

	@Override
	public String generateEmailAuthenticationUrl(String emailAddress, long dtSentAt, IRequestContext rc) {
		Criteria criteria = DataLayerMapleImpl.getInstance().createCriteria(EmailAddress.class);
		//criteria.add(Restrictions.eq("sentAt", 0L));
		//criteria.add(Restrictions.eq("state", (byte) 0));
		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.deletedAt", 0L));
		criteria.setLockMode(LockMode.NONE);
		@SuppressWarnings("unchecked")
		List<EmailAddress> emailAddresses = (List<EmailAddress>) criteria.list();
		
		work up a state diagram/workflow for whether duplicate email addresses are allowed
		  the database has a unique Index... but will this work?  i think a unique index
		  is not needed.
		
		
		Iterator<EmailAddress> iterator = emailAddresses.iterator();
		return null;
	}

}