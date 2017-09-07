package com.alex.ts_parser.bean.descriptor;

public class ShortEventDescriptor extends Descriptor {
	private ISO_639_LanguageCode iso_639_LanguageCode;
	private int eventNameLength;
	private byte[] eventNameChar;
	private int textLength;
	private byte[] textChar;
	public ShortEventDescriptor(int descriptorTag, int descriptorLength, ISO_639_LanguageCode iso_639_LanguageCode,
			int eventNameLength, byte[] eventNameChar, int textLength, byte[] textChar) {
		super(descriptorTag, descriptorLength);
		this.iso_639_LanguageCode = iso_639_LanguageCode;
		this.eventNameLength = eventNameLength;
		this.eventNameChar = eventNameChar;
		this.textLength = textLength;
		this.textChar = textChar;
	}
	public ISO_639_LanguageCode getIso_639_LanguageCode() {
		return iso_639_LanguageCode;
	}
	public void setIso_639_LanguageCode(ISO_639_LanguageCode iso_639_LanguageCode) {
		this.iso_639_LanguageCode = iso_639_LanguageCode;
	}
	public int getEventNameLength() {
		return eventNameLength;
	}
	public void setEventNameLength(int eventNameLength) {
		this.eventNameLength = eventNameLength;
	}
	public byte[] getEventNameChar() {
		return eventNameChar;
	}
	public void setEventNameChar(byte[] eventNameChar) {
		this.eventNameChar = eventNameChar;
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
