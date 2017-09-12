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
		// ��������PAT�������
		// PAT_Table pat = NativeFunctionManager.parsePAT("D:\\test\\test.ts");
		// ReflectUtils.getObjAttr(pat);
		// ��������PMT�������
		PAT_Table pat = NativeFunctionManager.parsePAT("D:\\test\\test_pat_pmt.ts");
		PMT_Table[] pmt = NativeFunctionManager.parsePMT("D:\\test\\test_pat_pmt.ts", pat.getPatProgramInfo().length,
				pat.getPatProgramInfo());
		ReflectUtils.getObjAttr(pmt);
		logger.info("testFuction excute");
		// ��������NIT�������
		// NIT_Table nit = NativeFunctionManager.parseNIT("D:\\test\\test.ts");
		// ReflectUtils.getObjAttr(nit);

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

	}

}
