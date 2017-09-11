package com.alex.ts_parser.bean.descriptor;

import java.util.HashMap;
import java.util.Map;

public class DescriptorMap {
	public static Map<Integer, String> descriptorNameMap = new HashMap<Integer, String>();

	static {
		// TODO ������������ID���������룬���������������ַ���ȡ����Դ�ļ�ͳһ����
		descriptorNameMap.put(9, "CA_descriptor");
		descriptorNameMap.put(64, "NetworkNameDescriptor");
		descriptorNameMap.put(65, "ServiceListDescriptor");
		descriptorNameMap.put(67, "SatelliteDeliverySystemDescriptor");
		descriptorNameMap.put(90, "TerrestrialDeliverySystemDescriptor");
		descriptorNameMap.put(98, "FrequencyListDescriptor");
	}
}
