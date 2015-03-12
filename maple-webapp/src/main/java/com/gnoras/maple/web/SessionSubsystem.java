package com.gnoras.maple.web;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.gnoras.maple.common.util.Pair;
import com.gnoras.maple.core.interfaces.ISessionSubsystem;

public class SessionSubsystem implements ISessionSubsystem {

	public SessionSubsystem() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		httpServletRequest = attr.getRequest();
	}

	private HttpServletRequest httpServletRequest;
	private HttpSession httpSession;

	@Override
	public Boolean exists() {
		get();
		// TODO See if getId returns null after .invalidate() is called
		return httpSession != null && httpSession.getId() != null;
	}

	@Override
	public void get() {
		if (httpSession == null) {
			httpSession = httpServletRequest.getSession(false);
		}
	}

	@Override
	public void getOrForceCreate() {
		// overwrite... don't check, in case the currently stored session was invalidated
		httpSession = httpServletRequest.getSession(true);
	}

	@Override
	public void invalidate() {
		httpSession.invalidate();
		httpSession = null;
	}

	@Override
	public String getId() {
		return httpSession.getId();
	}

	@Override
	public long getCreationTime() {
		return httpSession.getCreationTime();
	}

	@Override
	public long getLastAccessedTime() {
		return httpSession.getLastAccessedTime();
	}

	@Override
	public void setMaxInactiveInterval(int interval) {
		httpSession.setMaxInactiveInterval(interval);
	}

	@Override
	public int getMaxInactiveInterval() {
		return httpSession.getMaxInactiveInterval();
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		@SuppressWarnings("unchecked")
		Enumeration<String> en = httpSession.getAttributeNames();
		return en;
	}

	@Override
	public Object getAttribute(String name) {
		return httpSession.getAttribute(name);
	}

	@Override
	public List<Object> getAttributes(List<String> names) {
		List<Object> list = new ArrayList<Object>(names.size());
		for (String name : names) {
			Object value = httpSession.getAttribute(name);
			list.add(value);
		}
		return list;
	}

	@Override
	public List<Pair<String, Object>> getAttributesExt(List<String> names) {
		List<Pair<String, Object>> list = new ArrayList<Pair<String, Object>>(
				names.size());
		for (String name : names) {
			Object value = httpSession.getAttribute(name);
			list.add(new Pair<String, Object>(name, value));
		}
		return list;
	}

	@Override
	public void setAttribute(String name, Object value) {
		httpSession.setAttribute(name, value);
	}

	@Override
	public void setAttributes(List<Pair<String, Object>> attributes) {
		for (Pair<String, Object> attr : attributes) {
			httpSession.setAttribute(attr.getFirst(), attr.getSecond());
		}
	}

	@Override
	public void setAttributes(Map<String, Object> attributes) {
		for (Map.Entry<String, Object> attr : attributes.entrySet()) {
			httpSession.setAttribute(attr.getKey(), attr.getValue());
		}
	}

	@Override
	public void removeAttribute(String name) {
		httpSession.removeAttribute(name);
	}

	@Override
	public void removeAttributes(List<String> names) {
		for (String name : names) {
			httpSession.removeAttribute(name);
		}
	}

}
