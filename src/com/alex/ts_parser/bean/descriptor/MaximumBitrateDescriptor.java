package com.alex.ts_parser.bean.descriptor;

public class MaximumBitrateDescriptor extends Descriptor {
	private int reserved;
	private int maximumBitrate;
	public MaximumBitrateDescriptor(int descriptorTag, int descriptorLength, int reserved, int maximumBitrate) {
		super(descriptorTag, descriptorLength);
		this.reserved = reserved;
		this.maximumBitrate = maximumBitrate;
	}
	public int getReserved() {
		return reserved;
	}
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	public int getMaximumBitrate() {
		return maximumBitrate;
	}
	public void setMaximumBitrate(int maximumBitrate) {
		this.maximumBitrate = maximumBitrate;
	}
}
