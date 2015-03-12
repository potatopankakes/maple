package com.gnoras.maple.web.services.utilities.interfaces;

import java.net.InetAddress;
import java.net.UnknownHostException;

public interface ISiteConfig {

	public boolean isInternal(String ip) throws UnknownHostException;

	public boolean isInternal(InetAddress ia);

}