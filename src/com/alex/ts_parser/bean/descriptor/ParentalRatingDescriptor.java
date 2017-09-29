package com.alex.ts_parser.bean.descriptor;

public class ParentalRatingDescriptor extends Descriptor {
	private ParentalRatingInfo[] parentalRatingInfoArray;

	public ParentalRatingDescriptor(int descriptorTag, int descriptorLength,
			ParentalRatingInfo[] parentalRatingInfoArray) {
		super(descriptorTag, descriptorLength);
		this.parentalRatingInfoArray = parentalRatingInfoArray;
	}

	public ParentalRatingInfo[] getParentalRatingInfoArray() {
		return parentalRatingInfoArray;
	}

	public void setParentalRatingInfoArray(ParentalRatingInfo[] parentalRatingInfoArray) {
		this.parentalRatingInfoArray = parentalRatingInfoArray;
	}
}

