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

class ParentalRatingInfo {
	private int countryCode;
	private int rating;
	public ParentalRatingInfo(int countryCode, int rating) {
		super();
		this.countryCode = countryCode;
		this.rating = rating;
	}
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
