package com.alex.ts_parser.bean.descriptor;

import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class FrequencyListDescriptor extends Descriptor {
	private int reservedFutureUse;
	private int codingType;
	private FrequencyListInfo[] frequencyListInfo;

	public FrequencyListDescriptor(int descriptorTag, int descriptorLength, int reservedFutureUse, int codingType,
			FrequencyListInfo[] frequencyListInfo) {
		super(descriptorTag, descriptorLength);
		this.reservedFutureUse = reservedFutureUse;
		this.codingType = codingType;
		this.frequencyListInfo = frequencyListInfo;
	}

	public int getReservedFutureUse() {
		return reservedFutureUse;
	}

	public void setReservedFutureUse(int reservedFutureUse) {
		this.reservedFutureUse = reservedFutureUse;
	}

	public int getCodingType() {
		return codingType;
	}

	public void setCodingType(int codingType) {
		this.codingType = codingType;
	}

	public FrequencyListInfo[] getFrequencyListInfo() {
		return frequencyListInfo;
	}

	public void setFrequencyListInfo(FrequencyListInfo[] frequencyListInfo) {
		this.frequencyListInfo = frequencyListInfo;
	}

}

class FrequencyListInfo {
	private long centreFrequency;

	public FrequencyListInfo(int centreFrequency) {
		super();
		this.centreFrequency = CTypeFormat2JavaType.getUnsignedInt2Long(centreFrequency);
	}
	public FrequencyListInfo() {
	}
	public long getCentreFrequency() {
		return centreFrequency;
	}

	public void setCentreFrequency(long centreFrequency) {
		this.centreFrequency = centreFrequency;
	}

}
