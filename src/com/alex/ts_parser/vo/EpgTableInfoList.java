package com.alex.ts_parser.vo;

import java.util.ArrayList;
import java.util.List;

import com.alex.ts_parser.bean.EpgTableInfoBean;

public class EpgTableInfoList {

	volatile private static EpgTableInfoList instance = null;
	
    private	List<EpgTableInfoBean> epgTableInfolist;

	public List<EpgTableInfoBean> getEpgTableInfolist() {
		return epgTableInfolist;
	}

	public void setEpgTableInfolist(List<EpgTableInfoBean> epgTableInfolist) {
		this.epgTableInfolist = epgTableInfolist;
	}

	private EpgTableInfoList() {
		epgTableInfolist = new ArrayList<>();
	}

	public static EpgTableInfoList getInstance() {
		if (instance != null) {// ����ʽ

		} else {
			synchronized (EpgTableInfoList.class) {
				if (instance == null) {// ���μ��
					instance = new EpgTableInfoList();
				}
			}
		}
		return instance;
	}
	
	public void init() {
		epgTableInfolist.clear();
	}
}
