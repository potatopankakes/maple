package com.gnoras.maple.itest.impl;

import java.util.HashMap;

import com.gnoras.maple.itest.interfaces.IMapleTestContext;

public class MapleTestContext implements IMapleTestContext {

	private HashMap<String, Object> values = new HashMap<String, Object>();
	
	@Override
	public Object getValue(String name) {
		return values.get(name);
	}
	@Override
	public void setValue(String name, Object value) {
		values.put(name, value);
		
	}
}
