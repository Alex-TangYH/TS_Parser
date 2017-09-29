package com.alex.ts_parser.vo;

import java.util.LinkedList;
import java.util.List;

public class ProgramTypeInfoList {
	volatile private static ProgramTypeInfoList instance = null;

	private List<String> programTypeList;
	
	public List<String> getProgramTypeList() {
		return programTypeList;
	}
	public void setProgramTypeList(List<String> programTypeList) {
		this.programTypeList = programTypeList;
	}
	private ProgramTypeInfoList() {
		init();
	}
	public static ProgramTypeInfoList getInstance() {
		if (instance != null) {// 懒汉式

		} else {
			synchronized (EpgTableInfoList.class) {
				if (instance == null) {// 二次检查
					instance = new ProgramTypeInfoList();
				}
			}
		}
		return instance;
	}
	
	public void init() {
		programTypeList = new LinkedList<String>();
	}
}
