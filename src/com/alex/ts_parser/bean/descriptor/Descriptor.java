package com.alex.ts_parser.bean.descriptor;

/**
 * 描述符基类
 * 
 * @author Administrator
 *
 */
public class Descriptor {
	int descriptorTag;
	int descriptorLength;

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

	public String getDescriptorName(int descriptorTag) {
		//TODO 根据Tag返回描述符名称
		//TODO 编写对应关系Map
		//getValue(descriptorTag);
		return null;
	}
}
