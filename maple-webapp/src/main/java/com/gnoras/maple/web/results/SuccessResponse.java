package com.gnoras.maple.web.results;

import com.gnoras.maple.web.results.interfaces.IResponse;

public class SuccessResponse implements IResponse {
	
	public SuccessResponse(Object response) {
		_response = response;
	}
	
	public SuccessResponse() {
	}

	public boolean getSuccess()
	{
		return true;
	}
	
	private Object _response;
	
	public Object getResult()
	{
		return _response;
	}

	public void setResponse(Object o)
	{
		_response = o;
	}

}
