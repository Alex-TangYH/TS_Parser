package com.alex.ts_parser.bean.si;

public class ST_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int reservedFutureUse;
	private int reserved;
	private int sectionLength;
	private byte[] stDataArray;
	public ST_Table(int tableId, int sectionSyntaxIndicator, int reservedFutureUse, int reserved, int sectionLength,
			byte[] stDataArray) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.reservedFutureUse = reservedFutureUse;
		this.reserved = reserved;
		this.sectionLength = sectionLength;
		this.stDataArray = stDataArray;
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
	public byte[] getStDataArray() {
		return stDataArray;
	}
	public void setStDataArray(byte[] stDataArray) {
		this.stDataArray = stDataArray;
	}
}
