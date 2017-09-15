package com.alex.ts_parser.bean.si;

import com.alex.ts_parser.bean.descriptor.Descriptor;

public class SIT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int dvbReservedFutureUseFirst;
	private int isoReservedFirst;
	private int sectionLength;
	private int dvbReservedFutureUseSecond;
	private int isoReservedSecond;
	private int versionNumber;
	private int currentNextIndicator;
	private int sectionNumber;
	private int lastSectionNumber;
	private int dvbReservedFutureUseThird;
	private int transmissionInfoLoopLength;
	private Descriptor[] descriptorArray;
	private SitInfo[] sitInfoArray;
	private int crc32;
	public SIT_Table(int tableId, int sectionSyntaxIndicator, int dvbReservedFutureUseFirst, int isoReservedFirst,
			int sectionLength, int dvbReservedFutureUseSecond, int isoReservedSecond, int versionNumber,
			int currentNextIndicator, int sectionNumber, int lastSectionNumber, int dvbReservedFutureUseThird,
			int transmissionInfoLoopLength, Descriptor[] descriptorArray, SitInfo[] sitInfoArray, int crc32) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.dvbReservedFutureUseFirst = dvbReservedFutureUseFirst;
		this.isoReservedFirst = isoReservedFirst;
		this.sectionLength = sectionLength;
		this.dvbReservedFutureUseSecond = dvbReservedFutureUseSecond;
		this.isoReservedSecond = isoReservedSecond;
		this.versionNumber = versionNumber;
		this.currentNextIndicator = currentNextIndicator;
		this.sectionNumber = sectionNumber;
		this.lastSectionNumber = lastSectionNumber;
		this.dvbReservedFutureUseThird = dvbReservedFutureUseThird;
		this.transmissionInfoLoopLength = transmissionInfoLoopLength;
		this.descriptorArray = descriptorArray;
		this.sitInfoArray = sitInfoArray;
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
	public int getDvbReservedFutureUseFirst() {
		return dvbReservedFutureUseFirst;
	}
	public void setDvbReservedFutureUseFirst(int dvbReservedFutureUseFirst) {
		this.dvbReservedFutureUseFirst = dvbReservedFutureUseFirst;
	}
	public int getIsoReservedFirst() {
		return isoReservedFirst;
	}
	public void setIsoReservedFirst(int isoReservedFirst) {
		this.isoReservedFirst = isoReservedFirst;
	}
	public int getSectionLength() {
		return sectionLength;
	}
	public void setSectionLength(int sectionLength) {
		this.sectionLength = sectionLength;
	}
	public int getDvbReservedFutureUseSecond() {
		return dvbReservedFutureUseSecond;
	}
	public void setDvbReservedFutureUseSecond(int dvbReservedFutureUseSecond) {
		this.dvbReservedFutureUseSecond = dvbReservedFutureUseSecond;
	}
	public int getIsoReservedSecond() {
		return isoReservedSecond;
	}
	public void setIsoReservedSecond(int isoReservedSecond) {
		this.isoReservedSecond = isoReservedSecond;
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
	public int getDvbReservedFutureUseThird() {
		return dvbReservedFutureUseThird;
	}
	public void setDvbReservedFutureUseThird(int dvbReservedFutureUseThird) {
		this.dvbReservedFutureUseThird = dvbReservedFutureUseThird;
	}
	public int getTransmissionInfoLoopLength() {
		return transmissionInfoLoopLength;
	}
	public void setTransmissionInfoLoopLength(int transmissionInfoLoopLength) {
		this.transmissionInfoLoopLength = transmissionInfoLoopLength;
	}
	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}
	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}
	public SitInfo[] getSitInfoArray() {
		return sitInfoArray;
	}
	public void setSitInfoArray(SitInfo[] sitInfoArray) {
		this.sitInfoArray = sitInfoArray;
	}
	public int getCrc32() {
		return crc32;
	}
	public void setCrc32(int crc32) {
		this.crc32 = crc32;
	}
}

class SitInfo{
	private int serviceId;
	private int dvbReservedFutureUse;
	private int runningStatus;
	private int serviceLoopLength;
	private Descriptor[] descriptorArray;
	public SitInfo(int serviceId, int dvbReservedFutureUse, int runningStatus, int serviceLoopLength,
			Descriptor[] descriptorArray) {
		super();
		this.serviceId = serviceId;
		this.dvbReservedFutureUse = dvbReservedFutureUse;
		this.runningStatus = runningStatus;
		this.serviceLoopLength = serviceLoopLength;
		this.descriptorArray = descriptorArray;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public int getDvbReservedFutureUse() {
		return dvbReservedFutureUse;
	}
	public void setDvbReservedFutureUse(int dvbReservedFutureUse) {
		this.dvbReservedFutureUse = dvbReservedFutureUse;
	}
	public int getRunningStatus() {
		return runningStatus;
	}
	public void setRunningStatus(int runningStatus) {
		this.runningStatus = runningStatus;
	}
	public int getServiceLoopLength() {
		return serviceLoopLength;
	}
	public void setServiceLoopLength(int serviceLoopLength) {
		this.serviceLoopLength = serviceLoopLength;
	}
	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}
	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}
}