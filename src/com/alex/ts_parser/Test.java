package com.alex.ts_parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.psi.CAT_Table;
import com.alex.ts_parser.bean.psi.NIT_Table;
import com.alex.ts_parser.bean.psi.PAT_Table;
import com.alex.ts_parser.bean.psi.PMT_Table;
import com.alex.ts_parser.bean.psi.TestClass;
import com.alex.ts_parser.bean.si.SDT_Table;
import com.alex.ts_parser.bean.si.TDT_Table;
import com.alex.ts_parser.bean.si.TOT_Table;
import com.alex.ts_parser.native_function.NativeFunctionManager;
import com.alex.ts_parser.utils.ReflectUtils;
import com.alex.ts_parser.utils.StringResocesHelper;

public class Test {
	private static Logger logger = LogManager.getLogger("Test");
	private static String filePath = "D:\\test\\program.ts";
	public Test() {
	}

	public static void main(String[] args) {
		testFuction();
	}

	public static void testFuction() {
		testParseSDT();
		logger.info("testFuction excute");
	}

	/**
	 * JNI各类型通信测试语句
	 */
	private static void testJniJavaType() {
		TestClass testClass = NativeFunctionManager.parseAge();
	}

	/**
	 * 文本资源管理器测试语句
	 */
	private static void testStringSourceManage() {
		String key = "MainWindow.MenuBar.MenuItem.File";
		StringResocesHelper.getStringByKey(key);
	}

	/**
	 * 输入路径解析TS流文件测试语句
	 */
	private static void testParseTSFileNative() {
		NativeFunctionManager.parseTSFileNative(filePath);
	}

	/**
	 * 单独解析CAT测试语句
	 */
	private static void testParseCAT() {
		CAT_Table cat = NativeFunctionManager.parseCAT(filePath);
		ReflectUtils.getObjAttr(cat);
	}

	/**
	 * 单独解析NIT测试语句
	 */
	private static void testParseNIT() {
		NIT_Table nit = NativeFunctionManager.parseNIT(filePath);
		ReflectUtils.getObjAttr(nit);
	}

	/**
	 * 单独解析PAT测试语句
	 */
	private static void testParsePAT() {
		PAT_Table pat = NativeFunctionManager.parsePAT(filePath);
		ReflectUtils.getObjAttr(pat);
	}

	/**
	 * 单独解析PMT测试语句
	 */
	private static void testParsePMT() {
		PAT_Table pat = NativeFunctionManager.parsePAT(filePath);
		PMT_Table[] pmt = NativeFunctionManager.parsePMT(filePath, pat.getPatProgramInfo().length,
				pat.getPatProgramInfo());
		ReflectUtils.getObjAttr(pmt);
	}
	
	/**
	 * 单独解析TDT测试语句
	 */
	private static void testParseTDT() {
		TDT_Table tdt = NativeFunctionManager.parseTDT(filePath);
		ReflectUtils.getObjAttr(tdt);
	}
	
	/**
	 * 单独解析TOT测试语句
	 */
	private static void testParseTOT() {
		TOT_Table tdt = NativeFunctionManager.parseTOT(filePath);
		ReflectUtils.getObjAttr(tdt);
	}
	
	/**
	 * 单独解析TOT测试语句
	 */
	private static void testParseSDT() {
		SDT_Table sdt = NativeFunctionManager.parseSDT(filePath);
		ReflectUtils.getObjAttr(sdt);
	}
}
