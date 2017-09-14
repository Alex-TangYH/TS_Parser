package com.alex.ts_parser.bean.descriptor;

import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class CableDeliverySystemDescriptor extends Descriptor {
	private long frequency;
	private int reservedFutureUse;
	private int fecOuter;
	private int modulation;
	private int symbolRate;
	private int fecInner;

	public CableDeliverySystemDescriptor(int descriptorTag, int descriptorLength, int frequency, int reservedFutureUse,
			int fecOuter, int modulation, int symbolRate, int fecInner) {
		super(descriptorTag, descriptorLength);
		this.frequency = CTypeFormat2JavaType.getUnsignedInt2Long(frequency);
		this.reservedFutureUse = reservedFutureUse;
		this.fecOuter = fecOuter;
		this.modulation = modulation;
		this.symbolRate = symbolRate;
		this.fecInner = fecInner;
	}

	public long getFrequency() {
		return frequency;
	}

	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}

	public int getReservedFutureUse() {
		return reservedFutureUse;
	}

	public void setReservedFutureUse(int reservedFutureUse) {
		this.reservedFutureUse = reservedFutureUse;
	}

	public int getFecOuter() {
		return fecOuter;
	}

	public void setFecOuter(int fecOuter) {
		this.fecOuter = fecOuter;
	}

	public int getModulation() {
		return modulation;
	}

	public void setModulation(int modulation) {
		this.modulation = modulation;
	}

	public int getSymbolRate() {
		return symbolRate;
	}

	public void setSymbolRate(int symbolRate) {
		this.symbolRate = symbolRate;
	}

	public int getFecInner() {
		return fecInner;
	}

	public void setFecInner(int fecInner) {
		this.fecInner = fecInner;
	}

}
