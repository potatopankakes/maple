package com.gnoras.maple.itest.impl;

import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.gnoras.maple.itest.interfaces.IMapleWebTestContextConfiguration;

public class MapleWebTestNGListener implements IInvokedMethodListener2 {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

		// See if the class that holds the test method supports the test
		// configuration interface
		Object o = method.getTestMethod().getInstance();
		if (o instanceof IMapleWebTestContextConfiguration) {
			// since the test class wants a configuration object, see if this
			// instance has already has one stored
			MapleTestContextTestNG tcAdapter = new MapleTestContextTestNG(context);
			MapleWebTestContext testContext = new MapleWebTestContext(tcAdapter);
			if ( !MapleWebTestContext.isInitialized(testContext) ) {
				// none there, so initialize the instanc's ITestContext with one
				testContext.setHttpConnection(new DefaultHttpClient());
				testContext.markInitialized();
			}

			IMapleWebTestContextConfiguration tcnf = (IMapleWebTestContextConfiguration) o;
			tcnf.setTestContext(testContext);
		}
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
		
	}

}
