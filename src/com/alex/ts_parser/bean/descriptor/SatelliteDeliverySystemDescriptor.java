package com.alex.ts_parser.bean.descriptor;

public class SatelliteDeliverySystemDescriptor extends Descriptor {
	private long frequency;
	private int orbitalPosition;
	private int westOrEastFlag;
	private int polarization;
	private int rollOff;
	private int modulationSystem;
	private int modulationType;
	private int symbolRate;
	private int fecInner;
	public SatelliteDeliverySystemDescriptor(int descriptorTag, int descriptorLength, long frequency,
			int orbitalPosition, int westOrEastFlag, int polarization, int rollOff, int modulationSystem,
			int modulationType, int symbolRate, int fecInner) {
		super(descriptorTag, descriptorLength);
		this.frequency = frequency;
		this.orbitalPosition = orbitalPosition;
		this.westOrEastFlag = westOrEastFlag;
		this.polarization = polarization;
		this.rollOff = rollOff;
		this.modulationSystem = modulationSystem;
		this.modulationType = modulationType;
		this.symbolRate = symbolRate;
		this.fecInner = fecInner;
	}
	public long getFrequency() {
		return frequency;
	}
	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}
	public int getOrbitalPosition() {
		return orbitalPosition;
	}
	public void setOrbitalPosition(int orbitalPosition) {
		this.orbitalPosition = orbitalPosition;
	}
	public int getWestOrEastFlag() {
		return westOrEastFlag;
	}
	public void setWestOrEastFlag(int westOrEastFlag) {
		this.westOrEastFlag = westOrEastFlag;
	}
	public int getPolarization() {
		return polarization;
	}
	public void setPolarization(int polarization) {
		this.polarization = polarization;
	}
	public int getRollOff() {
		return rollOff;
	}
	public void setRollOff(int rollOff) {
		this.rollOff = rollOff;
	}
	public int getModulationSystem() {
		return modulationSystem;
	}
	public void setModulationSystem(int modulationSystem) {
		this.modulationSystem = modulationSystem;
	}
	public int getModulationType() {
		return modulationType;
	}
	public void setModulationType(int modulationType) {
		this.modulationType = modulationType;
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
