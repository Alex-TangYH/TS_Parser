package com.alex.ts_parser.bean.descriptor;

/**
 * CAÃèÊö·û
 * 
 * @author Administrator
 *
 */
public class CA_Descriptor extends Descriptor {
	int caSystemId;
	int reserved;
	byte privateDataByte[];

	public CA_Descriptor(int descriptorTag, int descriptorLength) {
		super(descriptorTag, descriptorLength);
	}

	public CA_Descriptor(int descriptorTag, int descriptorLength, int caSystemId, int reserved,
			byte[] privateDataByte) {
		super(descriptorTag, descriptorLength);
		this.caSystemId = caSystemId;
		this.reserved = reserved;
		this.privateDataByte = privateDataByte;
	}
}
