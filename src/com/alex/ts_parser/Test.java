package com.alex.ts_parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.psi.CAT_Table;
import com.alex.ts_parser.bean.psi.NIT_Table;
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
		// ��������NIT�������
		NIT_Table nit = NativeFunctionManager.parseNIT("D:\\test\\test.ts");
		ReflectUtils.getObjAttr(nit);

		logger.info("testFuction excute");
		// ��������CAT�������
		// CAT_Table cat = NativeFunctionManager.parseCAT("D:\\test\\test.ts");
		// ReflectUtils.getObjAttr(cat);

		// ����·������TS���ļ��������
		// NativeFunctionManager.parseTSFileNative("D:\\test\\test.ts");

		// �ı���Դ�������������
		// String key = "MainWindow.MenuBar.MenuItem.File" ;
		// StringResocesHelper.GetStringByKey(key);

		// JNI������ͨ�Ų������
		// TestClass testClass = NativeFunctionManager.parseAge();

		// ��������PAT�������
		// PAT_Table pat = NativeFunctionManager.parsePAT("D:\\test\\test.ts");
		// ReflectUtils.getObjAttr(pat);
	}

}
