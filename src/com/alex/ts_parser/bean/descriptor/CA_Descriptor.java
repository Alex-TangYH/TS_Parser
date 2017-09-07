package com.alex.ts_parser.bean.descriptor;

/**
 * CAÃèÊö·û
 * 
 * @author Administrator
 *
 */
public class CA_Descriptor extends Descriptor {
	private int caSystemId;
	private int reserved;
	private int caPID;
	private byte privateDataByte[];

	public CA_Descriptor(int descriptorTag, int descriptorLength) {
		super(descriptorTag, descriptorLength);
	}

	public CA_Descriptor(int descriptorTag, int descriptorLength, int caSystemId, int reserved, int caPID,
			byte[] privateDataByte) {
		super(descriptorTag, descriptorLength);
		this.caSystemId = caSystemId;
		this.reserved = reserved;
		this.caPID = caPID;
		this.privateDataByte = privateDataByte;
	}

	public int getCaSystemId() {
		return caSystemId;
	}

	public void setCaSystemId(int caSystemId) {
		this.caSystemId = caSystemId;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public int getCaPID() {
		return caPID;
	}

	public void setCaPID(int caPID) {
		this.caPID = caPID;
	}

	public byte[] getPrivateDataByte() {
		return privateDataByte;
	}

	public void setPrivateDataByte(byte[] privateDataByte) {
		this.privateDataByte = privateDataByte;
	}
	
}
