package com.alex.ts_parser.bean;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EpgTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 882661073268427588L;
	public static final int MODEL_COLUMN_COUNT = 10;

	private List<EpgTableInfoBean> epgTableInfoBeanList;

	public List<EpgTableInfoBean> getEpgTableInfoBeanList() {
		return epgTableInfoBeanList;
	}

	public void setEpgTableInfoBeanList(List<EpgTableInfoBean> epgTableInfoBeanList) {
		this.epgTableInfoBeanList = epgTableInfoBeanList;
	}

	public EpgTableModel(List<EpgTableInfoBean> epgTableInfoBeanList) {
		super();
		this.epgTableInfoBeanList = epgTableInfoBeanList;
	}

	@Override
	public int getRowCount() {
		return epgTableInfoBeanList.size();
	}

	@Override
	public int getColumnCount() {
		return MODEL_COLUMN_COUNT;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.epgTableInfoBeanList.get(rowIndex).getServiceId();
		case 1:
			return this.epgTableInfoBeanList.get(rowIndex).getType();
		case 2:
			return this.epgTableInfoBeanList.get(rowIndex).getEventId();
		case 3:
			return this.epgTableInfoBeanList.get(rowIndex).getStartTime();
		case 4:
			return this.epgTableInfoBeanList.get(rowIndex).getDuringTime();
		case 5:
			return this.epgTableInfoBeanList.get(rowIndex).getEndTime();
		case 6:
			return this.epgTableInfoBeanList.get(rowIndex).getProgramTitle();
		case 7:
			return this.epgTableInfoBeanList.get(rowIndex).getProgramType();
		case 8:
			return this.epgTableInfoBeanList.get(rowIndex).getProgramRating();
		case 9:
			return this.epgTableInfoBeanList.get(rowIndex).getBriefIntroduction();
		default:
			return "-";
		}
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "节目号";
		case 1:
			return "P/F/S";
		case 2:
			return "事件ID";
		case 3:
			return "开始时间";
		case 4:
			return "持续时间";
		case 5:
			return "结束时间";
		case 6:
			return "节目段标题";
		case 7:
			return "节目类型";
		case 8:
			return "分级";
		case 9:
			return "简介";
		default:
			return "-";
		}
	}
}
