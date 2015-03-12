package com.gnoras.maple.itest.impl;

import org.apache.http.client.HttpClient;

import com.gnoras.maple.itest.interfaces.IMapleTestContext;
import com.gnoras.maple.itest.interfaces.IMapleWebTestContext;

public class MapleWebTestContext implements
		IMapleWebTestContext {
	
	private IMapleTestContext testContext;
	
	public MapleWebTestContext() {
	}
	public MapleWebTestContext(IMapleTestContext tc) {
		testContext = tc;
	}
	
	public void setMapleTestContext(IMapleTestContext tc) {
		testContext = tc;
	}
	
	public static boolean isInitialized(IMapleTestContext tc) {
		Object o = tc.getValue(keyContextInitialized);
		return o != null;
	}

	public void markInitialized() {
		setValue(keyContextInitialized, true);
	}

	private final static String keyBase = "MapleWebTestContext.";
	
	private final static String keyContextInitialized = keyBase + "Initialized";
	private final static String keyHttpConn = keyBase + "HttpConnection";
	
	@Override
	public HttpClient getHttpConnection() {
		return (HttpClient)testContext.getValue(keyHttpConn);
	}

	@Override
	public void setHttpConnection(HttpClient o) {
		testContext.setValue(keyHttpConn, o);
	}

	@Override
	public Object getValue(String name) {
		return testContext.getValue(name);
	}

	@Override
	public void setValue(String name, Object value) {
		testContext.setValue(name, value);
	}

}
