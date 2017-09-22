package com.alex.ts_parser.bean.si;

import com.alex.ts_parser.bean.descriptor.Descriptor;
import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class EIT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int reservedFutureUseFirst;
	private int reservedFirst;
	private int sectionLength;
	private int serviceId;
	private int reservedSecond;
	private int versionNumber;
	private int currentNextIndicator;
	private int sectionNumber;
	private int lastSectionNumber;
	private int transportStreamId;
	private int originalNetworkId;
	private int segmentLastSectionNumber;
	private int lastTableId;
	private EitInfo[] eitInfoArray;
	private long crc32;
	public EIT_Table(int tableId, int sectionSyntaxIndicator, int reservedFutureUseFirst, int reservedFirst,
			int sectionLength, int serviceId, int reservedSecond, int versionNumber, int currentNextIndicator,
			int sectionNumber, int lastSectionNumber, int transportStreamId, int originalNetworkId,
			int segmentLastSectionNumber, int lastTableId, EitInfo[] eitInfoArray, int crc32) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.reservedFutureUseFirst = reservedFutureUseFirst;
		this.reservedFirst = reservedFirst;
		this.sectionLength = sectionLength;
		this.serviceId = serviceId;
		this.reservedSecond = reservedSecond;
		this.versionNumber = versionNumber;
		this.currentNextIndicator = currentNextIndicator;
		this.sectionNumber = sectionNumber;
		this.lastSectionNumber = lastSectionNumber;
		this.transportStreamId = transportStreamId;
		this.originalNetworkId = originalNetworkId;
		this.segmentLastSectionNumber = segmentLastSectionNumber;
		this.lastTableId = lastTableId;
		this.eitInfoArray = eitInfoArray;
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
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
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
	public int getSegmentLastSectionNumber() {
		return segmentLastSectionNumber;
	}
	public void setSegmentLastSectionNumber(int segmentLastSectionNumber) {
		this.segmentLastSectionNumber = segmentLastSectionNumber;
	}
	public int getLastTableId() {
		return lastTableId;
	}
	public void setLastTableId(int lastTableId) {
		this.lastTableId = lastTableId;
	}
	public EitInfo[] getEitInfoArray() {
		return eitInfoArray;
	}
	public void setEitInfoArray(EitInfo[] eitInfoArray) {
		this.eitInfoArray = eitInfoArray;
	}
	public long getCrc32() {
		return crc32;
	}
	public void setCrc32(long crc32) {
		this.crc32 = crc32;
	}
}

class EitInfo{
	private int eventId;
	private long[] startTimeArray;
	private long[] duration;
	private int runningStatus;
	private int freeCaMode;
	private int descriptorsLoopLength;
	private Descriptor[] descriptorArray;
	public EitInfo(int eventId, int[] startTimeArray, int[] duration, int runningStatus, int freeCaMode,
			int descriptorsLoopLength, Descriptor[] descriptorArray) {
		super();
		this.eventId = eventId;
		this.startTimeArray = CTypeFormat2JavaType.getUnsignedIntArray2LongArray(startTimeArray);
		this.duration = CTypeFormat2JavaType.getUnsignedIntArray2LongArray(duration);
		this.runningStatus = runningStatus;
		this.freeCaMode = freeCaMode;
		this.descriptorsLoopLength = descriptorsLoopLength;
		this.descriptorArray = descriptorArray;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public long[] getStartTimeArray() {
		return startTimeArray;
	}
	public void setStartTimeArray(long[] startTimeArray) {
		this.startTimeArray = startTimeArray;
	}
	public long[] getDuration() {
		return duration;
	}
	public void setDuration(long[] duration) {
		this.duration = duration;
	}
	public int getRunningStatus() {
		return runningStatus;
	}
	public void setRunningStatus(int runningStatus) {
		this.runningStatus = runningStatus;
	}
	public int getFreeCaMode() {
		return freeCaMode;
	}
	public void setFreeCaMode(int freeCaMode) {
		this.freeCaMode = freeCaMode;
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
}
