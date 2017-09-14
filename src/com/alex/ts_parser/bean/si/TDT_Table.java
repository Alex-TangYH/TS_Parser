package com.alex.ts_parser.bean.si;

import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class TDT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int reservedFutureUse;
	private int reserved;
	private int sectionLength;
	private long[] utcTime;

	public TDT_Table(int tableId, int sectionSyntaxIndicator, int reservedFutureUse, int reserved, int sectionLength,
			int[] utcTime) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.reservedFutureUse = reservedFutureUse;
		this.reserved = reserved;
		this.sectionLength = sectionLength;
		this.utcTime = CTypeFormat2JavaType.getUnsignedIntArray2LongArray(utcTime);
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

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
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

}
