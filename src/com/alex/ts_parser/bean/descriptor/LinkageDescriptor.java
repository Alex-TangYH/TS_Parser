package com.alex.ts_parser.bean.descriptor;

public class LinkageDescriptor extends Descriptor {
	private int transportStreamId;
	private int originalNetworkId;
	private int serviceId;
	private int linageType;
	private byte[] privateDataArray;
	
	private int handOverType;
	private int reservedFutureUse;
	private int originType;
	private int networkId;
	private int initialServiceId;

	private int targetEventId;
	private int targetListed;
	private int eventSimulcast;
	private int reserved;
	
	public LinkageDescriptor(int descriptorTag, int descriptorLength, int transportStreamId, int originalNetworkId,
			int serviceId, int linageType, byte[] privateDataArray) {
		super(descriptorTag, descriptorLength);
		this.transportStreamId = transportStreamId;
		this.originalNetworkId = originalNetworkId;
		this.serviceId = serviceId;
		this.linageType = linageType;
		this.privateDataArray = privateDataArray;
	}

	public LinkageDescriptor(int descriptorTag, int descriptorLength, int transportStreamId, int originalNetworkId,
			int serviceId, int linageType, int targetEventId, int targetListed, int eventSimulcast, int reserved,
			byte[] privateDataArray) {
		super(descriptorTag, descriptorLength);
		this.transportStreamId = transportStreamId;
		this.originalNetworkId = originalNetworkId;
		this.serviceId = serviceId;
		this.linageType = linageType;
		this.targetEventId = targetEventId;
		this.targetListed = targetListed;
		this.eventSimulcast = eventSimulcast;
		this.reserved = reserved;
		this.privateDataArray = privateDataArray;
	}

	public LinkageDescriptor(int descriptorTag, int descriptorLength, int transportStreamId, int originalNetworkId,
			int serviceId, int linageType, int handOverType, int reservedFutureUse, int originType, int networkId,
			int initialServiceId, byte[] privateDataArray) {
		super(descriptorTag, descriptorLength);
		this.transportStreamId = transportStreamId;
		this.originalNetworkId = originalNetworkId;
		this.serviceId = serviceId;
		this.linageType = linageType;
		this.handOverType = handOverType;
		this.reservedFutureUse = reservedFutureUse;
		this.originType = originType;
		this.networkId = networkId;
		this.initialServiceId = initialServiceId;
		this.privateDataArray = privateDataArray;
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

	public int getLinageType() {
		return linageType;
	}

	public void setLinageType(int linageType) {
		this.linageType = linageType;
	}

	public int getHandOverType() {
		return handOverType;
	}

	public void setHandOverType(int handOverType) {
		this.handOverType = handOverType;
	}

	public int getReservedFutureUse() {
		return reservedFutureUse;
	}

	public void setReservedFutureUse(int reservedFutureUse) {
		this.reservedFutureUse = reservedFutureUse;
	}

	public int getOriginType() {
		return originType;
	}

	public void setOriginType(int originType) {
		this.originType = originType;
	}

	public int getNetworkId() {
		return networkId;
	}

	public void setNetworkId(int networkId) {
		this.networkId = networkId;
	}

	public int getInitialServiceId() {
		return initialServiceId;
	}

	public void setInitialServiceId(int initialServiceId) {
		this.initialServiceId = initialServiceId;
	}

	public int getTargetEventId() {
		return targetEventId;
	}

	public void setTargetEventId(int targetEventId) {
		this.targetEventId = targetEventId;
	}

	public int getTargetListed() {
		return targetListed;
	}

	public void setTargetListed(int targetListed) {
		this.targetListed = targetListed;
	}

	public int getEventSimulcast() {
		return eventSimulcast;
	}

	public void setEventSimulcast(int eventSimulcast) {
		this.eventSimulcast = eventSimulcast;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public byte[] getPrivateDataArray() {
		return privateDataArray;
	}

	public void setPrivateDataArray(byte[] privateDataArray) {
		this.privateDataArray = privateDataArray;
	}
	
	
}
