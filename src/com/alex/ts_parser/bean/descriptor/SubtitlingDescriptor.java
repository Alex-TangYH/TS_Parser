package com.alex.ts_parser.bean.descriptor;

public class SubtitlingDescriptor extends Descriptor {
	private SubtitlingInfo[] subtitlingInfo;

	public SubtitlingDescriptor(int descriptorTag, int descriptorLength, SubtitlingInfo[] subtitlingInfo) {
		super(descriptorTag, descriptorLength);
		this.subtitlingInfo = subtitlingInfo;
	}

	public SubtitlingInfo[] getSubtitlingInfo() {
		return subtitlingInfo;
	}

	public void setSubtitlingInfo(SubtitlingInfo[] subtitlingInfo) {
		this.subtitlingInfo = subtitlingInfo;
	}

}

class SubtitlingInfo {
	private ISO_639_LanguageCode iso_639_LanguageCode;
	private int subtitlingType;
	private int compositionPageId;
	private int ancillaryPageId;

	public SubtitlingInfo(ISO_639_LanguageCode iso_639_LanguageCode, int subtitlingType, int compositionPageId,
			int ancillaryPageId) {
		super();
		this.iso_639_LanguageCode = iso_639_LanguageCode;
		this.subtitlingType = subtitlingType;
		this.compositionPageId = compositionPageId;
		this.ancillaryPageId = ancillaryPageId;
	}

	public ISO_639_LanguageCode getIso_639_LanguageCode() {
		return iso_639_LanguageCode;
	}

	public void setIso_639_LanguageCode(ISO_639_LanguageCode iso_639_LanguageCode) {
		this.iso_639_LanguageCode = iso_639_LanguageCode;
	}

	public int getSubtitlingType() {
		return subtitlingType;
	}

	public void setSubtitlingType(int subtitlingType) {
		this.subtitlingType = subtitlingType;
	}

	public int getCompositionPageId() {
		return compositionPageId;
	}

	public void setCompositionPageId(int compositionPageId) {
		this.compositionPageId = compositionPageId;
	}

	public int getAncillaryPageId() {
		return ancillaryPageId;
	}

	public void setAncillaryPageId(int ancillaryPageId) {
		this.ancillaryPageId = ancillaryPageId;
	}

}