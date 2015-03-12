package com.gnoras.maple.itest.interfaces;

import org.apache.http.client.HttpClient;

public interface IMapleWebTestContext extends IMapleTestContext {
	public HttpClient getHttpConnection();
	public void setHttpConnection(HttpClient hc);
}
