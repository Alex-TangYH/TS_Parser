package com.alex.ts_parser.native_function;

public class NativeFunctionManager {
	native public static int parseTSFileNative(String filePath);

	static {
		System.loadLibrary("libC_ParseTS");
	}

	private static volatile NativeFunctionManager nativeFunctionManager;

	private NativeFunctionManager() {
	}

	public static NativeFunctionManager getNativeFunctionManager() {
		if (nativeFunctionManager == null) {
			synchronized (NativeFunctionManager.class) {
				if (nativeFunctionManager == null) {
					nativeFunctionManager = new NativeFunctionManager();
				}
			}
		}
		return nativeFunctionManager;
	}

}
