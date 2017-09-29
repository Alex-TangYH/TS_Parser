package com.alex.ts_parser.bean.descriptor;

import com.alex.ts_parser.utils.CTypeFormat2JavaType;

public class ParentalRatingInfo {
	private byte[] countryCode;
	private long rating;
	public ParentalRatingInfo(byte[] countryCode, int rating) {
		super();
		this.countryCode = countryCode;
		this.rating = CTypeFormat2JavaType.getUnsignedInt2Long(rating);
	}
	public byte[] getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(byte[] countryCode) {
		this.countryCode = countryCode;
	}
	public long getRating() {
		return rating;
	}
	public void setRating(long rating) {
		this.rating = rating;
	}
}
