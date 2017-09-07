package com.alex.ts_parser.bean.descriptor;

public class BouquetNameDescriptor extends Descriptor {
	private byte[] bouquetNameDescriptorInfo;

	public BouquetNameDescriptor(int descriptorTag, int descriptorLength, byte[] bouquetNameDescriptorInfo) {
		super(descriptorTag, descriptorLength);
		this.bouquetNameDescriptorInfo = bouquetNameDescriptorInfo;
	}

	public byte[] getBouquetNameDescriptorInfo() {
		return bouquetNameDescriptorInfo;
	}

	public void setBouquetNameDescriptorInfo(byte[] bouquetNameDescriptorInfo) {
		this.bouquetNameDescriptorInfo = bouquetNameDescriptorInfo;
	}
	
	
}
