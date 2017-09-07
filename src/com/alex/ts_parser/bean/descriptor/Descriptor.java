package com.alex.ts_parser.bean.descriptor;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述符基类
 * 
 * @author Administrator
 *
 */
public class Descriptor {
	private int descriptorTag;
	private int descriptorLength;
	private static Map<Integer, String> descriptorNameMap = new HashMap<Integer, String>();
	
	static {
		//TODO 把所有描述子ID和名字输入，并将此类中所有字符提取到资源文件统一管理
		descriptorNameMap.put(9, "CA_descriptor");
	}

	public int getDescriptorTag() {
		return descriptorTag;
	}

	public void setDescriptorTag(int descriptorTag) {
		this.descriptorTag = descriptorTag;
	}

	public int getDescriptorLength() {
		return descriptorLength;
	}

	public void setDescriptorLength(int descriptorLength) {
		this.descriptorLength = descriptorLength;
	}

	public String getDescriptorName() {
		return descriptorNameMap.getOrDefault(descriptorTag, "unknown descriptor");
	}

	public Descriptor(int descriptorTag, int descriptorLength) {
		this.descriptorTag = descriptorTag;
		this.descriptorLength = descriptorLength;
	}

	public Descriptor() {
	}
}
