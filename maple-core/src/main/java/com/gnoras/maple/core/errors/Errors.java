package com.gnoras.maple.core.errors;

import com.gnoras.maple.core.interfaces.IError;


public class Errors {
	public static final IError unexpectedError = new Error(0x58F2EE9EFC2F11E0L, 0xBC2EEE014924019BL,
			"Unexpected Error");
	public static final IError emailAddressInvalidFormat = new Error(0x5F9C3FB0F7BC11E0L, 0x863F51314924019BL,
			"Invalid format for email address.");
	public static final IError emailAddressNotActivatedOrNotRegistered = new Error(0x381B90E8F87B11E0L,
			0xAA0390AF4824019BL, "Email address is not active or not registered.");
	public static final IError loginSessionDoesNotExist = new Error(0x83B58948005D11E1L, 0xB72B515F4824019BL,
			"You are not logged in, please login.");
	
// generate new uuids
	public static final IError createLoginRequiresReservedSalt = new Error(0x83B58948005D11E1L, 0xB72B515F4824019BL,
			"Reserve a salt before creating the login. ");
	public static final IError parameterCannotBeNullOrEmpty = new Error(0x83B58948005D11E1L, 0xB72B515F4824019BL,
			"Parameter cannot be null or empty. ");
	public static final IError reservedEmailAddressDidNotMatch = new Error(0x83B58948005D11E1L, 0xB72B515F4824019BL,
			"Email address of reserved salt did not match supplied email address. ");
//	public static final Error hackerAlertSaltNotReserved = new Error(0x381B90E8F87B11E0L,
//			0xAA0390AF4824019BL, "Protocol violation, reserve salt prior to creating login.");
//	public static final Error hackerAlertUnauthorizedAccess = new Error(0x381B90E8F87B11E0L,
//			0xAA0390AF4824019BL, "Unauthorized access.");
} 