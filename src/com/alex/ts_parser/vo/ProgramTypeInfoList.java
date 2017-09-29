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
		if (instance != null) {// ����ʽ

		} else {
			synchronized (EpgTableInfoList.class) {
				if (instance == null) {// ���μ��
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
