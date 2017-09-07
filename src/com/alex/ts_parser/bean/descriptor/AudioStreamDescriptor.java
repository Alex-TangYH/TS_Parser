package com.alex.ts_parser.bean.descriptor;

public class AudioStreamDescriptor extends Descriptor {
	private int freeFormatFlag;
	private int id;
	private int layer;
	private int reserved;
	public AudioStreamDescriptor(int descriptorTag, int descriptorLength, int freeFormatFlag, int id, int layer,
			int reserved) {
		super(descriptorTag, descriptorLength);
		this.freeFormatFlag = freeFormatFlag;
		this.id = id;
		this.layer = layer;
		this.reserved = reserved;
	}
	public int getFreeFormatFlag() {
		return freeFormatFlag;
	}
	public void setFreeFormatFlag(int freeFormatFlag) {
		this.freeFormatFlag = freeFormatFlag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	public int getReserved() {
		return reserved;
	}
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	
}
