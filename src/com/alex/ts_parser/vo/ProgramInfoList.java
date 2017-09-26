package com.alex.ts_parser.vo;

import java.util.ArrayList;
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
		programBeanList = new ArrayList<>();
	}

	public static ProgramInfoList getInstance() {
		if (instance != null) {// 懒汉式

		} else {
			synchronized (ProgramInfoList.class) {
				if (instance == null) {// 二次检查
					instance = new ProgramInfoList();
				}
			}
		}
		return instance;
	}
}
