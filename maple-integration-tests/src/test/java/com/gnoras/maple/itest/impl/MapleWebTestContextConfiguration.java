package com.gnoras.maple.itest.impl;

import com.gnoras.maple.itest.interfaces.IMapleWebTestContextConfiguration;
import com.gnoras.maple.itest.interfaces.IMapleWebTestContext;

public class MapleWebTestContextConfiguration implements IMapleWebTestContextConfiguration {
	
	private IMapleWebTestContext testContext;

	@Override
	public void setTestContext(IMapleWebTestContext tc) {
		testContext = tc;
	}

	@Override
	public IMapleWebTestContext getTestContext() {
		return testContext;
	}

}
