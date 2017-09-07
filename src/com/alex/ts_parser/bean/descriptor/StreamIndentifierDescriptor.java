package com.alex.ts_parser.bean.descriptor;

public class StreamIndentifierDescriptor extends Descriptor {
	private int componentTag;

	public StreamIndentifierDescriptor(int descriptorTag, int descriptorLength, int componentTag) {
		super(descriptorTag, descriptorLength);
		this.componentTag = componentTag;
	}

	public int getComponentTag() {
		return componentTag;
	}

	public void setComponentTag(int componentTag) {
		this.componentTag = componentTag;
	}
}
