package com.alex.ts_parser.native_function;

import com.alex.ts_parser.bean.psi.CAT_Table;
import com.alex.ts_parser.bean.psi.NIT_Table;
import com.alex.ts_parser.bean.psi.PAT_ProgramInfo;
import com.alex.ts_parser.bean.psi.PAT_Table;
import com.alex.ts_parser.bean.psi.PMT_Table;
import com.alex.ts_parser.bean.psi.TestClass;
import com.alex.ts_parser.bean.si.TDT_Table;
import com.alex.ts_parser.bean.si.TOT_Table;

public class NativeFunctionManager {
	static {
		System.loadLibrary("libC_ParseTS_Lib");
	}

	public native static int parseTSFileNative(String filePath);

	public native static TestClass parseAge();
	
	// PSI表解析方法
	public native static PAT_Table parsePAT(String filePath);

	public native static CAT_Table parseCAT(String filePath);
	
	public native static NIT_Table parseNIT(String filePath);
	
	public native static PMT_Table[] parsePMT(String filePath,int pmtInfoCount,PAT_ProgramInfo[] patInfoArray);
	
	private static volatile NativeFunctionManager nativeFunctionManager;

	// SI表解析方法
	public native static TOT_Table parseTOT(String filePath);
	
	public native static TDT_Table parseTDT(String filePath);
	
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
