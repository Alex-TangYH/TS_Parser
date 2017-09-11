package com.alex.ts_parser.bean.psi;

import com.alex.ts_parser.bean.descriptor.Descriptor;
import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class NIT_Table {
	private int tableId;
	private int sectionSyntaxIndicator;
	private int reservedFutureUseFirst;
	private int reservedFirst;
	private int sectionLength;
	private int networkId;
	private int reservedsSecond;
	private int versionNumber;
	private int currentNextIndicator;
	private int sectionNumber;
	private int lastSectionNumber;
	private int reservedFutureUseSecond;
	private int networkDescriptorLength;
	private Descriptor[] descriptorArray;
	private int reservedFutureUseThird;
	private int transportStreamLoopLength;
	private TransportStreamDsecriptor[] transportStreamDsecriptorArray;
	private long crc32;

	public NIT_Table(int tableId, int sectionSyntaxIndicator, int reservedFutureUseFirst, int reservedFirst,
			int sectionLength, int networkId, int reservedsSecond, int versionNumber, int currentNextIndicator,
			int sectionNumber, int lastSectionNumber, int reservedFutureUseSecond, int networkDescriptorLength,
			Descriptor[] descriptorArray, int reservedFutureUseThird, int transportStreamLoopLength,
			TransportStreamDsecriptor[] transportStreamDsecriptorArray, int crc32) {
		super();
		this.tableId = tableId;
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
		this.reservedFutureUseFirst = reservedFutureUseFirst;
		this.reservedFirst = reservedFirst;
		this.sectionLength = sectionLength;
		this.networkId = networkId;
		this.reservedsSecond = reservedsSecond;
		this.versionNumber = versionNumber;
		this.currentNextIndicator = currentNextIndicator;
		this.sectionNumber = sectionNumber;
		this.lastSectionNumber = lastSectionNumber;
		this.reservedFutureUseSecond = reservedFutureUseSecond;
		this.networkDescriptorLength = networkDescriptorLength;
		this.descriptorArray = descriptorArray;
		this.reservedFutureUseThird = reservedFutureUseThird;
		this.transportStreamLoopLength = transportStreamLoopLength;
		this.transportStreamDsecriptorArray = transportStreamDsecriptorArray;
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

	public int getNetworkId() {
		return networkId;
	}

	public void setNetworkId(int networkId) {
		this.networkId = networkId;
	}

	public int getReservedsSecond() {
		return reservedsSecond;
	}

	public void setReservedsSecond(int reservedsSecond) {
		this.reservedsSecond = reservedsSecond;
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

	public int getNetworkDescriptorLength() {
		return networkDescriptorLength;
	}

	public void setNetworkDescriptorLength(int networkDescriptorLength) {
		this.networkDescriptorLength = networkDescriptorLength;
	}

	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}

	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}

	public int getReservedFutureUseThird() {
		return reservedFutureUseThird;
	}

	public void setReservedFutureUseThird(int reservedFutureUseThird) {
		this.reservedFutureUseThird = reservedFutureUseThird;
	}

	public int getTransportStreamLoopLength() {
		return transportStreamLoopLength;
	}

	public void setTransportStreamLoopLength(int transportStreamLoopLength) {
		this.transportStreamLoopLength = transportStreamLoopLength;
	}

	public TransportStreamDsecriptor[] getNIT_StreamInfoArray() {
		return transportStreamDsecriptorArray;
	}

	public void setNIT_StreamInfoArray(TransportStreamDsecriptor[] transportStreamDsecriptorArray) {
		this.transportStreamDsecriptorArray = transportStreamDsecriptorArray;
	}

	public long getCrc32() {
		return crc32;
	}

	public void setCrc32(long crc32) {
		this.crc32 = crc32;
	}
}

class TransportStreamDsecriptor {
	private int transportStreamId;
	private int originalNetworkId;
	private int reservedFutureUse;
	private int transportDescriportLength;
	private Descriptor[] descriptorArray;
	public TransportStreamDsecriptor(int transportStreamId, int originalNetworkId, int reservedFutureUse,
			int transportDescriportLength, Descriptor[] descriptorArray) {
		super();
		this.transportStreamId = transportStreamId;
		this.originalNetworkId = originalNetworkId;
		this.reservedFutureUse = reservedFutureUse;
		this.transportDescriportLength = transportDescriportLength;
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
	public int getTransportDescriportLength() {
		return transportDescriportLength;
	}
	public void setTransportDescriportLength(int transportDescriportLength) {
		this.transportDescriportLength = transportDescriportLength;
	}
	public Descriptor[] getDescriptorArray() {
		return descriptorArray;
	}
	public void setDescriptorArray(Descriptor[] descriptorArray) {
		this.descriptorArray = descriptorArray;
	}
}