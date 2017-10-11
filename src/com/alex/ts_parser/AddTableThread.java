package com.alex.ts_parser;

import java.util.Arrays;
import java.util.Collections;
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
	private Logger logger = LogManager.getLogger("ParseTableThread");

	public enum PsiTableType {
		NIT, PAT, PMT, CAT
	}

	public enum SiTableType {
		BAT, SDT, TDT, TOT, DIT, RST, ST, SIT, EIT_PF_Actual, EIT_SCHEDULE_ACTUAL_50, EIT_SCHEDULE_ACTUAL_51
	}

	private PsiTableType psiTableType;
	private SiTableType siTableType;
	private DefaultMutableTreeNode dataNode;
	private String filePath;

	public AddTableThread(PsiTableType psiTableType, DefaultMutableTreeNode parentNode, String filePath) {
		super();
		this.psiTableType = psiTableType;
		this.dataNode = parentNode;
		this.filePath = filePath;
	}

	public AddTableThread(SiTableType siTableType, DefaultMutableTreeNode parentNode, String filePath) {
		super();
		this.siTableType = siTableType;
		this.dataNode = parentNode;
		this.filePath = filePath;
	}

	public PsiTableType getTableName() {
		return psiTableType;
	}

	public void setTableName(PsiTableType tableName) {
		this.psiTableType = tableName;
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

	@Override
	public synchronized void start() {
		super.start();
	}

	@Override
	public void run() {
		try {
			if (siTableType != null) {
				parseSiTableData(siTableType);
			} else if (psiTableType != null) {
				parsePsiTableData(psiTableType);
			}
		} catch (Exception e) {
			logger.error("ParseTableThread", e);
		} finally {
			TableData.getInstance().setFinishedThreadCount(TableData.getInstance().getFinishedThreadCount() + 1);
			if (TableData.getInstance().getFinishedThreadCount() == 15) {
				MainWindow.reflashData();
				MainWindow.fillEpgDataThread.start();
			}
		}
	}

	private void parsePsiTableData(PsiTableType psiTableType) {
		switch (psiTableType) {
		case CAT:
			CAT_Table catTable = NativeFunctionManager.parseCAT(filePath);
			TableData.getInstance().setCatTable(catTable);
			if (catTable != null) {
				ReflectUtils.getTreeByObjAttr(catTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("cat is null");
			}
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
				logger.info("pmt is null, because patProgramInfo length less than 0");
			}
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
			break;
		default:
			break;
		}
	}

	private void parseSiTableData(SiTableType siTableType) {
		switch (siTableType) {
		case RST:
			RST_Table rstTable = NativeFunctionManager.parseRST(filePath);
			TableData.getInstance().setRstTable(rstTable);
			if (rstTable != null) {
				ReflectUtils.getTreeByObjAttr(rstTable, dataNode);
			} else {
				MainWindow.treeModel.removeNodeFromParent(dataNode);
				logger.info("rst is null");
			}
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
			break;
		default:
			break;
		}
	}

	/**
	 * EIT排序方法 排序规则：先按serviceId，再按versionNumber，再按SectionNumber
	 * 
	 * @param eitArray
	 *            进行排序的eit表数组
	 * @return 排序后的eit表
	 */
	private EIT_Table[] sortEit(EIT_Table[] eitArray) {
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

	/**
	 * 从Eit中获取节目列表
	 * 
	 * @param eitArrays
	 *            数据源eit表数组
	 * @return 从eit表数组中获取并经过排序的节目列表
	 */
	private int addProgramListInfo(EIT_Table[] eitArrays) {
		for (EIT_Table eitTable : eitArrays) {
			if (!ProgramInfoList.getInstance().getProgramIdList().contains(eitTable.getServiceId())) {
				ProgramInfoList.getInstance().getProgramIdList().add(eitTable.getServiceId());
			}
		}
		Collections.sort(ProgramInfoList.getInstance().getProgramIdList());
		return 1;
	}
}
