package com.alex.ts_parser.utils;

public class CTypeFormat2JavaType {
	// ��int����ת��Ϊ0~4294967295 (0xFFFFFFFF��DWORD)��ss
	public static long getUnsignedInt2Long(int data) {
		return data & 0x0FFFFFFFFl;
	}

	// ��int��������ת��Ϊ0~4294967295 (0xFFFFFFFF��DWORD)���顣
	public static long[] getUnsignedIntArray2LongArray(int[] dataArray) {
		long[] rtnDataArray = new long[dataArray.length];
		for (int i = 0; i < dataArray.length; i++) {
			rtnDataArray[i] = getUnsignedInt2Long(dataArray[i]);
		}
		return rtnDataArray;
	}
}
