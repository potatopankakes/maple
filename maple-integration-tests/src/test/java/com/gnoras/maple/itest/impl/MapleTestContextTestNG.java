package com.gnoras.maple.itest.impl;

import org.testng.ITestContext;

import com.gnoras.maple.itest.interfaces.IMapleTestContext;

public class MapleTestContextTestNG implements IMapleTestContext {

	private ITestContext testContext;
		
	public MapleTestContextTestNG(ITestContext tc) {
		testContext = tc;
	}
	
	@Override
	public Object getValue(String name) {
		return testContext.getAttribute(name);
	}
	@Override
	public void setValue(String name, Object value) {
		testContext.setAttribute(name, value);
		
	}
}
