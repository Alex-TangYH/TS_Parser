package com.alex.ts_parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.psi.PAT_ProgramInfo;
import com.alex.ts_parser.bean.psi.PAT_Table;
import com.alex.ts_parser.bean.psi.PMT_Table;
import com.alex.ts_parser.native_function.NativeFunctionManager;
import com.alex.ts_parser.utils.ReflectUtils;

public class Test {
	private static Logger logger = LogManager.getLogger("");

	public Test() {
	}

	public static void main(String[] args) {
		TestFuction();
	}

	public static void TestFuction() {
		// 单独解析PAT测试语句
		// PAT_Table pat = NativeFunctionManager.parsePAT("D:\\test\\test.ts");
		// ReflectUtils.getObjAttr(pat);
		// 单独解析PMT测试语句
		PAT_Table pat = NativeFunctionManager.parsePAT("D:\\test\\test_pat_pmt.ts");
		PMT_Table[] pmt = NativeFunctionManager.parsePMT("D:\\test\\test_pat_pmt.ts", pat.getPatProgramInfo().length,
				pat.getPatProgramInfo());
		ReflectUtils.getObjAttr(pmt);
		logger.info("testFuction excute");
		// 单独解析NIT测试语句
		// NIT_Table nit = NativeFunctionManager.parseNIT("D:\\test\\test.ts");
		// ReflectUtils.getObjAttr(nit);

		// 单独解析CAT测试语句
		// CAT_Table cat = NativeFunctionManager.parseCAT("D:\\test\\test.ts");
		// ReflectUtils.getObjAttr(cat);

		// 输入路径解析TS流文件测试语句
		// NativeFunctionManager.parseTSFileNative("D:\\test\\test.ts");

		// 文本资源管理器测试语句
		// String key = "MainWindow.MenuBar.MenuItem.File" ;
		// StringResocesHelper.GetStringByKey(key);

		// JNI各类型通信测试语句
		// TestClass testClass = NativeFunctionManager.parseAge();

	}

}
