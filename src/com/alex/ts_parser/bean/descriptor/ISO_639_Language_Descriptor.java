package com.alex.ts_parser.bean.descriptor;

public class ISO_639_Language_Descriptor extends Descriptor {
	private ISO_639_LanguageCode[] iso_639_LanguageCodeArray;
	private int audioType;
	public ISO_639_Language_Descriptor(int descriptorTag, int descriptorLength,
			ISO_639_LanguageCode[] iso_639_LanguageCodeArray, int audioType) {
		super(descriptorTag, descriptorLength);
		this.iso_639_LanguageCodeArray = iso_639_LanguageCodeArray;
		this.audioType = audioType;
	}
	public ISO_639_LanguageCode[] getIso_639_LanguageCodeArray() {
		return iso_639_LanguageCodeArray;
	}
	public void setIso_639_LanguageCodeArray(ISO_639_LanguageCode[] iso_639_LanguageCodeArray) {
		this.iso_639_LanguageCodeArray = iso_639_LanguageCodeArray;
	}
	public int getAudioType() {
		return audioType;
	}
	public void setAudioType(int audioType) {
		this.audioType = audioType;
	}
	
}
