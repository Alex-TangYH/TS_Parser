package com.alex.ts_parser.bean.descriptor;

/**
 * ����������
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
		//TODO ����Tag��������������
		//TODO ��д��Ӧ��ϵMap
		//getValue(descriptorTag);
		return null;
	}
}
