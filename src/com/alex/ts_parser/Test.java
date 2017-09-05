package com.alex.ts_parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.psi.PAT_Table;
import com.alex.ts_parser.native_function.NativeFunctionManager;

public class Test {
	private static Logger logger = LogManager.getLogger("");
	public Test() {
		
	}
	
	public static void TestFuction() {
//		NativeFunctionManager.parseTSFileNative("D:\\test\\test.ts");
		
//		String key = "MainWindow.MenuBar.MenuItem.File" ;
//		StringResocesHelper.GetStringByKey(key);
		
//		TestClass testClass =  NativeFunctionManager.parseAge();
		PAT_Table pat = NativeFunctionManager.parsePAT();
		System.out.println(pat.toString());
		System.out.println("testFuction excute");
	}
	
}
