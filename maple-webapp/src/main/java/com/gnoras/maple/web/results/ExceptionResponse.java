package com.gnoras.maple.web.results;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.lang.Throwable;

import com.gnoras.maple.web.results.interfaces.IResponse;

public class ExceptionResponse implements IResponse {

	public ExceptionResponse(UUID eid, Throwable c) {
		errorId = eid;
		cause = c;
	}

	private UUID errorId;

	private Throwable cause;

	public boolean getSuccess() {
		return false;
	}

	private ExceptionErrorInfo generateErrorInfo(UUID eid, Throwable c) {
		ExceptionErrorInfo errorInfo = new ExceptionErrorInfo();
		errorInfo.errorId = eid.toString();
		errorInfo.exception = generateExceptionInfo(c);
		return errorInfo;
	}

	private ExceptionInfo generateExceptionInfo(Throwable ex) {
		ExceptionInfo ei = new ExceptionInfo();
		ei.message = ex.getMessage();
		ei.stackTrace = getStackTrace(ex);
		if (ex.getCause() != null) {
			ei.cause = generateExceptionInfo(ex.getCause());
		}
		return ei;
	}

	private List<String> getStackTrace(Throwable ex) {
		StackTraceElement st[] = ex.getStackTrace();
		List<String> ls = new ArrayList<String>(st.length);
		for (int i = 0; i < st.length; i++) {
			ls.add(st[i].toString());
		}
		return ls;
	}

	public Object getResult() {
		return generateErrorInfo(errorId, cause);
	}
}
