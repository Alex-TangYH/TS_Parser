package com.alex.ts_parser.bean.descriptor;

import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class TerrestrialDeliverySystemDescriptor extends Descriptor {
	private long centreFrequency;
	private int bandwidth;
	private int priority;
	private int timeSlicingIndicator;
	private int mpeFEC_Indicator;
	private int reservedFutureUseFirst;
	private int constellation;
	private int hierarchyInformation;
	private int codeRateHP_Stream;
	private int codeRateLP_Stream;
	private int guardInterval;
	private int transmissionMode;
	private int otherFrequencyFlag;
	private long reservedFutureUseSecond;

	public TerrestrialDeliverySystemDescriptor(int descriptorTag, int descriptorLength, int centreFrequency,
			int bandwidth, int priority, int timeSlicingIndicator, int mpeFEC_Indicator, int reservedFutureUseFirst,
			int constellation, int hierarchyInformation, int codeRateHP_Stream, int codeRateLP_Stream,
			int guardInterval, int transmissionMode, int otherFrequencyFlag, int reservedFutureUseSecond) {
		super(descriptorTag, descriptorLength);
		this.centreFrequency = CTypeFormat2JavaType.getUnsignedInt2Long(centreFrequency);
		this.bandwidth = bandwidth;
		this.priority = priority;
		this.timeSlicingIndicator = timeSlicingIndicator;
		this.mpeFEC_Indicator = mpeFEC_Indicator;
		this.reservedFutureUseFirst = reservedFutureUseFirst;
		this.constellation = constellation;
		this.hierarchyInformation = hierarchyInformation;
		this.codeRateHP_Stream = codeRateHP_Stream;
		this.codeRateLP_Stream = codeRateLP_Stream;
		this.guardInterval = guardInterval;
		this.transmissionMode = transmissionMode;
		this.otherFrequencyFlag = otherFrequencyFlag;
		this.reservedFutureUseSecond = CTypeFormat2JavaType.getUnsignedInt2Long(reservedFutureUseSecond);
	}

	public long getCentreFrequency() {
		return centreFrequency;
	}

	public void setCentreFrequency(long centreFrequency) {
		this.centreFrequency = centreFrequency;
	}

	public int getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTimeSlicingIndicator() {
		return timeSlicingIndicator;
	}

	public void setTimeSlicingIndicator(int timeSlicingIndicator) {
		this.timeSlicingIndicator = timeSlicingIndicator;
	}

	public int getMpeFEC_Indicator() {
		return mpeFEC_Indicator;
	}

	public void setMpeFEC_Indicator(int mpeFEC_Indicator) {
		this.mpeFEC_Indicator = mpeFEC_Indicator;
	}

	public int getReservedFutureUseFirst() {
		return reservedFutureUseFirst;
	}

	public void setReservedFutureUseFirst(int reservedFutureUseFirst) {
		this.reservedFutureUseFirst = reservedFutureUseFirst;
	}

	public int getConstellation() {
		return constellation;
	}

	public void setConstellation(int constellation) {
		this.constellation = constellation;
	}

	public int getHierarchyInformation() {
		return hierarchyInformation;
	}

	public void setHierarchyInformation(int hierarchyInformation) {
		this.hierarchyInformation = hierarchyInformation;
	}

	public int getCodeRateHP_Stream() {
		return codeRateHP_Stream;
	}

	public void setCodeRateHP_Stream(int codeRateHP_Stream) {
		this.codeRateHP_Stream = codeRateHP_Stream;
	}

	public int getCodeRateLP_Stream() {
		return codeRateLP_Stream;
	}

	public void setCodeRateLP_Stream(int codeRateLP_Stream) {
		this.codeRateLP_Stream = codeRateLP_Stream;
	}

	public int getGuardInterval() {
		return guardInterval;
	}

	public void setGuardInterval(int guardInterval) {
		this.guardInterval = guardInterval;
	}

	public int getTransmissionMode() {
		return transmissionMode;
	}

	public void setTransmissionMode(int transmissionMode) {
		this.transmissionMode = transmissionMode;
	}

	public int getOtherFrequencyFlag() {
		return otherFrequencyFlag;
	}

	public void setOtherFrequencyFlag(int otherFrequencyFlag) {
		this.otherFrequencyFlag = otherFrequencyFlag;
	}

	public long getReservedFutureUseSecond() {
		return reservedFutureUseSecond;
	}

	public void setReservedFutureUseSecond(long reservedFutureUseSecond) {
		this.reservedFutureUseSecond = reservedFutureUseSecond;
	}
}
