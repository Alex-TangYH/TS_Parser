package com.alex.ts_parser.bean.descriptor;

public class BouquetNameDescriptor extends Descriptor {
	private byte[] bouquetName;

	public BouquetNameDescriptor(int descriptorTag, int descriptorLength, byte[] bouquetName) {
		super(descriptorTag, descriptorLength);
		this.bouquetName = bouquetName;
	}

	public byte[] getBouquetNameDescriptorInfo() {
		return bouquetName;
	}

	public void setBouquetNameDescriptorInfo(byte[] bouquetName) {
		this.bouquetName = bouquetName;
	}
	
	
}
