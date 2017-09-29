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
			return "��Ŀ��";
		case 1:
			return "P/F/S";
		case 2:
			return "�¼�ID";
		case 3:
			return "��ʼʱ��";
		case 4:
			return "����ʱ��";
		case 5:
			return "����ʱ��";
		case 6:
			return "��Ŀ�α���";
		case 7:
			return "��Ŀ����";
		case 8:
			return "�ּ�";
		case 9:
			return "���";
		default:
			return "-";
		}
	}
}
