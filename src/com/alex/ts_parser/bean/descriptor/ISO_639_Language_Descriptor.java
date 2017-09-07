package com.alex.ts_parser.bean.descriptor;

public class ISO_639_Language_Descriptor extends Descriptor {
	private ISO_639_LanguageCode iso_639_LanguageCode;
	private int audioType;
	public ISO_639_Language_Descriptor(int descriptorTag, int descriptorLength,
			ISO_639_LanguageCode iso_639_LanguageCode, int audioType) {
		super(descriptorTag, descriptorLength);
		this.iso_639_LanguageCode = iso_639_LanguageCode;
		this.audioType = audioType;
	}
	public ISO_639_LanguageCode getIso_639_LanguageCode() {
		return iso_639_LanguageCode;
	}
	public void setIso_639_LanguageCode(ISO_639_LanguageCode iso_639_LanguageCode) {
		this.iso_639_LanguageCode = iso_639_LanguageCode;
	}
	public int getAudioType() {
		return audioType;
	}
	public void setAudioType(int audioType) {
		this.audioType = audioType;
	}
	
}
