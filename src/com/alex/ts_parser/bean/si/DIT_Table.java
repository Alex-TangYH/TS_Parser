package com.alex.ts_parser.bean.si;

public class DIT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int reservedFutureUseFirst;
	private int reserved;
	private int sectionLength;
	private int transitionFlag;
	private int reservedFutureUseSecond;
	public DIT_Table(int tableId, int sectionSyntaxIndicator, int reservedFutureUseFirst, int reserved,
			int sectionLength, int transitionFlag, int reservedFutureUseSecond) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.reservedFutureUseFirst = reservedFutureUseFirst;
		this.reserved = reserved;
		this.sectionLength = sectionLength;
		this.transitionFlag = transitionFlag;
		this.reservedFutureUseSecond = reservedFutureUseSecond;
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
	public int getReservedFutureUseFirst() {
		return reservedFutureUseFirst;
	}
	public void setReservedFutureUseFirst(int reservedFutureUseFirst) {
		this.reservedFutureUseFirst = reservedFutureUseFirst;
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
	public int getTransitionFlag() {
		return transitionFlag;
	}
	public void setTransitionFlag(int transitionFlag) {
		this.transitionFlag = transitionFlag;
	}
	public int getReservedFutureUseSecond() {
		return reservedFutureUseSecond;
	}
	public void setReservedFutureUseSecond(int reservedFutureUseSecond) {
		this.reservedFutureUseSecond = reservedFutureUseSecond;
	}
}
