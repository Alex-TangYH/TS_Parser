package com.alex.ts_parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.psi.CAT_Table;
import com.alex.ts_parser.bean.psi.NIT_Table;
import com.alex.ts_parser.bean.psi.PAT_Table;
import com.alex.ts_parser.bean.psi.PMT_Table;
import com.alex.ts_parser.bean.psi.TestClass;
import com.alex.ts_parser.native_function.NativeFunctionManager;
import com.alex.ts_parser.utils.ReflectUtils;
import com.alex.ts_parser.utils.StringResocesHelper;

public class Test {
	private static Logger logger = LogManager.getLogger("");

	public Test() {
	}

	public static void main(String[] args) {
		testFuction();
	}

	public static void testFuction() {
		logger.info("testFuction excute");
	}

	/**
	 * JNI各类型通信测试语句
	 */
	private void testJniJavaType() {
		TestClass testClass = NativeFunctionManager.parseAge();
	}

	/**
	 * 文本资源管理器测试语句
	 */
	private void testStringSourceManage() {
		String key = "MainWindow.MenuBar.MenuItem.File";
		StringResocesHelper.getStringByKey(key);
	}

	/**
	 * 输入路径解析TS流文件测试语句
	 */
	private void testParseTSFileNative() {
		NativeFunctionManager.parseTSFileNative("D:\\test\\test.ts");
	}

	/**
	 * 单独解析CAT测试语句
	 */
	private void testParseCAT() {
		CAT_Table cat = NativeFunctionManager.parseCAT("D:\\test\\test.ts");
		ReflectUtils.getObjAttr(cat);
	}

	/**
	 * 单独解析NIT测试语句
	 */
	private void testParseNIT() {
		NIT_Table nit = NativeFunctionManager.parseNIT("D:\\test\\test.ts");
		ReflectUtils.getObjAttr(nit);
	}

	/**
	 * 单独解析PAT测试语句
	 */
	private void testParsePAT() {
		PAT_Table pat = NativeFunctionManager.parsePAT("D:\\test\\test.ts");
		ReflectUtils.getObjAttr(pat);
	}

	/**
	 * 单独解析PMT测试语句
	 */
	private void testParsePMT() {
		PAT_Table pat = NativeFunctionManager.parsePAT("D:\\test\\1524.ts");
		PMT_Table[] pmt = NativeFunctionManager.parsePMT("D:\\test\\1524.ts", pat.getPatProgramInfo().length,
				pat.getPatProgramInfo());
		ReflectUtils.getObjAttr(pmt);
	}
}
