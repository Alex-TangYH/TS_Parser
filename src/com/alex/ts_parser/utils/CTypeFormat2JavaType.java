package com.alex.ts_parser.utils;

public class CTypeFormat2JavaType {
	public static long getUnsignedInt2Long(int data) { // 将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)。
		return data & 0x0FFFFFFFFl;
	}
}
