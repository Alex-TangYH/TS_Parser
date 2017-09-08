package com.alex.ts_parser.bean.psi;

import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class PAT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int zero;
	private int reservedFirst;
	private int sectionLength;
	private int transportStreamId;
	private int reservedSecond;
	private int versionNumber;
	private int currentNextIndicator;
	private int sectionNumber;
	private int lastSectionNumber;
	PAT_ProgramInfo patProgramInfoArray[];
	private int networkPID;
	private long crc32;

	public PAT_Table(int tableId, int sectionSyntaxIndicator, int zero, int reservedFirst, int sectionLength,
			int transportStreamId, int reservedSecond, int versionNumber, int currentNextIndicator, int sectionNumber,
			int lastSectionNumber, PAT_ProgramInfo[] patProgramInfoArray, int networkPID, int crc32) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.zero = zero;
		this.reservedFirst = reservedFirst;
		this.sectionLength = sectionLength;
		this.transportStreamId = transportStreamId;
		this.reservedSecond = reservedSecond;
		this.versionNumber = versionNumber;
		this.currentNextIndicator = currentNextIndicator;
		this.sectionNumber = sectionNumber;
		this.lastSectionNumber = lastSectionNumber;
		this.patProgramInfoArray = patProgramInfoArray;
		this.networkPID = networkPID;
		this.crc32 = CTypeFormat2JavaType.getUnsignedInt2Long(crc32);
	}

	public PAT_Table() {
		super();
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

	public int getTransportStreamId() {
		return transportStreamId;
	}

	public void setTransportStreamId(int transportStreamId) {
		this.transportStreamId = transportStreamId;
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

	public PAT_ProgramInfo[] getPatProgramInfo() {
		return patProgramInfoArray;
	}

	public void setPatProgramInfo(PAT_ProgramInfo[] patProgramInfoArray) {
		this.patProgramInfoArray = patProgramInfoArray;
	}

	public int getNetworkPID() {
		return networkPID;
	}

	public void setNetworkPID(int networkPID) {
		this.networkPID = networkPID;
	}

	public long getCrc32() {
		return crc32;
	}

	public void setCrc32(long crc32) {
		this.crc32 = crc32;
	}

	@Override
	public String toString() {
		return "PAT_Table [tableId=" + tableId + ", sectionSyntaxIndicator=" + sectionSyntaxIndicator + ", zero=" + zero
				+ ", reservedFirst=" + reservedFirst + ", sectionLength=" + sectionLength + ", transportStreamId="
				+ transportStreamId + ", reservedSecond=" + reservedSecond + ", versionNumber=" + versionNumber
				+ ", currentNextIndicator=" + currentNextIndicator + ", sectionNumber=" + sectionNumber
				+ ", lastSectionNumber=" + lastSectionNumber + ", networkPID=" + networkPID + ", crc32=" + crc32 + "]"
				+ "\n" + patProgramInfoArray[0].toString();
	}
}

class PAT_ProgramInfo {
	private int programNumber;
	private int reserved;
	private int programMapPID;

	public PAT_ProgramInfo(int programNumber, int reserved, int programMapPID) {
		super();
		this.programNumber = programNumber;
		this.reserved = reserved;
		this.programMapPID = programMapPID;
	}

	public int getProgramNumber() {
		return programNumber;
	}

	public void setProgramNumber(int programNumber) {
		this.programNumber = programNumber;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public int getProgramMapPID() {
		return programMapPID;
	}

	public void setProgramMapPID(int programMapPID) {
		this.programMapPID = programMapPID;
	}

	@Override
	public String toString() {
		return "PAT_ProgramInfo [programNumber=" + programNumber + ", reserved=" + reserved + ", programMapPID="
				+ programMapPID + "]";
	}
}