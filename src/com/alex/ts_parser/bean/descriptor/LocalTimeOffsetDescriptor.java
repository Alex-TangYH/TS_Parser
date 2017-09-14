package com.alex.ts_parser.bean.descriptor;

import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class LocalTimeOffsetDescriptor extends Descriptor {
	private LocalTimeOffsetDescriptorInfo[] localTimeOffsetDescriptorInfoArray;

	public LocalTimeOffsetDescriptor(int descriptorTag, int descriptorLength,
			LocalTimeOffsetDescriptorInfo[] localTimeOffsetDescriptorInfoArray) {
		super(descriptorTag, descriptorLength);
		this.localTimeOffsetDescriptorInfoArray = localTimeOffsetDescriptorInfoArray;
	}

	public LocalTimeOffsetDescriptorInfo[] getLocalTimeOffsetDescriptorinfo() {
		return localTimeOffsetDescriptorInfoArray;
	}

	public void setLocalTimeOffsetDescriptorinfo(LocalTimeOffsetDescriptorInfo[] localTimeOffsetDescriptorInfoArray) {
		this.localTimeOffsetDescriptorInfoArray = localTimeOffsetDescriptorInfoArray;
	}
}

class LocalTimeOffsetDescriptorInfo {
	private byte[] countryCode;
	private int countryRegionId;
	private int reserved;
	private int localTimeOffsetPolarity;
	private int localTimeOffset;
	private long[] timeOfChangeArray;
	private int nextTimeOffset;

	public LocalTimeOffsetDescriptorInfo(byte[] countryCode, int countryRegionId, int reserved,
			int localTimeOffsetPolarity, int localTimeOffset, int[] timeOfChangeArray, int nextTimeOffset) {
		super();
		this.countryCode = countryCode;
		this.countryRegionId = countryRegionId;
		this.reserved = reserved;
		this.localTimeOffsetPolarity = localTimeOffsetPolarity;
		this.localTimeOffset = localTimeOffset;
		this.timeOfChangeArray = CTypeFormat2JavaType.getUnsignedIntArray2LongArray(timeOfChangeArray);
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

	public long[] getTimeOfChange() {
		return timeOfChangeArray;
	}

	public void setTimeOfChange(long[] timeOfChangeArray) {
		this.timeOfChangeArray = timeOfChangeArray;
	}

	public int getNextTimeOffset() {
		return nextTimeOffset;
	}

	public void setNextTimeOffset(int nextTimeOffset) {
		this.nextTimeOffset = nextTimeOffset;
	}

}