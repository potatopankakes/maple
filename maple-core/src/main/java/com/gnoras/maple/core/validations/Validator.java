package com.gnoras.maple.core.validations;

import org.apache.commons.validator.EmailValidator;

import com.gnoras.maple.core.errors.Errors;
import com.gnoras.maple.core.exceptions.EndUserErrorException;
import com.gnoras.maple.core.exceptions.InvalidParameterException;
import com.gnoras.maple.core.interfaces.IError;

public class Validator {

	public static boolean isNullOrEmpty(String paramValue) {
		return (paramValue == null || paramValue.isEmpty()); 
	}

	public static void validateNotNullAndNotEmpty(String paramValue, IError e) throws EndUserErrorException {
		if ( isNullOrEmpty(paramValue) ) {
			throw new EndUserErrorException(e);
		}
	}

	public static void validateNotNullAndNotEmpty(String paramName, String paramValue) throws InvalidParameterException {
		if ( isNullOrEmpty(paramValue) ) {
			throw new InvalidParameterException("Parameter " + paramValue + " cannot be null or empty. ");
		}
	}

	public static void validateNotNull(String paramName, Object paramValue) throws InvalidParameterException {
		if (paramValue == null) {
			throw new InvalidParameterException("Parameter " + paramValue + " cannot be null. ");
		}
	}

	public static void validateEmailAddressFormat(String paramValue) throws EndUserErrorException {
		if (paramValue == null || EmailValidator.getInstance().isValid(paramValue)) {
			throw new EndUserErrorException(Errors.emailAddressInvalidFormat);
		}
	}

}
