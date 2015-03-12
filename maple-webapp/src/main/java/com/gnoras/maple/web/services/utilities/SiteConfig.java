package com.gnoras.maple.web.services.utilities;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ListIterator;

import com.gnoras.maple.web.services.utilities.interfaces.ISiteConfig;

public class SiteConfig implements ISiteConfig {

	private IpRangeList _internalIpRanges;
	
	public IpRangeList getInternalIpRanges() {
		return _internalIpRanges;
	}

	public void setInternalIpRanges(IpRangeList list) {
		_internalIpRanges = list;
	}	
	
	@Override
	public boolean isInternal(String ip) throws UnknownHostException {
		InetAddress ia = InetAddress.getByName(ip);
		return isInternal(ia);
	}

	@Override
	public boolean isInternal(InetAddress ia) {
		ListIterator<IpRangeFilter> li = _internalIpRanges.getIpRanges().listIterator();
		while ( li.hasNext() ) {
			if ( li.next().isInRange(ia) ) {
				return true;
			}
		}
		return false;
	}

}
