package com.alex.ts_parser.bean.descriptor;

public class ComponentDescriptor extends Descriptor {
	private int reservedFutureUse;
	private int streamContent;
	private int componentType;
	private int component_tag;
	private ISO_639_LanguageCode iso639LanguageCode;
	private byte[] text;

	public ComponentDescriptor(int descriptorTag, int descriptorLength, int reservedFutureUse, int streamContent,
			int componentType, int component_tag, ISO_639_LanguageCode iso639LanguageCode, byte[] text) {
		super(descriptorTag, descriptorLength);
		this.reservedFutureUse = reservedFutureUse;
		this.streamContent = streamContent;
		this.componentType = componentType;
		this.component_tag = component_tag;
		this.iso639LanguageCode = iso639LanguageCode;
		this.text = text;
	}

	public int getReservedFutureUse() {
		return reservedFutureUse;
	}

	public void setReservedFutureUse(int reservedFutureUse) {
		this.reservedFutureUse = reservedFutureUse;
	}

	public int getStreamContent() {
		return streamContent;
	}

	public void setStreamContent(int streamContent) {
		this.streamContent = streamContent;
	}

	public int getComponentType() {
		return componentType;
	}

	public void setComponentType(int componentType) {
		this.componentType = componentType;
	}

	public int getComponent_tag() {
		return component_tag;
	}

	public void setComponent_tag(int component_tag) {
		this.component_tag = component_tag;
	}

	public ISO_639_LanguageCode getIso639LanguageCode() {
		return iso639LanguageCode;
	}

	public void setIso639LanguageCode(ISO_639_LanguageCode iso639LanguageCode) {
		this.iso639LanguageCode = iso639LanguageCode;
	}

	public byte[] getText() {
		return text;
	}

	public void setText(byte[] text) {
		this.text = text;
	}
}
