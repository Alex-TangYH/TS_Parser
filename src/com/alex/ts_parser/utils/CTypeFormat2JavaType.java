package com.alex.ts_parser.utils;

public class CTypeFormat2JavaType {
	// 将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。ss
	public static long getUnsignedInt2Long(int data) {
		return data & 0x0FFFFFFFFl;
	}

	// 将int数据数组转换为0~4294967295 (0xFFFFFFFF即DWORD)数组。
	public static long[] getUnsignedIntArray2LongArray(int[] dataArray) {
		long[] rtnDataArray = new long[dataArray.length];
		for (int i = 0; i < dataArray.length; i++) {
			rtnDataArray[i] = getUnsignedInt2Long(dataArray[i]);
		}
		return rtnDataArray;
	}
}
