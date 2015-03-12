package com.gnoras.maple.itest.impl;

import java.lang.reflect.Constructor;

import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.IObjectFactory;

import com.gnoras.maple.itest.interfaces.IMapleWebTestContextConfiguration;
import com.gnoras.maple.itest.interfaces.IMapleWebTestContext;

@Deprecated
public class MapleWebTestNGFactory implements IObjectFactory {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5286940512952585964L;

	public MapleWebTestNGFactory() {
		testContext = new MapleWebTestContext();
		testContext.setHttpConnection(new DefaultHttpClient());
	}
	
	private IMapleWebTestContext testContext;
	
	public Object newInstance(@SuppressWarnings("rawtypes") Constructor constructor, Object... params) {
		Object o;
		try {
			o = constructor.newInstance(params);
			if ( o instanceof IMapleWebTestContextConfiguration ) {
				IMapleWebTestContextConfiguration tcnf = (IMapleWebTestContextConfiguration)o;
				tcnf.setTestContext(testContext);
			}
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return o;
	}
}
