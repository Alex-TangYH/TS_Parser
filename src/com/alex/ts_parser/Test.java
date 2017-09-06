package com.alex.ts_parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.psi.CAT_Table;
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
		CAT_Table cat = NativeFunctionManager.parseCAT();
		ReflectUtils.getObjAttr(cat);

		logger.info("testFuction excute");
		
		// 输入路径解析TS流文件测试语句
		// NativeFunctionManager.parseTSFileNative("D:\\test\\test.ts");

		// 文本资源管理器测试语句
		// String key = "MainWindow.MenuBar.MenuItem.File" ;
		// StringResocesHelper.GetStringByKey(key);

		// JNI各类型通信测试语句
		// TestClass testClass = NativeFunctionManager.parseAge();

		// 单独解析PAT测试语句
		// PAT_Table pat = NativeFunctionManager.parsePAT();
		// ReflectUtils.getObjAttr(pat);
	}

}
