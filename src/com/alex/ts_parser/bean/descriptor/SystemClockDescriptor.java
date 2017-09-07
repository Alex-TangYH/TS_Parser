package com.alex.ts_parser.bean.descriptor;

public class SystemClockDescriptor extends Descriptor {
	private int externalClockReferenceIndicator;
	private int reservedFirst;
	private int clockAccuracyInteger;
	private int clockAccuracyExponent;
	private int reservedSecond;
	public SystemClockDescriptor(int descriptorTag, int descriptorLength, int externalClockReferenceIndicator,
			int reservedFirst, int clockAccuracyInteger, int clockAccuracyExponent, int reservedSecond) {
		super(descriptorTag, descriptorLength);
		this.externalClockReferenceIndicator = externalClockReferenceIndicator;
		this.reservedFirst = reservedFirst;
		this.clockAccuracyInteger = clockAccuracyInteger;
		this.clockAccuracyExponent = clockAccuracyExponent;
		this.reservedSecond = reservedSecond;
	}
	public int getExternalClockReferenceIndicator() {
		return externalClockReferenceIndicator;
	}
	public void setExternalClockReferenceIndicator(int externalClockReferenceIndicator) {
		this.externalClockReferenceIndicator = externalClockReferenceIndicator;
	}
	public int getReservedFirst() {
		return reservedFirst;
	}
	public void setReservedFirst(int reservedFirst) {
		this.reservedFirst = reservedFirst;
	}
	public int getClockAccuracyInteger() {
		return clockAccuracyInteger;
	}
	public void setClockAccuracyInteger(int clockAccuracyInteger) {
		this.clockAccuracyInteger = clockAccuracyInteger;
	}
	public int getClockAccuracyExponent() {
		return clockAccuracyExponent;
	}
	public void setClockAccuracyExponent(int clockAccuracyExponent) {
		this.clockAccuracyExponent = clockAccuracyExponent;
	}
	public int getReservedSecond() {
		return reservedSecond;
	}
	public void setReservedSecond(int reservedSecond) {
		this.reservedSecond = reservedSecond;
	}
	
	
}
