package com.alex.ts_parser.vo;

import com.alex.ts_parser.bean.psi.CAT_Table;
import com.alex.ts_parser.bean.psi.NIT_Table;
import com.alex.ts_parser.bean.psi.PAT_Table;
import com.alex.ts_parser.bean.psi.PMT_Table;
import com.alex.ts_parser.bean.si.BAT_Table;
import com.alex.ts_parser.bean.si.DIT_Table;
import com.alex.ts_parser.bean.si.EIT_Table;
import com.alex.ts_parser.bean.si.RST_Table;
import com.alex.ts_parser.bean.si.SDT_Table;
import com.alex.ts_parser.bean.si.SIT_Table;
import com.alex.ts_parser.bean.si.ST_Table;
import com.alex.ts_parser.bean.si.TDT_Table;
import com.alex.ts_parser.bean.si.TOT_Table;

public class TableData {
	volatile private static TableData instance = null;

	private int finishedThreadCount;
	private RST_Table rstTable;
	private DIT_Table ditTable;
	private ST_Table stTable;
	private TOT_Table totTable;
	private TDT_Table tdtTable;
	private SDT_Table sdtTable;
	private SIT_Table sitTable;

	private EIT_Table[] eitPfArrays;
	private EIT_Table[] eitSchedule50Arrays;
	private EIT_Table[] eitSchedule51Arrays;
	private BAT_Table batTable;
	private CAT_Table catTable;
	private PAT_Table patTable;
	private PMT_Table[] pmtTableArray;
	private NIT_Table nitTable;

	private TableData() {
		init();
	}

	public void init() {
		this.finishedThreadCount = 0;
		this.rstTable = null;
		this.ditTable = null;
		this.stTable = null;
		this.totTable = null;
		this.tdtTable = null;
		this.sdtTable = null;
		this.sitTable = null;
		this.eitPfArrays = null;
		this.eitSchedule50Arrays = null;
		this.eitSchedule51Arrays = null;
		this.batTable = null;
		this.catTable = null;
		this.patTable = null;
		this.pmtTableArray = null;
		this.nitTable = null;
	}

	public static TableData getInstance() {
		if (instance != null) {// 懒汉式

		} else {
			synchronized (EpgTableInfoList.class) {
				if (instance == null) {// 二次检查
					instance = new TableData();
				}
			}
		}
		return instance;
	}

	public RST_Table getRstTable() {
		return rstTable;
	}

	public void setRstTable(RST_Table rstTable) {
		this.rstTable = rstTable;
	}

	public DIT_Table getDitTable() {
		return ditTable;
	}

	public void setDitTable(DIT_Table ditTable) {
		this.ditTable = ditTable;
	}

	public ST_Table getStTable() {
		return stTable;
	}

	public void setStTable(ST_Table stTable) {
		this.stTable = stTable;
	}

	public TOT_Table getTotTable() {
		return totTable;
	}

	public void setTotTable(TOT_Table totTable) {
		this.totTable = totTable;
	}

	public TDT_Table getTdtTable() {
		return tdtTable;
	}

	public void setTdtTable(TDT_Table tdtTable) {
		this.tdtTable = tdtTable;
	}

	public SDT_Table getSdtTable() {
		return sdtTable;
	}

	public void setSdtTable(SDT_Table sdtTable) {
		this.sdtTable = sdtTable;
	}

	public SIT_Table getSitTable() {
		return sitTable;
	}

	public void setSitTable(SIT_Table sitTable) {
		this.sitTable = sitTable;
	}

	public EIT_Table[] getEitPfArrays() {
		return eitPfArrays;
	}

	public void setEitPfArrays(EIT_Table[] eitPfArrays) {
		this.eitPfArrays = eitPfArrays;
	}

	public EIT_Table[] getEitSchedule50Arrays() {
		return eitSchedule50Arrays;
	}

	public void setEitSchedule50Arrays(EIT_Table[] eitSchedule50Arrays) {
		this.eitSchedule50Arrays = eitSchedule50Arrays;
	}

	public EIT_Table[] getEitSchedule51Arrays() {
		return eitSchedule51Arrays;
	}

	public void setEitSchedule51Arrays(EIT_Table[] eitSchedule51Arrays) {
		this.eitSchedule51Arrays = eitSchedule51Arrays;
	}

	public BAT_Table getBatTable() {
		return batTable;
	}

	public void setBatTable(BAT_Table batTable) {
		this.batTable = batTable;
	}

	public CAT_Table getCatTable() {
		return catTable;
	}

	public void setCatTable(CAT_Table catTable) {
		this.catTable = catTable;
	}

	public PAT_Table getPatTable() {
		return patTable;
	}

	public void setPatTable(PAT_Table patTable) {
		this.patTable = patTable;
	}

	public PMT_Table[] getPmtTableArray() {
		return pmtTableArray;
	}

	public void setPmtTableArray(PMT_Table[] pmtTableArray) {
		this.pmtTableArray = pmtTableArray;
	}

	public NIT_Table getNitTable() {
		return nitTable;
	}

	public void setNitTable(NIT_Table nitTable) {
		this.nitTable = nitTable;
	}

	public int getFinishedThreadCount() {
		return finishedThreadCount;
	}

	public void setFinishedThreadCount(int finishedThreadCount) {
		this.finishedThreadCount = finishedThreadCount;
	}
}
