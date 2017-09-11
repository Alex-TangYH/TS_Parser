package com.alex.ts_parser.bean.descriptor;

import java.util.HashMap;
import java.util.Map;

public class DescriptorMap {
	public static Map<Integer, String> descriptorNameMap = new HashMap<Integer, String>();

	static {
		// TODO 把所有描述子ID和名字输入，并将此类中所有字符提取到资源文件统一管理
		descriptorNameMap.put(9, "CA_descriptor");
		descriptorNameMap.put(64, "NetworkNameDescriptor");
		descriptorNameMap.put(65, "ServiceListDescriptor");
		descriptorNameMap.put(67, "SatelliteDeliverySystemDescriptor");
		descriptorNameMap.put(90, "TerrestrialDeliverySystemDescriptor");
		descriptorNameMap.put(98, "FrequencyListDescriptor");
	}
}
