package com.gnoras.maple.core.interfaces;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import com.gnoras.maple.common.util.Pair;

public interface ISessionSubsystem {

	public String getId();

	public long getCreationTime();

	public long getLastAccessedTime();

	public void setMaxInactiveInterval(int interval);

	public int getMaxInactiveInterval();

	public Enumeration<String> getAttributeNames();

	public Object getAttribute(String name);

	public List<Object> getAttributes(List<String> names);

	List<Pair<String, Object>> getAttributesExt(List<String> names);

	public void setAttribute(String name, Object value);

	public void setAttributes(List<Pair<String, Object>> attributes);

	public void setAttributes(Map<String, Object> attributes);

	public void removeAttribute(String name);

	public void removeAttributes(List<String> names);

	public void getOrForceCreate();

	public Boolean exists();

	public void get();

	public void invalidate();

}
