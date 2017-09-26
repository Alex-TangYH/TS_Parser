package com.alex.ts_parser.bean.descriptor;

public class ContentInfo {
	private int contentNibbleLevel1;
	private int contentNibbleLevel2;
	private int userByte;
	public ContentInfo(int contentNibbleLevel1, int contentNibbleLevel2, int userByte) {
		super();
		this.contentNibbleLevel1 = contentNibbleLevel1;
		this.contentNibbleLevel2 = contentNibbleLevel2;
		this.userByte = userByte;
	}
	public int getContentNibbleLevel1() {
		return contentNibbleLevel1;
	}
	public void setContentNibbleLevel1(int contentNibbleLevel1) {
		this.contentNibbleLevel1 = contentNibbleLevel1;
	}
	public int getContentNibbleLevel2() {
		return contentNibbleLevel2;
	}
	public void setContentNibbleLevel2(int contentNibbleLevel2) {
		this.contentNibbleLevel2 = contentNibbleLevel2;
	}
	public int getUserByte() {
		return userByte;
	}
	public void setUserByte(int userByte) {
		this.userByte = userByte;
	}
}
