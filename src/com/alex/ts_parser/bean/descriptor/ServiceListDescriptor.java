package com.alex.ts_parser.bean.descriptor;

public class ServiceListDescriptor extends Descriptor {
	private ServiceInfo[] serviceInfoArray;

	public ServiceInfo[] getServiceInfoArray() {
		return serviceInfoArray;
	}

	public void setServiceInfoArray(ServiceInfo[] serviceInfoArray) {
		this.serviceInfoArray = serviceInfoArray;
	}

	public ServiceListDescriptor(int descriptorTag, int descriptorLength, ServiceInfo[] serviceInfoArray) {
		super(descriptorTag, descriptorLength);
		this.serviceInfoArray = serviceInfoArray;
	}
}

class ServiceInfo {
	private int serviecId;
	private int serviceType;
	public ServiceInfo(int serviecId, int serviceType) {
		super();
		this.serviecId = serviecId;
		this.serviceType = serviceType;
	}
	public int getServiecId() {
		return serviecId;
	}
	public void setServiecId(int serviecId) {
		this.serviecId = serviecId;
	}
	public int getServiceType() {
		return serviceType;
	}
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}


}