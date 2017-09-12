package com.alex.ts_parser.native_function;

import com.alex.ts_parser.bean.psi.CAT_Table;
import com.alex.ts_parser.bean.psi.NIT_Table;
import com.alex.ts_parser.bean.psi.PAT_ProgramInfo;
import com.alex.ts_parser.bean.psi.PAT_Table;
import com.alex.ts_parser.bean.psi.PMT_Table;
import com.alex.ts_parser.bean.psi.TestClass;

public class NativeFunctionManager {
	static {
		System.loadLibrary("libC_ParseTS_Lib");
	}

	public native static int parseTSFileNative(String filePath);

	public native static TestClass parseAge();
	
	public native static PAT_Table parsePAT(String filePath);

	public native static CAT_Table parseCAT(String filePath);
	
	public native static NIT_Table parseNIT(String filePath);
	
	public native static PMT_Table[] parsePMT(String filePath,int pmtInfoCount,PAT_ProgramInfo[] patInfoArray);
	
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
