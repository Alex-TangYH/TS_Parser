package com.alex.ts_parser.bean.map;

import java.util.HashMap;
import java.util.Map;

public class BandwidthMap {
	public static Map<Integer, String> bandwidthMap = new HashMap<Integer, String>();
	
	static {
		bandwidthMap.put(0, "8 MHz");
		bandwidthMap.put(1, "7 MHz");
		bandwidthMap.put(2, "6 MHz");
		bandwidthMap.put(3, "5 MHz");
		bandwidthMap.put(4, "Reserved for future use");
		bandwidthMap.put(5, "Reserved for future use");
		bandwidthMap.put(6, "Reserved for future use");
		bandwidthMap.put(7, "Reserved for future use");
	}
}
