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

	// EIT���򷽷�
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

	@Override
	public synchronized void start() {
		super.start();
	}

	@Override
	public void run() {
		switch (tableName) {
		case RST:
			RST_Table rstTable = NativeFunctionManager.parseRST(filePath);
			if (rstTable != null) {
				ReflectUtils.getTreeByObjAttr(rstTable, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("rst is null");
			}
			MainWindow.reflashData();
			break;
		case DIT:
			DIT_Table dit = NativeFunctionManager.parseDIT(filePath);
			if (dit != null) {
				ReflectUtils.getTreeByObjAttr(dit, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("dit is null");
			}
			MainWindow.reflashData();
			break;
		case ST:
			ST_Table st = NativeFunctionManager.parseST(filePath);
			if (st != null) {
				ReflectUtils.getTreeByObjAttr(st, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("st is null");
			}
			MainWindow.reflashData();
			break;
		case TOT:
			TOT_Table tot = NativeFunctionManager.parseTOT(filePath);
			if (tot != null) {
				ReflectUtils.getTreeByObjAttr(tot, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("tot is null");
			}
			MainWindow.reflashData();
			break;
		case TDT:
			TDT_Table tdt = NativeFunctionManager.parseTDT(filePath);
			if (tdt != null) {
				ReflectUtils.getTreeByObjAttr(tdt, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("tdt is null");
			}
			MainWindow.reflashData();
			break;
		case SDT:
			SDT_Table sdt = NativeFunctionManager.parseSDT(filePath);
			if (sdt != null) {
				ReflectUtils.getTreeByObjAttr(sdt, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("sdt is null");
			}
			MainWindow.reflashData();
			break;
		case SIT:
			SIT_Table sit = NativeFunctionManager.parseSIT(filePath);
			if (sit != null) {
				ReflectUtils.getTreeByObjAttr(sit, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("sit is null");
			}
			MainWindow.reflashData();
			break;
		case EIT_PF_Actual:
			EIT_Table[] eitArray = NativeFunctionManager.parseEIT(filePath, NativeFunctionManager.EIT_PF_ACTUAL);
			if (eitArray != null) {
				eitArray = sortEit(eitArray);
				ReflectUtils.getTreeByObjAttr(eitArray, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("eit pf_actual is null");
			}
			MainWindow.reflashData();
			break;
		case EIT_SCHEDULE_ACTUAL_50:
			EIT_Table[] eit50Array = NativeFunctionManager.parseEIT(filePath, NativeFunctionManager.EIT_OTHER_50);
			if (eit50Array != null) {
				eit50Array = sortEit(eit50Array);
				ReflectUtils.getTreeByObjAttr(eit50Array, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("EIT_SCHEDULE_ACTUAL_50 is null");
			}
			MainWindow.reflashData();
			break;
		case EIT_SCHEDULE_ACTUAL_51:
			EIT_Table[] eit51Array = NativeFunctionManager.parseEIT(filePath, NativeFunctionManager.EIT_OTHER_51);
			if (eit51Array != null) {
				eit51Array = sortEit(eit51Array);
				ReflectUtils.getTreeByObjAttr(eit51Array, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("EIT_SCHEDULE_ACTUAL_51 is null");
			}
			MainWindow.reflashData();
			break;
		case BAT:
			BAT_Table batArray = NativeFunctionManager.parseBAT(filePath);
			if (batArray != null) {
				ReflectUtils.getTreeByObjAttr(batArray, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("bat is null");
			}
			MainWindow.reflashData();
			break;
		case CAT:
			CAT_Table cat = NativeFunctionManager.parseCAT(filePath);
			if (cat != null) {
				ReflectUtils.getTreeByObjAttr(cat, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("cat is null");
			}
			MainWindow.reflashData();
			break;
		case PAT:
			PAT_Table pat = NativeFunctionManager.parsePAT(filePath);
			if (pat != null) {
				ReflectUtils.getTreeByObjAttr(pat, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("pat is null");
			}
			MainWindow.reflashData();
			break;
		case PMT:
			PAT_Table patTemp = NativeFunctionManager.parsePAT(filePath);
			if (patTemp != null && patTemp.getPatProgramInfo().length > 0) {
				PMT_Table[] pmt = NativeFunctionManager.parsePMT(filePath, patTemp.getPatProgramInfo().length,
						patTemp.getPatProgramInfo());
				if (pmt != null) {
					ReflectUtils.getTreeByObjAttr(pmt, dataNode);
				} else {
					dataNode.removeFromParent();
					logger.info("pmt is null");
				}
			} else {
				dataNode.removeFromParent();
				logger.info("pmt is null, because patProgramInfo length <= 0");
			}
			MainWindow.reflashData();
			break;
		case NIT:
			NIT_Table nit = NativeFunctionManager.parseNIT(filePath);
			if (nit != null) {
				ReflectUtils.getTreeByObjAttr(nit, dataNode);
			} else {
				dataNode.removeFromParent();
				logger.info("nit is null");
			}
			MainWindow.reflashData();
			break;
		default:
			break;
		}
	}
}
