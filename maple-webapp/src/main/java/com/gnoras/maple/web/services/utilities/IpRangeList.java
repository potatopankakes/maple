package com.gnoras.maple.web.services.utilities;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IpRangeList {
	private List<IpRangeFilter> _listInternalIpRange = new ArrayList<IpRangeFilter>();
	
	public List<String> getIpRangesInStringFormat() {
		ListIterator<IpRangeFilter> li = _listInternalIpRange.listIterator();
		ArrayList<String> list = new ArrayList<String>();
		while ( li.hasNext() ) {
			list.add(li.next().getIpRange());
		}
		return list;
	}

	public void setIpRangesInStringFormat(List<String> list) throws UnknownHostException {
		ListIterator<String> li = list.listIterator();
		while ( li.hasNext() ) {
			_listInternalIpRange.add(new IpRangeFilter(li.next()));
		}
	}	

	public List<IpRangeFilter> getIpRanges() {
		return _listInternalIpRange;
	}

	public void setIpRanges(List<IpRangeFilter> list) throws UnknownHostException {
		ListIterator<IpRangeFilter> li = list.listIterator();
		while ( li.hasNext() ) {
			_listInternalIpRange.add(li.next());
		}
	}	

}
