package com.alex.ts_parser.bean.descriptor;

public class DataStreamAlignmentDescriptor extends Descriptor {
	private int alignmentType;

	public DataStreamAlignmentDescriptor(int descriptorTag, int descriptorLength, int alignmentType) {
		super(descriptorTag, descriptorLength);
		this.alignmentType = alignmentType;
	}

	public int getAlignmentType() {
		return alignmentType;
	}

	public void setAlignmentType(int alignmentType) {
		this.alignmentType = alignmentType;
	}
	
}
