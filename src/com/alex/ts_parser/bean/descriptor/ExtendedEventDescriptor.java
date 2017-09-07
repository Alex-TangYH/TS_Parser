package com.alex.ts_parser.bean.descriptor;

public class ExtendedEventDescriptor extends Descriptor {
	private int descriptorNumber;
	private int lastDescriptorNumber;
	private ISO_639_LanguageCode iso_639_LanguageCode;
	private int lengthOfItems;
	private ExtendedEventInfo[] extendedEventInfoArray;
	private int textLength;
	private byte[] textChar;

	public ExtendedEventDescriptor(int descriptorTag, int descriptorLength, int descriptorNumber,
			int lastDescriptorNumber, ISO_639_LanguageCode iso_639_LanguageCode, int lengthOfItems,
			ExtendedEventInfo[] extendedEventInfoArray, int textLength, byte[] textChar) {
		super(descriptorTag, descriptorLength);
		this.descriptorNumber = descriptorNumber;
		this.lastDescriptorNumber = lastDescriptorNumber;
		this.iso_639_LanguageCode = iso_639_LanguageCode;
		this.lengthOfItems = lengthOfItems;
		this.extendedEventInfoArray = extendedEventInfoArray;
		this.textLength = textLength;
		this.textChar = textChar;
	}

	public int getDescriptorNumber() {
		return descriptorNumber;
	}

	public void setDescriptorNumber(int descriptorNumber) {
		this.descriptorNumber = descriptorNumber;
	}

	public int getLastDescriptorNumber() {
		return lastDescriptorNumber;
	}

	public void setLastDescriptorNumber(int lastDescriptorNumber) {
		this.lastDescriptorNumber = lastDescriptorNumber;
	}

	public ISO_639_LanguageCode getIso_639_LanguageCode() {
		return iso_639_LanguageCode;
	}

	public void setIso_639_LanguageCode(ISO_639_LanguageCode iso_639_LanguageCode) {
		this.iso_639_LanguageCode = iso_639_LanguageCode;
	}

	public int getLengthOfItems() {
		return lengthOfItems;
	}

	public void setLengthOfItems(int lengthOfItems) {
		this.lengthOfItems = lengthOfItems;
	}

	public ExtendedEventInfo[] getExtendedEventInfoArray() {
		return extendedEventInfoArray;
	}

	public void setExtendedEventInfoArray(ExtendedEventInfo[] extendedEventInfoArray) {
		this.extendedEventInfoArray = extendedEventInfoArray;
	}

	public int getTextLength() {
		return textLength;
	}

	public void setTextLength(int textLength) {
		this.textLength = textLength;
	}

	public byte[] getTextChar() {
		return textChar;
	}

	public void setTextChar(byte[] textChar) {
		this.textChar = textChar;
	}

}

class ExtendedEventInfo {
	private int itemDescriptorLength;
	private byte[] itemDescriptorChar;
	private int itemLength;
	private byte[] itemChar;

	public ExtendedEventInfo(int itemDescriptorLength, byte[] itemDescriptorChar, int itemLength, byte[] itemChar) {
		super();
		this.itemDescriptorLength = itemDescriptorLength;
		this.itemDescriptorChar = itemDescriptorChar;
		this.itemLength = itemLength;
		this.itemChar = itemChar;
	}

	public int getItemDescriptorLength() {
		return itemDescriptorLength;
	}

	public void setItemDescriptorLength(int itemDescriptorLength) {
		this.itemDescriptorLength = itemDescriptorLength;
	}

	public byte[] getItemDescriptorChar() {
		return itemDescriptorChar;
	}

	public void setItemDescriptorChar(byte[] itemDescriptorChar) {
		this.itemDescriptorChar = itemDescriptorChar;
	}

	public int getItemLength() {
		return itemLength;
	}

	public void setItemLength(int itemLength) {
		this.itemLength = itemLength;
	}

	public byte[] getItemChar() {
		return itemChar;
	}

	public void setItemChar(byte[] itemChar) {
		this.itemChar = itemChar;
	}

}
