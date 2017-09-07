package com.alex.ts_parser.bean.descriptor;

public class VideoStreamDescriptor extends Descriptor {
	private int multipleFrameRateFlag;
	private int frameRateCode;
	private int mpeg2Flag;
	private int constrainedParameterFlag;
	private int stillPictureFlag;
	private int profileAndLevelIndication;
	private int chromaFormat;
	private int frameRateExtensionFlag;
	private int reserved;
	public VideoStreamDescriptor(int descriptorTag, int descriptorLength, int multipleFrameRateFlag, int frameRateCode,
			int mpeg2Flag, int constrainedParameterFlag, int stillPictureFlag, int profileAndLevelIndication,
			int chromaFormat, int frameRateExtensionFlag, int reserved) {
		super(descriptorTag, descriptorLength);
		this.multipleFrameRateFlag = multipleFrameRateFlag;
		this.frameRateCode = frameRateCode;
		this.mpeg2Flag = mpeg2Flag;
		this.constrainedParameterFlag = constrainedParameterFlag;
		this.stillPictureFlag = stillPictureFlag;
		this.profileAndLevelIndication = profileAndLevelIndication;
		this.chromaFormat = chromaFormat;
		this.frameRateExtensionFlag = frameRateExtensionFlag;
		this.reserved = reserved;
	}
	public int getMultipleFrameRateFlag() {
		return multipleFrameRateFlag;
	}
	public void setMultipleFrameRateFlag(int multipleFrameRateFlag) {
		this.multipleFrameRateFlag = multipleFrameRateFlag;
	}
	public int getFrameRateCode() {
		return frameRateCode;
	}
	public void setFrameRateCode(int frameRateCode) {
		this.frameRateCode = frameRateCode;
	}
	public int getMpeg2Flag() {
		return mpeg2Flag;
	}
	public void setMpeg2Flag(int mpeg2Flag) {
		this.mpeg2Flag = mpeg2Flag;
	}
	public int getConstrainedParameterFlag() {
		return constrainedParameterFlag;
	}
	public void setConstrainedParameterFlag(int constrainedParameterFlag) {
		this.constrainedParameterFlag = constrainedParameterFlag;
	}
	public int getStillPictureFlag() {
		return stillPictureFlag;
	}
	public void setStillPictureFlag(int stillPictureFlag) {
		this.stillPictureFlag = stillPictureFlag;
	}
	public int getProfileAndLevelIndication() {
		return profileAndLevelIndication;
	}
	public void setProfileAndLevelIndication(int profileAndLevelIndication) {
		this.profileAndLevelIndication = profileAndLevelIndication;
	}
	public int getChromaFormat() {
		return chromaFormat;
	}
	public void setChromaFormat(int chromaFormat) {
		this.chromaFormat = chromaFormat;
	}
	public int getFrameRateExtensionFlag() {
		return frameRateExtensionFlag;
	}
	public void setFrameRateExtensionFlag(int frameRateExtensionFlag) {
		this.frameRateExtensionFlag = frameRateExtensionFlag;
	}
	public int getReserved() {
		return reserved;
	}
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
}
