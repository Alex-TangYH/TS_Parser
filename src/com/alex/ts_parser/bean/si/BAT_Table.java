package com.alex.ts_parser.bean.si;

import com.alex.ts_parser.bean.descriptor.Descriptor;

public class BAT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int reservedFutureUseFirst;
	private int reservedFirst;
	private int sectionLength;
	private int boquetId;
	private int reservedSecond;
	private int versionNumber;
	private int currentNextIndicator;
	private int sectionNumber;
	private int lastSectionNumber;
	private int reservedFutureUseSecond;
	private int bouquetDescriptorLength;
	private Descriptor[] descriptorArray;
	private int reservedThird;
	private int transportStreamLoopLength;
	private BatInfo[] batInfoArray;
	private long crc32;
	public BAT_Table(int tableId, int sectionSyntaxIndicator, int reservedFutureUseFirst, int reservedFirst,
			int sectionLength, int boquetId, int reservedSecond, int versionNumber, int currentNextIndicator,
			int sectionNumber, int lastSectionNumber, int reservedFutureUseSecond, int bouquetDescriptorLength,
			Descriptor[] descriptorArray, int reservedThird, int transportStreamLoopLength, BatInfo[] batInfoArray,
			long crc32) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.reservedFutureUseFirst = reservedFutureUseFirst;
		this.reservedFirst = reservedFirst;
		this.sectionLength = sectionLength;
		this.boquetId = boquetId;
		this.reservedSecond = reservedSecond;
		this.versionNumber = versionNumber;
		this.currentNextIndicator = currentNextIndicator;
		this.sectionNumber = sectionNumber;
		this.lastSectionNumber = lastSectionNumber;
		this.reservedFutureUseSecond = reservedFutureUseSecond;
		this.bouquetDescriptorLength = bouquetDescriptorLength;
		this.descriptorArray = descriptorArray;
		this.reservedThird = reservedThird;
		this.transportStreamLoopLength = transportStreamLoopLength;
		this.batInfoArray = batInfoArray;
		this.crc32 = crc32;
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
	public int getBoquetId() {
		return boquetId;
	}
	public void setBoquetId(int boquetId) {
		this.boquetId = boquetId;
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
	public int getReservedFutureUseSecond() {
		return reservedFutureUseSecond;
	}
	public void setReservedFutureUseSecond(int reservedFutureUseSecond) {
		this.reservedFutureUseSecond = reservedFutureUseSecond;
	}
	public int getBouquetDescriptorLength() {
		return bouquetDescriptorLength;
	}
	public void setBouquetDescriptorLength(int bouquetDescriptorLength) {
		this.bouquetDescriptorLength = bouquetDescriptorLength;
	}
	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}
	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}
	public int getReservedThird() {
		return reservedThird;
	}
	public void setReservedThird(int reservedThird) {
		this.reservedThird = reservedThird;
	}
	public int getTransportStreamLoopLength() {
		return transportStreamLoopLength;
	}
	public void setTransportStreamLoopLength(int transportStreamLoopLength) {
		this.transportStreamLoopLength = transportStreamLoopLength;
	}
	public BatInfo[] getBatInfoArray() {
		return batInfoArray;
	}
	public void setBatInfoArray(BatInfo[] batInfoArray) {
		this.batInfoArray = batInfoArray;
	}
	public long getCrc32() {
		return crc32;
	}
	public void setCrc32(long crc32) {
		this.crc32 = crc32;
	}
}

class BatInfo{
	private int transportStreamId;
	private int originalNetworkId;
	private int reservedFutureUse;
	private int transportDescriptorLength;
	private Descriptor[] descriptorArray;
	public BatInfo(int transportStreamId, int originalNetworkId, int reservedFutureUse, int transportDescriptorLength,
			Descriptor[] descriptorArray) {
		super();
		this.transportStreamId = transportStreamId;
		this.originalNetworkId = originalNetworkId;
		this.reservedFutureUse = reservedFutureUse;
		this.transportDescriptorLength = transportDescriptorLength;
		this.descriptorArray = descriptorArray;
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
	public int getReservedFutureUse() {
		return reservedFutureUse;
	}
	public void setReservedFutureUse(int reservedFutureUse) {
		this.reservedFutureUse = reservedFutureUse;
	}
	public int getTransportDescriptorLength() {
		return transportDescriptorLength;
	}
	public void setTransportDescriptorLength(int transportDescriptorLength) {
		this.transportDescriptorLength = transportDescriptorLength;
	}
	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}
	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}
}