package com.gnoras.maple.web.services.aop.arounds;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gnoras.maple.core.errors.Errors;
import com.gnoras.maple.core.exceptions.EndUserErrorException;
import com.gnoras.maple.core.interfaces.IError;
import com.gnoras.maple.web.results.ErrorResponse;
import com.gnoras.maple.web.results.ExceptionResponse;
import com.gnoras.maple.web.services.utilities.interfaces.ISiteConfig;

import flexjson.JSONSerializer;

public class JsonWebServiceInterceptor implements MethodInterceptor {

	private ISiteConfig siteConfig;

	public void setSiteConfig(ISiteConfig sc) {
		siteConfig = sc;
	}

	public ISiteConfig getSiteConfig() {
		return siteConfig;
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object rval;
		try {
			rval = invocation.proceed();
		} catch (Throwable cause) {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request = attr.getRequest();
			String ip = request.getRemoteAddr();

			JSONSerializer resultSerializer = new JSONSerializer().exclude("*.class", "*.classType");
			IError errorCode;
			if ( cause instanceof EndUserErrorException ) {
				EndUserErrorException e = (EndUserErrorException)cause;
				errorCode = e.getError();
			}
			else {
				errorCode = Errors.unexpectedError;
			}
			UUID errorId = errorCode.getId();
			
			// TODO: Log the error
			System.out.println(this.getClass().getName() + ": exception invoking " + invocation.toString() + ". ErrorId: " + errorId.toString() + " Exception: " +  cause.getMessage());

			String s;
			if (!siteConfig.isInternal(ip)) {
				s = resultSerializer.serialize(new ErrorResponse(errorId));
			} else {
				s = resultSerializer.serialize(new ExceptionResponse(errorId, cause));
			}
			System.out.println(this.getClass().getName() + ": sent JSON response: " + s);
			rval = s;
		}
		return rval;
	}

}