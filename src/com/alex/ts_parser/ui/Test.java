package com.alex.ts_parser.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.native_function.NativeFunctionManager;
import com.alex.ts_parser.native_function.TestClass;
import com.alex.ts_parser.utils.StringResocesHelper;

public class Test {
	private static Logger logger = LogManager.getLogger("");
	public Test() {
		
	}
	
	public static void TestFuction() {
//		NativeFunctionManager.parseTSFileNative("D:\\test\\test.ts");
		
//		String key = "MainWindow.MenuBar.MenuItem.File" ;
//		StringResocesHelper.GetStringByKey(key);
		TestClass testClass =  NativeFunctionManager.parseAge();
		logger.info(testClass.toString()); ;
		System.out.println("testFuction excute");
	}
	
}
