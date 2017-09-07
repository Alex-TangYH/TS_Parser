package com.alex.ts_parser.bean.descriptor;

public class ISO_639_LanguageCode {
	private byte[] privateDateByte;

	public byte[] getPrivateDateByte() {
		return privateDateByte;
	}

	public void setPrivateDateByte(byte[] privateDateByte) {
		this.privateDateByte = privateDateByte;
	}

	public ISO_639_LanguageCode(byte[] privateDateByte) {
		super();
		this.privateDateByte = privateDateByte;
	}
	
}
