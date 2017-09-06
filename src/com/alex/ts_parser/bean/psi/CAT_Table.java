package com.alex.ts_parser.bean.psi;

import com.alex.ts_parser.bean.descriptor.CA_Descriptor;
import com.alex.ts_parser.bean.descriptor.Descriptor;
import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class CAT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int zero;
	private int reservedFirst;
	private int sectionLength;
	private int reservedSecond;
	private int versionNumber;
	private int currentNextIndicator;
	private int sectionNumber;
	private int lastSectionNumber;
	Descriptor descriptorArray[];
	private long crc32;

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

	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}

	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}

	public long getCrc32() {
		return crc32;
	}

	public void setCrc32(long crc32) {
		this.crc32 = crc32;
	}

	@Override
	public String toString() {
		return "CAT_Table [tableId=" + tableId + ", sectionSyntaxIndicator=" + sectionSyntaxIndicator + ", zero=" + zero
				+ ", reservedFirst=" + reservedFirst + ", sectionLength=" + sectionLength + ", reservedSecond="
				+ reservedSecond + ", versionNumber=" + versionNumber + ", currentNextIndicator=" + currentNextIndicator
				+ ", sectionNumber=" + sectionNumber + ", lastSectionNumber=" + lastSectionNumber + ", crc32=" + crc32
				+ "]";
	}
	
	public CAT_Table() {
		super();
	}

	public CAT_Table(int tableId, int sectionSyntaxIndicator, int zero, int reservedFirst, int sectionLength,
			int reservedSecond, int versionNumber, int currentNextIndicator, int sectionNumber, int lastSectionNumber,
			Descriptor[] descriptorArray,int crc32) {
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.zero = zero;
		this.reservedFirst = reservedFirst;
		this.sectionLength = sectionLength;
		this.reservedSecond = reservedSecond;
		this.versionNumber = versionNumber;
		this.currentNextIndicator = currentNextIndicator;
		this.sectionNumber = sectionNumber;
		this.lastSectionNumber = lastSectionNumber;
		this.descriptorArray = descriptorArray;
		this.crc32 = CTypeFormat2JavaType.getUnsignedInt2Long(crc32);
	}
}
