package com.alex.ts_parser.bean.descriptor;

public class TeletextDescriptor extends Descriptor {
	private TeletextInfo[] teletextInfoArray;

	public TeletextDescriptor(int descriptorTag, int descriptorLength, TeletextInfo[] teletextInfoArray) {
		super(descriptorTag, descriptorLength);
		this.teletextInfoArray = teletextInfoArray;
	}

	public TeletextInfo[] getTeletextInfo() {
		return teletextInfoArray;
	}

	public void setTeletextInfo(TeletextInfo[] teletextInfoArray) {
		this.teletextInfoArray = teletextInfoArray;
	}
	
}

class TeletextInfo {
	private ISO_639_LanguageCode iso_639_LanguageCode;
	private int teletextType;
	private int teletextMagazineNumber;
	private int teletextPageNumber;
	public TeletextInfo(ISO_639_LanguageCode iso_639_LanguageCode, int teletextType, int teletextMagazineNumber,
			int teletextPageNumber) {
		super();
		this.iso_639_LanguageCode = iso_639_LanguageCode;
		this.teletextType = teletextType;
		this.teletextMagazineNumber = teletextMagazineNumber;
		this.teletextPageNumber = teletextPageNumber;
	}
	public ISO_639_LanguageCode getIso_639_LanguageCode() {
		return iso_639_LanguageCode;
	}
	public void setIso_639_LanguageCode(ISO_639_LanguageCode iso_639_LanguageCode) {
		this.iso_639_LanguageCode = iso_639_LanguageCode;
	}
	public int getTeletextType() {
		return teletextType;
	}
	public void setTeletextType(int teletextType) {
		this.teletextType = teletextType;
	}
	public int getTeletextMagazineNumber() {
		return teletextMagazineNumber;
	}
	public void setTeletextMagazineNumber(int teletextMagazineNumber) {
		this.teletextMagazineNumber = teletextMagazineNumber;
	}
	public int getTeletextPageNumber() {
		return teletextPageNumber;
	}
	public void setTeletextPageNumber(int teletextPageNumber) {
		this.teletextPageNumber = teletextPageNumber;
	}
}
