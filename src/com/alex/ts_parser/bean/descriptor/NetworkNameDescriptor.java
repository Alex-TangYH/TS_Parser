package com.alex.ts_parser.bean.descriptor;

public class NetworkNameDescriptor extends Descriptor {
	private byte[] networkNameDescriptorInfo;

	public NetworkNameDescriptor(int descriptorTag, int descriptorLength, byte[] networkNameDescriptorInfo) {
		super(descriptorTag, descriptorLength);
		this.networkNameDescriptorInfo = networkNameDescriptorInfo;
	}

	public byte[] getNetworkNameDescriptorInfo() {
		return networkNameDescriptorInfo;
	}

	public void setNetworkNameDescriptorInfo(byte[] networkNameDescriptorInfo) {
		this.networkNameDescriptorInfo = networkNameDescriptorInfo;
	}
	
}
