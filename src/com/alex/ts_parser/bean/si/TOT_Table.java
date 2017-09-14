package com.alex.ts_parser.bean.si;

import com.alex.ts_parser.bean.descriptor.Descriptor;
import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class TOT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int reservedFutureUse;
	private int reservedFirst;
	private int sectionLength;
	private long[] utcTime;
	private int reservedSecond;
	private int descriptorsLoopLength;
	private Descriptor[] descriptorArray;
	private long crc32;

	public TOT_Table(int tableId, int sectionSyntaxIndicator, int reservedFutureUse, int reservedFirst,
			int sectionLength, int[] utcTime, int reservedSecond, int descriptorsLoopLength,
			Descriptor[] descriptorArray, int crc32) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.reservedFutureUse = reservedFutureUse;
		this.reservedFirst = reservedFirst;
		this.sectionLength = sectionLength;
		this.utcTime = CTypeFormat2JavaType.getUnsignedIntArray2LongArray(utcTime);
		this.reservedSecond = reservedSecond;
		this.descriptorsLoopLength = descriptorsLoopLength;
		this.descriptorArray = descriptorArray;
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

	public int getReservedFutureUse() {
		return reservedFutureUse;
	}

	public void setReservedFutureUse(int reservedFutureUse) {
		this.reservedFutureUse = reservedFutureUse;
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

	public long[] getUtcTime() {
		return utcTime;
	}

	public void setUtcTime(long[] utcTime) {
		this.utcTime = utcTime;
	}

	public int getReservedSecond() {
		return reservedSecond;
	}

	public void setReservedSecond(int reservedSecond) {
		this.reservedSecond = reservedSecond;
	}

	public int getDescriptorsLoopLength() {
		return descriptorsLoopLength;
	}

	public void setDescriptorsLoopLength(int descriptorsLoopLength) {
		this.descriptorsLoopLength = descriptorsLoopLength;
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
}
