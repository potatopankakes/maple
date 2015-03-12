package com.gnoras.maple.core.interfaces;

import java.util.List;
import com.gnoras.maple.dal.model.interfaces.IEmailAddress;

public interface ILoginActivationSubsystem {
	public List<IEmailAddress> getEmailAddressesRequiringConfirmation(long maxNumberOf, IRequestContext rc);
	public void markConfirmationEmailSent(String emailId, long dtSentAt, IRequestContext rc);
//	public void markConfirmationEmailSent2(Pair<String,long> listSent, IRequestContext rc);
}
