package com.alex.ts_parser.utils;

public class TS_Utils {
	public static boolean isTsFile(String fileName) {
		if (fileName.substring(fileName.length() - 3).equals(".TS")
				|| fileName.substring(fileName.length() - 3).equals(".ts")) {
			return true;
		} else {
			return false;
		}
	}
}
