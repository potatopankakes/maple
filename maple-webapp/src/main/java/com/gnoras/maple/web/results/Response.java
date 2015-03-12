package com.gnoras.maple.web.results;

import com.gnoras.maple.web.results.interfaces.IResponse;

public class Response implements IResponse {

	public Response(boolean success, Object result) {
		_success = success;
		_result = result;
	}
	
	private boolean _success;
	
	public boolean getSuccess() {
		return _success;
	}
	
	public void setSuccess(boolean success) {
		_success = success;
	}

	private Object _result;
	
	public Object getResult() {
		return _result;
	}

	public void setResult(Object o) {
		_result = o;
	}

}
