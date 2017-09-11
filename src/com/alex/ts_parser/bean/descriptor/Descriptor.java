package com.alex.ts_parser.bean.descriptor;

/**
 * ÃèÊö·û»ùÀà
 * 
 * @author Administrator
 *
 */
public class Descriptor {
	private int descriptorTag;
	private int descriptorLength;

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
		return DescriptorMap.descriptorNameMap.getOrDefault(descriptorTag, "unknown descriptor");
	}

	public Descriptor(int descriptorTag, int descriptorLength) {
		this.descriptorTag = descriptorTag;
		this.descriptorLength = descriptorLength;
	}

	public Descriptor() {
	}
}
