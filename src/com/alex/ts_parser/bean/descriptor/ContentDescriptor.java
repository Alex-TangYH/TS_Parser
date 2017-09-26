package com.alex.ts_parser.bean.descriptor;

public class ContentDescriptor extends Descriptor {
	private ContentInfo[] contentInfoArray;

	public ContentDescriptor(int descriptorTag, int descriptorLength, ContentInfo[] contentInfoArray) {
		super(descriptorTag, descriptorLength);
		this.contentInfoArray = contentInfoArray;
	}

	public ContentInfo[] getContentInfoArray() {
		return contentInfoArray;
	}

	public void setContentInfoArray(ContentInfo[] contentInfoArray) {
		this.contentInfoArray = contentInfoArray;
	}
	
}

