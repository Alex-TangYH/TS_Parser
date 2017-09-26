package com.alex.ts_parser.bean;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EpgTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 882661073268427588L;
	public static final int MODEL_COLUMN_COUNT = 8;

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
            return rowIndex+1+"";  
        case 1:  
            return this.epgTableInfoBeanList.get(rowIndex).getEventId();  
        case 2:  
            return this.epgTableInfoBeanList.get(rowIndex).getStartTime();  
        case 3:  
            return this.epgTableInfoBeanList.get(rowIndex).getDuringTime();  
        case 4:  
            return this.epgTableInfoBeanList.get(rowIndex).getEndTime();
        case 5:  
        	return this.epgTableInfoBeanList.get(rowIndex).getProgramTitle();
        case 6:  
        	return this.epgTableInfoBeanList.get(rowIndex).getProgramType();
        case 7:  
        	return this.epgTableInfoBeanList.get(rowIndex).getProgramRating();
        case 8:  
        	return this.epgTableInfoBeanList.get(rowIndex).getBriefIntroduction();
        default:  
            return "-";  
        }  
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {  
        case 0:  
            return "�¼�ID";  
        case 1:  
            return "��ʼʱ�䣨���أ�";  
        case 2:  
            return "����ʱ��";  
        case 3:  
            return "����ʱ��";  
        case 4:  
        	return "��Ŀ�α���";  
        case 5:  
        	return "��Ŀ����";  
        case 6:  
        	return "�ּ�";  
        case 7:  
        	return "���";  
        default:  
            return "-";  
        }  
	}
}
