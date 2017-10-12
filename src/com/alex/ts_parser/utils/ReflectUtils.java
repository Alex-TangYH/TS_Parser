package com.alex.ts_parser.utils;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.descriptor.ContentInfo;
import com.alex.ts_parser.bean.descriptor.Descriptor;
import com.alex.ts_parser.bean.map.BandwidthMap;
import com.alex.ts_parser.bean.map.ContentNibbleLevelMap;
import com.alex.ts_parser.bean.si.EIT_Table;
import com.alex.ts_parser.vo.ProgramTypeInfoList;

public class ReflectUtils {
	private static Logger logger = LogManager.getLogger("");


	public static void getObjAttr(Object obj) {
		// ��ȡ����obj������������
		if (obj == null) {
			return;
		}
		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			// ����ÿ�����ԣ���ȡ������
			String varName = field.getName();
			try {
				boolean access = field.isAccessible();
				if (!access)
					field.setAccessible(true);
				// ��obj�л�ȡfield����
				Object o = field.get(obj);
				if (o == null) {
					logger.info("������ " + varName + " = " + o);
				} else if (o.getClass().isArray()) { // �ж��Ƿ�������
					if (!isJavaClass(o.getClass())) {
						Object[] arr = (Object[]) o; // װ��������
						for (Object a : arr) {
							getObjAttr(a);
						}
					} else {
						Class<?> cla = o.getClass();
						if (cla.getName().equals("[B")) {
							logger.info("������ " + varName + " = " + Arrays.toString((byte[]) o));
						} else if (cla.getName().equals("[J")) {
							logger.info("������ " + varName + " = " + Arrays.toString((long[]) o));
						}
					}
				} else {
					logger.info("������ " + varName + " = " + o);
				}
				if (!access)
					field.setAccessible(false);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}


	
	/**
	 * Ϊobj������parentNodeΪ���ڵ������Ҳ�Ǵ�������
	 * 
	 * @param obj
	 * @param parentNode
	 * @return
	 */
	public static DefaultMutableTreeNode getNodeWithObj(Object obj, DefaultMutableTreeNode parentNode) {
		try {
			if (obj == null) {
				DefaultMutableTreeNode nullNode = new DefaultMutableTreeNode("");
				return nullNode;
			} else if (obj.getClass().isArray()) {
				parentNode = getTreeWithArrayObj(obj, parentNode, null);
			} else {
				parentNode = getNodeWithSingleObj(obj, parentNode);
			}
		} catch (Exception e) {
			logger.error("getTreeByObjAttr", e);
		}
		return parentNode;

	}

	/**
	 * Ϊ���������������rootNodeΪ��������
	 * 
	 * @param obj
	 * @param rootNode
	 * @return
	 */
	private static DefaultMutableTreeNode getNodeWithSingleObj(Object obj, DefaultMutableTreeNode rootNode) {
		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			boolean access = field.isAccessible();
			if (!access) {
				field.setAccessible(true);
			}

			Object fieldObj = null;
			try {
				fieldObj = field.get(obj);
			} catch (IllegalArgumentException ex) {
				logger.error("getTreeByObjAttr", ex);
			} catch (IllegalAccessException ex) {
				logger.error("getTreeByObjAttr", ex);
			} finally {
				getNodeWithFieldObj(obj, rootNode, field, fieldObj);

				if (!access) {
					field.setAccessible(false);
				}
			}
		}
		return rootNode;
	}

	/**
	 * �������ֵ��������
	 * 
	 * @param obj
	 * @param parentNode
	 * @param field
	 * @param o
	 * @return
	 */
	private static DefaultMutableTreeNode getNodeWithFieldObj(Object obj, DefaultMutableTreeNode parentNode,
			Field field, Object o) {
		String varName = field.getName();
		DefaultMutableTreeNode childs = null;
		if (o == null) {
			logger.debug(String.format("%s is null", varName));
		} else if (o.getClass().isArray()) { // �ж��Ƿ�������
			getTreeWithArrayObj(o, parentNode, varName);
		} else if (!isJavaClass(o.getClass())) {
			childs = new DefaultMutableTreeNode(varName);
			getNodeWithObj(o, childs);
			parentNode.add(childs);
		} else {
			String nodeName = dealWithSpecificNodeAndGetNodeName(obj, varName, o);
			childs = new DefaultMutableTreeNode(nodeName);
			parentNode.add(childs);
		}
		return parentNode;
	}

	private static String dealWithSpecificNodeAndGetNodeName(Object obj, String varName, Object o) {
		// OPT ����getSpecificNodeName()
		// OPT ����ȡ��Ŀ���͵ķ�����ȡ �Ƿ��Ӱ��Ч��
		String nodeName;
		switch (varName) {
		case "contentNibbleLevel1":
			String defaultTypeValueOfContentNibbleLevel1 = "Reserved for future use";
			String level1Name = ContentNibbleLevelMap.contentNibbleLevel1Map.getOrDefault(o,
					defaultTypeValueOfContentNibbleLevel1);
			nodeName = String.format("%s = %d(%s)", varName, o, level1Name);
			boolean isTypeExist = false;
			// ���������ݴ�������������
			for (int i = 0; i < ProgramTypeInfoList.getInstance().getProgramTypeList().size(); i++) {
				if (level1Name.equals(ProgramTypeInfoList.getInstance().getProgramTypeList().get(i))) {
					isTypeExist = true;
					break;
				}
			}

			if (ProgramTypeInfoList.getInstance() != null) {
				int iLoopIndex = 0;
				for (String type : ProgramTypeInfoList.getInstance().getProgramTypeList()) {
					if (level1Name.equals(type)) {
						isTypeExist = true;
						break;
					}
					iLoopIndex++;
				}
				if (!isTypeExist) {
					ProgramTypeInfoList.getInstance().getProgramTypeList().add(iLoopIndex, level1Name);
				}
			}
			break;
		case "contentNibbleLevel2":
			String defaultTypeValueOfContentNibbleLevel2 = "Reserved for future use";
			nodeName = String.format("%s = %d(%s)", varName, o,
					ContentNibbleLevelMap.contentNibbleLevel2Map.getOrDefault(
							new Integer(((ContentInfo) obj).getContentNibbleLevel1()) * 16 + (int) o,
							defaultTypeValueOfContentNibbleLevel2));
			break;
		case "bandwidth":
			nodeName = String.format("%s = %s(ԭʼ���ݣ�%d)", varName, BandwidthMap.bandwidthMap.get(o), o);
			break;
		default:
			nodeName = String.format("%s = %d", varName, o);
			break;
		}
		return nodeName;
	}

	/**
	 * ΪDescriptor�����������ڵ�
	 * 
	 * @param obj
	 * @return
	 */
	private static DefaultMutableTreeNode getNodeWithDescriptor(Object obj) {
		String varName;
		DefaultMutableTreeNode descriptorNode;
		varName = ((Descriptor) obj).getDescriptorName();
		descriptorNode = new DefaultMutableTreeNode(varName);

		if (!obj.getClass().getName().equals("com.alex.ts_parser.bean.descriptor.Descriptor")) {
			descriptorNode.add(new DefaultMutableTreeNode("descriptorTag = " + ((Descriptor) obj).getDescriptorTag()));
			descriptorNode
					.add(new DefaultMutableTreeNode("descriptorLength = " + ((Descriptor) obj).getDescriptorLength()));
		}
		return getNodeWithObj(obj, descriptorNode);
	}

	private static DefaultMutableTreeNode dealWithSystemArrayTypeData(DefaultMutableTreeNode parentNode, String varName,
			Object o) {
		DefaultMutableTreeNode childs;
		Class<?> cla = o.getClass();
		if (cla.getName().equals("[B")) {
			logger.debug("������ " + varName + " = " + Arrays.toString((byte[]) o));
			// TODO ��Щ�������ܴ���ʽ��ͬ
			childs = new DefaultMutableTreeNode(
					varName + " = " + new String((byte[]) o) + " (ԭʼ���ݣ�" + Arrays.toString((byte[]) o) + ")");
			parentNode.add(childs);
		} else if (cla.getName().equals("[J")) {
			// logger.info("������ " + varName + " = " + Arrays.toString((long[]) o));
			childs = new DefaultMutableTreeNode(varName + " = " + Arrays.toString((long[]) o));
			parentNode.add(childs);
		}
		return parentNode;
	}

	private static String getVarNameForArray(String varName) {
		switch (varName) {
		case "descriptorArray":
			varName = "������";
			break;
		case "patProgramInfoArray":
			varName = "PMT PID��Ϣ";
			break;
		case "transportStreamDsecriptorArray":
			varName = "TS��������";
			break;

		default:
			break;
		}
		return varName;
	}

	/**
	 * Ϊ������󴴽���
	 * 
	 * @param obj
	 * @param parentNode
	 */
	private static DefaultMutableTreeNode getTreeWithArrayObj(Object obj, DefaultMutableTreeNode parentNode,
			String varName) {

		if (!isJavaClass(obj.getClass())) {
			Object[] arr = (Object[]) obj; // װ��������
			String nodeName = "";
			DefaultMutableTreeNode arrayRootNode = null;
			if (varName != null) {
				nodeName = getVarNameForArray(varName);
				if (!nodeName.equals("")) {
					arrayRootNode = new DefaultMutableTreeNode(nodeName);
				}
			}
			DefaultMutableTreeNode arrayElemNode;
			for (int index = 0; index < arr.length; index++) {
				Object a = arr[index];
				if (a == null) {
					logger.debug("���ֿ�����Ԫ��");
					continue;
				} else {
					if (a instanceof Descriptor) {
						arrayElemNode = getNodeWithDescriptor(a);
					} else {
						if (varName != null) {
							nodeName = String.format("%s [%d]", getObjectClassFileName(a), index);
						} else {
							nodeName = getTableNodeName(index, a);
						}
						arrayElemNode = new DefaultMutableTreeNode(nodeName);
						arrayElemNode = getNodeWithObj(a, arrayElemNode);
					}
					if (arrayRootNode == null) {
						parentNode.add(arrayElemNode);
					} else {
						arrayRootNode.add(arrayElemNode);
					}
				}
			}
			if (arrayRootNode != null) {
				parentNode.add(arrayRootNode);
			}

		} else {
			parentNode = dealWithSystemArrayTypeData(parentNode, varName, obj);
		}

		return parentNode;
	}

	private static String getTableNodeName(int i, Object objElem) {
		String nodeName;
		// OPT �ĳ��ض��ڵ�Map����ö��
		if (isSpecificObj(objElem)) {
			nodeName = getNodeNameWithSpecificObj(i, objElem);
		} else {
			nodeName = String.format("%s [%d]", getObjectClassFileName(objElem), i);
		}
		return nodeName;
	}

	private static boolean isSpecificObj(Object objElem) {
		if (getObjectClassFileName(objElem).equals("EIT_Table")) {
			return true;
		}
		return false;
	}

	/**
	 * ��ȡ�ض��Ķ���Ľڵ�����
	 * 
	 * @param i
	 * @param objElem
	 * @return
	 */
	private static String getNodeNameWithSpecificObj(int i, Object objElem) {
		String nodeName = "";
		if (getObjectClassFileName(objElem).equals("EIT_Table")) {
			nodeName = String.format("%s [%d] serviceId = %d, section Number = %d, versionNumber = %d",
					getObjectClassFileName(objElem), i, ((EIT_Table) objElem).getServiceId(),
					((EIT_Table) objElem).getSectionNumber(), ((EIT_Table) objElem).getVersionNumber());
		} else {
		}
		return nodeName;
	}

	/**
	 * �ж�һ������JAVA���ͻ����û���������
	 * 
	 * @param clz
	 * @return
	 */
	public static boolean isJavaClass(Class<?> clz) {
		return clz != null && clz.getClassLoader() == null;
	}

	public static String getObjectClassFileName(Object o) {
		return o.getClass().getName().substring(o.getClass().getName().lastIndexOf(".") + 1);
	}
}
