package com.alex.ts_parser.bean.si;

import com.alex.ts_parser.bean.descriptor.Descriptor;
import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class SDT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int reservedFutureUseFirst;
	private int reservedFirst;
	private int sectionLength;
	private int transportStreamId;
	private int reservedSecond;
	private int versionNumber;
	private int currentNextIndicator;
	private int sectionNumber;
	private int lastSectionNumber;
	private int originalNetworkId;
	private int reservedFutureUseSecond;
	private SdtInfo[] sdtInfoArray;
	private long crc32;

	public SDT_Table(int tableId, int sectionSyntaxIndicator, int reservedFutureUseFirst, int reservedFirst,
			int sectionLength, int transportStreamId, int reservedSecond, int versionNumber, int currentNextIndicator,
			int sectionNumber, int lastSectionNumber, int originalNetworkId, int reservedFutureUseSecond,
			SdtInfo[] sdtInfoArray, int crc32) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.reservedFutureUseFirst = reservedFutureUseFirst;
		this.reservedFirst = reservedFirst;
		this.sectionLength = sectionLength;
		this.transportStreamId = transportStreamId;
		this.reservedSecond = reservedSecond;
		this.versionNumber = versionNumber;
		this.currentNextIndicator = currentNextIndicator;
		this.sectionNumber = sectionNumber;
		this.lastSectionNumber = lastSectionNumber;
		this.originalNetworkId = originalNetworkId;
		this.reservedFutureUseSecond = reservedFutureUseSecond;
		this.sdtInfoArray = sdtInfoArray;
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

	public int getOriginalNetworkId() {
		return originalNetworkId;
	}

	public void setOriginalNetworkId(int originalNetworkId) {
		this.originalNetworkId = originalNetworkId;
	}

	public int getReservedFutureUseSecond() {
		return reservedFutureUseSecond;
	}

	public void setReservedFutureUseSecond(int reservedFutureUseSecond) {
		this.reservedFutureUseSecond = reservedFutureUseSecond;
	}

	public SdtInfo[] getSdtInfoArray() {
		return sdtInfoArray;
	}

	public void setSdtInfoArray(SdtInfo[] sdtInfoArray) {
		this.sdtInfoArray = sdtInfoArray;
	}

	public long getCrc32() {
		return crc32;
	}

	public void setCrc32(long crc32) {
		this.crc32 = crc32;
	}

}

class SdtInfo {
	private int serviceId;
	private int reservedFutureUse;
	private int eitScheduleFlag;
	private int eitPresentFollowingFlag;
	private int runningStatus;
	private int freeCaMode;
	private int descriptorLoopLength;
	private Descriptor[] descriptorArray;
	public SdtInfo(int serviceId, int reservedFutureUse, int eitScheduleFlag, int eitPresentFollowingFlag,
			int runningStatus, int freeCaMode, int descriptorLoopLength, Descriptor[] descriptorArray) {
		super();
		this.serviceId = serviceId;
		this.reservedFutureUse = reservedFutureUse;
		this.eitScheduleFlag = eitScheduleFlag;
		this.eitPresentFollowingFlag = eitPresentFollowingFlag;
		this.runningStatus = runningStatus;
		this.freeCaMode = freeCaMode;
		this.descriptorLoopLength = descriptorLoopLength;
		this.descriptorArray = descriptorArray;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public int getReservedFutureUse() {
		return reservedFutureUse;
	}
	public void setReservedFutureUse(int reservedFutureUse) {
		this.reservedFutureUse = reservedFutureUse;
	}
	public int getEitScheduleFlag() {
		return eitScheduleFlag;
	}
	public void setEitScheduleFlag(int eitScheduleFlag) {
		this.eitScheduleFlag = eitScheduleFlag;
	}
	public int getEitPresentFollowingFlag() {
		return eitPresentFollowingFlag;
	}
	public void setEitPresentFollowingFlag(int eitPresentFollowingFlag) {
		this.eitPresentFollowingFlag = eitPresentFollowingFlag;
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
	public int getDescriptorLoopLength() {
		return descriptorLoopLength;
	}
	public void setDescriptorLoopLength(int descriptorLoopLength) {
		this.descriptorLoopLength = descriptorLoopLength;
	}
	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}
	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}
	
}
