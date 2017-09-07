package com.alex.ts_parser.bean.descriptor;

public class LocalTimeOffsetDescriptor extends Descriptor {
	private LocalTimeOffsetDescriptorInfo[] localTimeOffsetDescriptorinfo;
}

class LocalTimeOffsetDescriptorInfo {
	private byte[] countryCode;
	private int countryRegionId;
	private int reserved;
	private int localTimeOffsetPolarity;
	private int localTimeOffset;
	private int timeOfChange;
	private int nextTimeOffset;
	public LocalTimeOffsetDescriptorInfo(byte[] countryCode, int countryRegionId, int reserved,
			int localTimeOffsetPolarity, int localTimeOffset, int timeOfChange, int nextTimeOffset) {
		super();
		this.countryCode = countryCode;
		this.countryRegionId = countryRegionId;
		this.reserved = reserved;
		this.localTimeOffsetPolarity = localTimeOffsetPolarity;
		this.localTimeOffset = localTimeOffset;
		this.timeOfChange = timeOfChange;
		this.nextTimeOffset = nextTimeOffset;
	}
	public byte[] getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(byte[] countryCode) {
		this.countryCode = countryCode;
	}
	public int getCountryRegionId() {
		return countryRegionId;
	}
	public void setCountryRegionId(int countryRegionId) {
		this.countryRegionId = countryRegionId;
	}
	public int getReserved() {
		return reserved;
	}
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	public int getLocalTimeOffsetPolarity() {
		return localTimeOffsetPolarity;
	}
	public void setLocalTimeOffsetPolarity(int localTimeOffsetPolarity) {
		this.localTimeOffsetPolarity = localTimeOffsetPolarity;
	}
	public int getLocalTimeOffset() {
		return localTimeOffset;
	}
	public void setLocalTimeOffset(int localTimeOffset) {
		this.localTimeOffset = localTimeOffset;
	}
	public int getTimeOfChange() {
		return timeOfChange;
	}
	public void setTimeOfChange(int timeOfChange) {
		this.timeOfChange = timeOfChange;
	}
	public int getNextTimeOffset() {
		return nextTimeOffset;
	}
	public void setNextTimeOffset(int nextTimeOffset) {
		this.nextTimeOffset = nextTimeOffset;
	}
	
	
}