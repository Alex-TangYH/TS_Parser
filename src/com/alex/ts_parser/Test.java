package com.alex.ts_parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.psi.CAT_Table;
import com.alex.ts_parser.bean.psi.NIT_Table;
import com.alex.ts_parser.bean.psi.PAT_Table;
import com.alex.ts_parser.bean.psi.PMT_Table;
import com.alex.ts_parser.bean.psi.TestClass;
import com.alex.ts_parser.bean.si.TDT_Table;
import com.alex.ts_parser.bean.si.TOT_Table;
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
		testParseTOT();
		logger.info("testFuction excute");
	}

	/**
	 * JNI������ͨ�Ų������
	 */
	private static void testJniJavaType() {
		TestClass testClass = NativeFunctionManager.parseAge();
	}

	/**
	 * �ı���Դ�������������
	 */
	private static void testStringSourceManage() {
		String key = "MainWindow.MenuBar.MenuItem.File";
		StringResocesHelper.getStringByKey(key);
	}

	/**
	 * ����·������TS���ļ��������
	 */
	private static void testParseTSFileNative() {
		NativeFunctionManager.parseTSFileNative("D:\\test\\test.ts");
	}

	/**
	 * ��������CAT�������
	 */
	private static void testParseCAT() {
		CAT_Table cat = NativeFunctionManager.parseCAT("D:\\test\\test.ts");
		ReflectUtils.getObjAttr(cat);
	}

	/**
	 * ��������NIT�������
	 */
	private static void testParseNIT() {
		NIT_Table nit = NativeFunctionManager.parseNIT("D:\\test\\test.ts");
		ReflectUtils.getObjAttr(nit);
	}

	/**
	 * ��������PAT�������
	 */
	private static void testParsePAT() {
		PAT_Table pat = NativeFunctionManager.parsePAT("D:\\test\\test.ts");
		ReflectUtils.getObjAttr(pat);
	}

	/**
	 * ��������PMT�������
	 */
	private static void testParsePMT() {
		PAT_Table pat = NativeFunctionManager.parsePAT("D:\\test\\1524.ts");
		PMT_Table[] pmt = NativeFunctionManager.parsePMT("D:\\test\\1524.ts", pat.getPatProgramInfo().length,
				pat.getPatProgramInfo());
		ReflectUtils.getObjAttr(pmt);
	}
	
	/**
	 * ��������TDT�������
	 */
	private static void testParseTDT() {
		TDT_Table tdt = NativeFunctionManager.parseTDT("D:\\test\\1524.ts");
		ReflectUtils.getObjAttr(tdt);
	}
	
	/**
	 * ��������TOT�������
	 */
	private static void testParseTOT() {
		TOT_Table tdt = NativeFunctionManager.parseTOT("D:\\test\\1524.ts");
		ReflectUtils.getObjAttr(tdt);
	}
}
