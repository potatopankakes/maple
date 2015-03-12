package com.gnoras.maple.itest.interfaces;


public interface IMapleTestContextConfiguration<T extends IMapleTestContext> {
	public T getTestContext();
	public void setTestContext(T tc);
}
