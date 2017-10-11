package com.alex.ts_parser.bean.descriptor;

import java.util.HashMap;
import java.util.Map;

public class DescriptorMap {
	public static Map<Integer, String> descriptorNameMap = new HashMap<Integer, String>();

	static {
		// OPT 把所有描述子ID和名字输入
		descriptorNameMap.put(2, "VideoStreamDescriptor");
		descriptorNameMap.put(3, "AudioStreamDescriptor");
		descriptorNameMap.put(6, "DataStreamAlignmentDescriptor");
		descriptorNameMap.put(9, "CA_descriptor");
		descriptorNameMap.put(10, "ISO_639_Language_Descriptor");
		descriptorNameMap.put(11, "SystemClockDescriptor");
		descriptorNameMap.put(14, "MaximumBitrateDescriptor");
		descriptorNameMap.put(64, "NetworkNameDescriptor");
		descriptorNameMap.put(65, "ServiceListDescriptor");
		descriptorNameMap.put(67, "SatelliteDeliverySystemDescriptor");
		descriptorNameMap.put(68, "CableDeliverySystemDescriptor");
		descriptorNameMap.put(72, "ServiceDescriptor");
		descriptorNameMap.put(74, "LinkageDescriptor");
		descriptorNameMap.put(77, "ShortEventDescriptor");
		descriptorNameMap.put(78, "ExtendedEventDescriptor");
		descriptorNameMap.put(80, "ComponentDescriptor");
		descriptorNameMap.put(82, "StreamIndentifierDescriptor");
		descriptorNameMap.put(84, "ContentDescriptor");
		descriptorNameMap.put(85, "ParentalRatingDescriptor");
		descriptorNameMap.put(86, "TeletextDescriptor");
		descriptorNameMap.put(88, "LocalTimeOffsetDescriptor");
		descriptorNameMap.put(90, "TerrestrialDeliverySystemDescriptor");
		descriptorNameMap.put(98, "FrequencyListDescriptor");
	}
}
