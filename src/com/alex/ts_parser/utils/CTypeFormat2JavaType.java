package com.alex.ts_parser.utils;

public class CTypeFormat2JavaType {
	public static long getUnsignedInt2Long(int data) { // ��int����ת��Ϊ0~4294967295 (0xFFFFFFFF��DWORD)��
		return data & 0x0FFFFFFFFl;
	}
}
