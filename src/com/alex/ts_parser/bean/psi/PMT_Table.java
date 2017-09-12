package com.alex.ts_parser.bean.psi;

import com.alex.ts_parser.bean.descriptor.Descriptor;
import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class PMT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int zero;
	private int reservedFirst;
	private int sectionLength;
	private int programNumber;
	private int reservedSecond;
	private int versionNumber;
	private int currentNextIndicator;
	private int sectionNumber;
	private int lastSectionNumber;
	private int reservedThird;
	private int pcrPid;
	private int reservedFourth;
	private int programInfoLength;
	private Descriptor[] descriptorArray;
	private PMT_Stream[] pmtStreamArray;
	private long crc32;

	public PMT_Table(int tableId, int sectionSyntaxIndicator, int zero, int reservedFirst, int sectionLength,
			int programNumber, int reservedSecond, int versionNumber, int currentNextIndicator, int sectionNumber,
			int lastSectionNumber, int reservedThird, int pcrPid, int reservedFourth, int programInfoLength,
			Descriptor[] descriptorArray, PMT_Stream[] pmtStreamArray, int crc32) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.zero = zero;
		this.reservedFirst = reservedFirst;
		this.sectionLength = sectionLength;
		this.programNumber = programNumber;
		this.reservedSecond = reservedSecond;
		this.versionNumber = versionNumber;
		this.currentNextIndicator = currentNextIndicator;
		this.sectionNumber = sectionNumber;
		this.lastSectionNumber = lastSectionNumber;
		this.reservedThird = reservedThird;
		this.pcrPid = pcrPid;
		this.reservedFourth = reservedFourth;
		this.programInfoLength = programInfoLength;
		this.descriptorArray = descriptorArray;
		this.pmtStreamArray = pmtStreamArray;
		this.crc32 = CTypeFormat2JavaType.getUnsignedInt2Long(crc32);
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getSectionSyntaxIndicator() {
		return sectionSyntaxIndicator;
	}

	public void setSectionSyntaxIndicator(int sectionSyntaxIndicator) {
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
	}

	public int getZero() {
		return zero;
	}

	public void setZero(int zero) {
		this.zero = zero;
	}

	public int getReservedFirst() {
		return reservedFirst;
	}

	public void setReservedFirst(int reservedFirst) {
		this.reservedFirst = reservedFirst;
	}

	public int getSectionLength() {
		return sectionLength;
	}

	public void setSectionLength(int sectionLength) {
		this.sectionLength = sectionLength;
	}

	public int getProgramNumber() {
		return programNumber;
	}

	public void setProgramNumber(int programNumber) {
		this.programNumber = programNumber;
	}

	public int getReservedSecond() {
		return reservedSecond;
	}

	public void setReservedSecond(int reservedSecond) {
		this.reservedSecond = reservedSecond;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getCurrentNextIndicator() {
		return currentNextIndicator;
	}

	public void setCurrentNextIndicator(int currentNextIndicator) {
		this.currentNextIndicator = currentNextIndicator;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public int getLastSectionNumber() {
		return lastSectionNumber;
	}

	public void setLastSectionNumber(int lastSectionNumber) {
		this.lastSectionNumber = lastSectionNumber;
	}

	public int getReservedThird() {
		return reservedThird;
	}

	public void setReservedThird(int reservedThird) {
		this.reservedThird = reservedThird;
	}

	public int getPcrPid() {
		return pcrPid;
	}

	public void setPcrPid(int pcrPid) {
		this.pcrPid = pcrPid;
	}

	public int getReservedFourth() {
		return reservedFourth;
	}

	public void setReservedFourth(int reservedFourth) {
		this.reservedFourth = reservedFourth;
	}

	public int getProgramInfoLength() {
		return programInfoLength;
	}

	public void setProgramInfoLength(int programInfoLength) {
		this.programInfoLength = programInfoLength;
	}

	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}

	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}

	public PMT_Stream[] getPmtStreamArray() {
		return pmtStreamArray;
	}

	public void setPmtStreamArray(PMT_Stream[] pmtStreamArray) {
		this.pmtStreamArray = pmtStreamArray;
	}

	public long getCrc32() {
		return crc32;
	}

	public void setCrc32(long crc32) {
		this.crc32 = crc32;
	}
}

class PMT_Stream {
	private int streamType;
	private int reservedFifth;
	private int elementaryPID;
	private int reservedSixth;
	private int esInfoLength;
	private Descriptor descriptorArray[];

	public PMT_Stream(int streamType, int reservedFifth, int elementaryPID, int reservedSixth, int esInfoLength,
			Descriptor[] descriptorArray) {
		super();
		this.streamType = streamType;
		this.reservedFifth = reservedFifth;
		this.elementaryPID = elementaryPID;
		this.reservedSixth = reservedSixth;
		this.esInfoLength = esInfoLength;
		this.descriptorArray = descriptorArray;
	}

	public int getStreamType() {
		return streamType;
	}

	public void setStreamType(int streamType) {
		this.streamType = streamType;
	}

	public int getReservedFifth() {
		return reservedFifth;
	}

	public void setReservedFifth(int reservedFifth) {
		this.reservedFifth = reservedFifth;
	}

	public int getElementaryPID() {
		return elementaryPID;
	}

	public void setElementaryPID(int elementaryPID) {
		this.elementaryPID = elementaryPID;
	}

	public int getReservedSixth() {
		return reservedSixth;
	}

	public void setReservedSixth(int reservedSixth) {
		this.reservedSixth = reservedSixth;
	}

	public int getEsInfoLength() {
		return esInfoLength;
	}

	public void setEsInfoLength(int esInfoLength) {
		this.esInfoLength = esInfoLength;
	}

	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}

	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}
}