package com.alex.ts_parser.bean.descriptor;

public class ServiceDescriptor extends Descriptor {
	private int serviceType;
	private int serviceProviderNameLength;
	private byte[] serviceProviderName;
	private int serviceNameLength;
	private byte[] serviceName;
	public ServiceDescriptor(int descriptorTag, int descriptorLength, int serviceType, int serviceProviderNameLength,
			byte[] serviceProviderName, int serviceNameLength, byte[] serviceName) {
		super(descriptorTag, descriptorLength);
		this.serviceType = serviceType;
		this.serviceProviderNameLength = serviceProviderNameLength;
		this.serviceProviderName = serviceProviderName;
		this.serviceNameLength = serviceNameLength;
		this.serviceName = serviceName;
	}
	public int getServiceType() {
		return serviceType;
	}
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}
	public int getServiceProviderNameLength() {
		return serviceProviderNameLength;
	}
	public void setServiceProviderNameLength(int serviceProviderNameLength) {
		this.serviceProviderNameLength = serviceProviderNameLength;
	}
	public byte[] getServiceProviderName() {
		return serviceProviderName;
	}
	public void setServiceProviderName(byte[] serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	public int getServiceNameLength() {
		return serviceNameLength;
	}
	public void setServiceNameLength(int serviceNameLength) {
		this.serviceNameLength = serviceNameLength;
	}
	public byte[] getServiceName() {
		return serviceName;
	}
	public void setServiceName(byte[] serviceName) {
		this.serviceName = serviceName;
	}
	
	
}
