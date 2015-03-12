package com.gnoras.maple.core.errors;

import java.util.UUID;

import com.gnoras.maple.core.interfaces.IError;

public class Error implements IError {
	private final UUID uuid;
	private final String systemMessage;

	public Error(long msbitsUuid, long lsbitsUuid, String systemMessage) {
		this.uuid = new UUID(msbitsUuid, lsbitsUuid);
		this.systemMessage = systemMessage;
	}

	public Error(UUID uuid, String systemMessage) {
		this.uuid = uuid;
		this.systemMessage = systemMessage;
	}

	@Override
	public String getSystemMessage() {
		return systemMessage;
	}

	@Override
	public UUID getId() {
		return uuid;
	}
}
