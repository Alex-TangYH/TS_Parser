package com.alex.ts_parser;

import java.util.Arrays;
import java.util.Comparator;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import com.alex.ts_parser.native_function.NativeFunctionManager;
import com.alex.ts_parser.ui.MainWindow;
import com.alex.ts_parser.utils.ReflectUtils;
import com.alex.ts_parser.vo.ProgramInfoList;
import com.alex.ts_parser.vo.TableData;

public class AddTableThread extends Thread {
	private Logger logger = LogManager.getLogger("AddTableThread");
	private final static String RST = "RST";
	private final static String TOT = "TOT";
	private final static String TDT = "TDT";
	private final static String ST = "ST";
	private final static String SIT = "SIT";
	private final static String EIT_PF_Actual = "EIT_PF_Actual";
	private final static String EIT_SCHEDULE_ACTUAL_50 = "EIT_Schedule_Actual (0x50)";
	private final static String EIT_SCHEDULE_ACTUAL_51 = "EIT_Schedule_Actual (0x51)";
	private final static String BAT = "BAT";
	private final static String DIT = "DIT";
	private final static String SDT = "SDT";

	private final static String CAT = "CAT";
	private final static String PMT = "PMT";
	private final static String PAT = "PAT";
	private final static String NIT = "NIT";

	private String tableName;
	private DefaultMutableTreeNode dataNode;
	private String filePath;

	public AddTableThread(String tableName, DefaultMutableTreeNode parentNode, String filePath) {
		super();
		this.tableName = tableName;
		this.dataNode = parentNode;
		this.filePath = filePath;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public DefaultMutableTreeNode getParentNode() {
		return dataNode;
	}

	public void setParentNode(DefaultMutableTreeNode parentNode) {
		this.dataNode = parentNode;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	// EIT≈≈–Ú∑Ω∑®
	public EIT_Table[] sortEit(EIT_Table[] eitArray) {
		if (eitArray != null) {
			Arrays.sort(eitArray, new Comparator<EIT_Table>() {
				@Override
				public int compare(EIT_Table eitArray1, EIT_Table eitArray2) {
					int serviceId1 = eitArray1.getServiceId();
					int serviceId2 = eitArray2.getServiceId();
					int sectionNumber1 = eitArray1.getSectionNumber();
					int sectionNumber2 = eitArray2.getSectionNumber();
					int versionNumber1 = eitArray1.getVersionNumber();
					int versionNumber2 = eitArray2.getVersionNumber();

					if (serviceId1 > serviceId2) {
						return 1;
					} else if (serviceId1 < serviceId2) {
						return -1;
					} else {
						if (versionNumber1 == versionNumber2) {
							if (sectionNumber1 > sectionNumber2) {
								return 1;
							} else if (sectionNumber1 < sectionNumber2) {
								return -1;
							} else {
								return 0;
							}
						} else if (versionNumber1 < versionNumber2) {
							return -1;
						} else {
							return 1;
						}
					}
				}
			});
		} else {
			return null;
		}
		return eitArray;
	}

	private int addProgramListInfo(EIT_Table[] eitArrays) {
		for (int index = 0; index < eitArrays.length; index++) {
			EIT_Table eitTable = eitArrays[index];
			ProgramInfoList.getInstance().getProgramIdList().add(eitTable.getServiceId());
		}
		return 1;
	}

	@Override
	public synchronized void start() {
		super.start();
	}

	@Override
	public void run() {
		switch (tableName) {
		case RST:
			RST_Table rstTable = NativeFunctionManager.parseRST(filePath);
			TableData.getInstance().setRstTable(rstTable);

			if (rstTable != null) {
				ReflectUtils.getTreeByObjAttr(rstTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("rst is null");
			}
			MainWindow.reflashData();
			break;
		case DIT:
			DIT_Table ditTable = NativeFunctionManager.parseDIT(filePath);
			TableData.getInstance().setDitTable(ditTable);
			if (ditTable != null) {
				ReflectUtils.getTreeByObjAttr(ditTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("dit is null");
			}
			MainWindow.reflashData();
			break;
		case ST:
			ST_Table stTable = NativeFunctionManager.parseST(filePath);
			TableData.getInstance().setStTable(stTable);
			if (stTable != null) {
				ReflectUtils.getTreeByObjAttr(stTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("st is null");
			}
			MainWindow.reflashData();
			break;
		case TOT:
			TOT_Table totTable = NativeFunctionManager.parseTOT(filePath);
			TableData.getInstance().setTotTable(totTable);
			if (totTable != null) {
				ReflectUtils.getTreeByObjAttr(totTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("tot is null");
			}
			MainWindow.reflashData();
			break;
		case TDT:
			TDT_Table tdtTable = NativeFunctionManager.parseTDT(filePath);
			TableData.getInstance().setTdtTable(tdtTable);
			if (tdtTable != null) {
				ReflectUtils.getTreeByObjAttr(tdtTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("tdt is null");
			}
			MainWindow.reflashData();
			break;
		case SDT:
			SDT_Table sdtTable = NativeFunctionManager.parseSDT(filePath);
			TableData.getInstance().setSdtTable(sdtTable);
			if (sdtTable != null) {
				ReflectUtils.getTreeByObjAttr(sdtTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("sdt is null");
			}
			MainWindow.reflashData();
			break;
		case SIT:
			SIT_Table sitTable = NativeFunctionManager.parseSIT(filePath);
			TableData.getInstance().setSitTable(sitTable);
			if (sitTable != null) {
				ReflectUtils.getTreeByObjAttr(sitTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("sit is null");
			}
			MainWindow.reflashData();
			break;
		case EIT_PF_Actual:
			EIT_Table[] eitPfArrays = NativeFunctionManager.parseEIT(filePath, NativeFunctionManager.EIT_PF_ACTUAL);
			TableData.getInstance().setEitPfArrays(eitPfArrays);
			if (eitPfArrays != null) {
				addProgramListInfo(eitPfArrays);
				eitPfArrays = sortEit(eitPfArrays);
				ReflectUtils.getTreeByObjAttr(eitPfArrays, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("eit pf_actual is null");
			}
			MainWindow.reflashData();
			break;
		case EIT_SCHEDULE_ACTUAL_50:
			EIT_Table[] eitSchedule50Arrays = NativeFunctionManager.parseEIT(filePath,
					NativeFunctionManager.EIT_OTHER_50);
			TableData.getInstance().setEitSchedule50Arrays(eitSchedule50Arrays);
			if (eitSchedule50Arrays != null) {
				addProgramListInfo(eitSchedule50Arrays);
				eitSchedule50Arrays = sortEit(eitSchedule50Arrays);
				ReflectUtils.getTreeByObjAttr(eitSchedule50Arrays, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("EIT_SCHEDULE_ACTUAL_50 is null");
			}
			MainWindow.reflashData();
			break;
		case EIT_SCHEDULE_ACTUAL_51:
			EIT_Table[] eitSchedule51Arrays = NativeFunctionManager.parseEIT(filePath,
					NativeFunctionManager.EIT_OTHER_51);
			TableData.getInstance().setEitSchedule51Arrays(eitSchedule51Arrays);
			if (eitSchedule51Arrays != null) {
				addProgramListInfo(eitSchedule51Arrays);
				eitSchedule51Arrays = sortEit(eitSchedule51Arrays);
				ReflectUtils.getTreeByObjAttr(eitSchedule51Arrays, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("EIT_SCHEDULE_ACTUAL_51 is null");
			}
			MainWindow.reflashData();
			break;
		case BAT:
			BAT_Table batTable = NativeFunctionManager.parseBAT(filePath);
			TableData.getInstance().setBatTable(batTable);
			if (batTable != null) {
				ReflectUtils.getTreeByObjAttr(batTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("bat is null");
			}
			MainWindow.reflashData();
			break;
		case CAT:
			CAT_Table catTable = NativeFunctionManager.parseCAT(filePath);
			TableData.getInstance().setCatTable(catTable);
			if (catTable != null) {
				ReflectUtils.getTreeByObjAttr(catTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("cat is null");
			}
			MainWindow.reflashData();
			break;
		case PAT:
			PAT_Table patTable = NativeFunctionManager.parsePAT(filePath);
			TableData.getInstance().setPatTable(patTable);
			if (patTable != null) {
				ReflectUtils.getTreeByObjAttr(patTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("pat is null");
			}
			MainWindow.reflashData();
			break;
		case PMT:
			PAT_Table patTemp = NativeFunctionManager.parsePAT(filePath);
			if (patTemp != null && patTemp.getPatProgramInfo().length > 0) {
				PMT_Table[] pmtTableArray = NativeFunctionManager.parsePMT(filePath, patTemp.getPatProgramInfo().length,
						patTemp.getPatProgramInfo());
				TableData.getInstance().setPmtTableArray(pmtTableArray);
				if (pmtTableArray != null) {
					ReflectUtils.getTreeByObjAttr(pmtTableArray, dataNode);
				} else {
					MainWindow.treeModel.removeNodeFromParent(dataNode);
					logger.info("pmt is null");
				}
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("pmt is null, because patProgramInfo length <= 0");
			}
			MainWindow.reflashData();
			break;
		case NIT:
			NIT_Table nitTable = NativeFunctionManager.parseNIT(filePath);
			TableData.getInstance().setNitTable(nitTable);
			if (nitTable != null) {
				ReflectUtils.getTreeByObjAttr(nitTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("nit is null");
			}
			MainWindow.reflashData();
			break;
		default:
			break;
		}
		TableData.getInstance().setFinishedThreadCount(TableData.getInstance().getFinishedThreadCount() + 1);
	}
}
