package com.alex.ts_parser.bean.descriptor;

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

	public FrequencyListInfo(long centreFrequency) {
		super();
		this.centreFrequency = centreFrequency;
	}

	public long getCentreFrequency() {
		return centreFrequency;
	}

	public void setCentreFrequency(long centreFrequency) {
		this.centreFrequency = centreFrequency;
	}

}
