package com.gnoras.maple.web.results;

import java.util.UUID;

import com.gnoras.maple.web.results.interfaces.IResponse;

public class ErrorResponse implements IResponse {

	public ErrorResponse(UUID errorId) {
		_errorId = errorId;
	}

	private UUID _errorId;

	public boolean getSuccess() {
		return false;
	}
	
	public class ErrorInfo {
		public String errorId;
	}

	public Object getResult() {
		ErrorInfo ei = new ErrorInfo();
		ei.errorId = _errorId.toString();
		return ei;
	}
}
