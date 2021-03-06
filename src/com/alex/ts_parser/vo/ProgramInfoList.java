package com.alex.ts_parser.vo;

import java.util.LinkedList;
import java.util.List;

public class ProgramInfoList {
	volatile private static ProgramInfoList instance = null;

	private List<Integer> programBeanList;

	public List<Integer> getProgramIdList() {
		return programBeanList;
	}

	public void setProgramIdList(List<Integer> programIdList) {
		this.programBeanList = programIdList;
	}

	private ProgramInfoList() {
		init();
	}

	public static ProgramInfoList getInstance() {
		if (instance != null) {// ����ʽ

		} else {
			synchronized (ProgramInfoList.class) {
				if (instance == null) {// ���μ��
					instance = new ProgramInfoList();
				}
			}
		}
		return instance;
	}
	
	public void init() {
		programBeanList = new LinkedList<>();
	}
}
