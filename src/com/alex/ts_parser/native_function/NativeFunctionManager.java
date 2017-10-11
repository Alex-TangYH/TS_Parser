package com.alex.ts_parser.native_function;

import com.alex.ts_parser.bean.psi.CAT_Table;
import com.alex.ts_parser.bean.psi.NIT_Table;
import com.alex.ts_parser.bean.psi.PAT_ProgramInfo;
import com.alex.ts_parser.bean.psi.PAT_Table;
import com.alex.ts_parser.bean.psi.PMT_Table;
import com.alex.ts_parser.bean.psi.TestClass;
import com.alex.ts_parser.bean.si.BAT_Table;
import com.alex.ts_parser.bean.si.DIT_Table;
import com.alex.ts_parser.bean.si.EIT_Table;
import com.alex.ts_parser.bean.si.RST_Table;
import com.alex.ts_parser.bean.si.SDT_Table;
import com.alex.ts_parser.bean.si.SIT_Table;
import com.alex.ts_parser.bean.si.ST_Table;
import com.alex.ts_parser.bean.si.TDT_Table;
import com.alex.ts_parser.bean.si.TOT_Table;
import com.alex.ts_parser.utils.StringResocesHelper;

public class NativeFunctionManager {
	static {
		System.loadLibrary(StringResocesHelper.getStringByKey("C_Parser_Lib"));
	}
	public static final int EIT_PF_ACTUAL = 1;
	public static final int EIT_OTHER_50 = 2;
	public static final int EIT_OTHER_51 = 3;

	public native static int parseTSFileNative(String filePath);

	public native static TestClass parseAge();

	// PSI表解析方法
	public native static PAT_Table parsePAT(String filePath);

	public native static CAT_Table parseCAT(String filePath);

	public native static NIT_Table parseNIT(String filePath);

	public native static PMT_Table[] parsePMT(String filePath, int pmtInfoCount, PAT_ProgramInfo[] patInfoArray);

	private static volatile NativeFunctionManager nativeFunctionManager;

	// SI表解析方法
	public native static TOT_Table parseTOT(String filePath);

	public native static TDT_Table parseTDT(String filePath);

	public native static SDT_Table parseSDT(String filePath);

	public native static BAT_Table parseBAT(String filePath);

	public native static DIT_Table parseDIT(String filePath);

	public native static EIT_Table[] parseEIT(String filePath, int eitType);

	public native static RST_Table parseRST(String filePath);

	public native static ST_Table parseST(String filePath);

	public native static SIT_Table parseSIT(String filePath);
}
