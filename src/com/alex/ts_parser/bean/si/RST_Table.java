package com.alex.ts_parser.bean.si;

public class RST_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int reservedFutureUse;
	private int reserved;
	private int sectionLength;
	private RstInfo[] rstInfo;
	public RST_Table(int tableId, int sectionSyntaxIndicator, int reservedFutureUse, int reserved,
			int sectionLength, RstInfo[] rstInfo) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.reservedFutureUse = reservedFutureUse;
		this.reserved = reserved;
		this.sectionLength = sectionLength;
		this.rstInfo = rstInfo;
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
	public RstInfo[] getRstInfo() {
		return rstInfo;
	}
	public void setRstInfo(RstInfo[] rstInfo) {
		this.rstInfo = rstInfo;
	}
}

class RstInfo{
	private int transportStreamId;
	private int originalNetworkId;
	private int serviceId;
	private int eventId;
	private int reservedFutureUse;
	private int runningStatus;
	
	public RstInfo(int transportStreamId, int originalNetworkId, int serviceId, int eventId, int reservedFutureUse,
			int runningStatus) {
		super();
		this.transportStreamId = transportStreamId;
		this.originalNetworkId = originalNetworkId;
		this.serviceId = serviceId;
		this.eventId = eventId;
		this.reservedFutureUse = reservedFutureUse;
		this.runningStatus = runningStatus;
	}
	public int getTransportStreamId() {
		return transportStreamId;
	}
	public void setTransportStreamId(int transportStreamId) {
		this.transportStreamId = transportStreamId;
	}
	public int getOriginalNetworkId() {
		return originalNetworkId;
	}
	public void setOriginalNetworkId(int originalNetworkId) {
		this.originalNetworkId = originalNetworkId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getReservedFutureUse() {
		return reservedFutureUse;
	}
	public void setReservedFutureUse(int reservedFutureUse) {
		this.reservedFutureUse = reservedFutureUse;
	}
	public int getRunningStatus() {
		return runningStatus;
	}
	public void setRunningStatus(int runningStatus) {
		this.runningStatus = runningStatus;
	}
}
