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
		// 获取对象obj的所有属性域
		if (obj == null) {
			return;
		}
		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			// 对于每个属性，获取属性名
			String varName = field.getName();
			try {
				boolean access = field.isAccessible();
				if (!access)
					field.setAccessible(true);
				// 从obj中获取field变量
				Object o = field.get(obj);
				if (o == null) {
					logger.info("变量： " + varName + " = " + o);
				} else if (o.getClass().isArray()) { // 判断是否是数组
					if (!isJavaClass(o.getClass())) {
						Object[] arr = (Object[]) o; // 装换成数组
						for (Object a : arr) {
							getObjAttr(a);
						}
					} else {
						Class<?> cla = o.getClass();
						if (cla.getName().equals("[B")) {
							logger.info("变量： " + varName + " = " + Arrays.toString((byte[]) o));
						} else if (cla.getName().equals("[J")) {
							logger.info("变量： " + varName + " = " + Arrays.toString((long[]) o));
						}
					}
				} else {
					logger.info("变量： " + varName + " = " + o);
				}
				if (!access)
					field.setAccessible(false);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}


	
	/**
	 * 为obj生成以parentNode为根节点的树，也是此类的入口
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
	 * 为非数组对象生成以rootNode为树根的树
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
	 * 处理变量值，生成树
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
		} else if (o.getClass().isArray()) { // 判断是否是数组
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
		// OPT 抽离getSpecificNodeName()
		// OPT 将获取节目类型的方法提取 是否会影响效率
		String nodeName;
		switch (varName) {
		case "contentNibbleLevel1":
			String defaultTypeValueOfContentNibbleLevel1 = "Reserved for future use";
			String level1Name = ContentNibbleLevelMap.contentNibbleLevel1Map.getOrDefault(o,
					defaultTypeValueOfContentNibbleLevel1);
			nodeName = String.format("%s = %d(%s)", varName, o, level1Name);
			boolean isTypeExist = false;
			// 将类型数据存入类型数组中
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
			nodeName = String.format("%s = %s(原始数据：%d)", varName, BandwidthMap.bandwidthMap.get(o), o);
			break;
		default:
			nodeName = String.format("%s = %d", varName, o);
			break;
		}
		return nodeName;
	}

	/**
	 * 为Descriptor对象生成树节点
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
			logger.debug("变量： " + varName + " = " + Arrays.toString((byte[]) o));
			// TODO 有些变量可能处理方式不同
			childs = new DefaultMutableTreeNode(
					varName + " = " + new String((byte[]) o) + " (原始数据：" + Arrays.toString((byte[]) o) + ")");
			parentNode.add(childs);
		} else if (cla.getName().equals("[J")) {
			// logger.info("变量： " + varName + " = " + Arrays.toString((long[]) o));
			childs = new DefaultMutableTreeNode(varName + " = " + Arrays.toString((long[]) o));
			parentNode.add(childs);
		}
		return parentNode;
	}

	private static String getVarNameForArray(String varName) {
		switch (varName) {
		case "descriptorArray":
			varName = "描述符";
			break;
		case "patProgramInfoArray":
			varName = "PMT PID信息";
			break;
		case "transportStreamDsecriptorArray":
			varName = "TS流描述组";
			break;

		default:
			break;
		}
		return varName;
	}

	/**
	 * 为数组对象创建树
	 * 
	 * @param obj
	 * @param parentNode
	 */
	private static DefaultMutableTreeNode getTreeWithArrayObj(Object obj, DefaultMutableTreeNode parentNode,
			String varName) {

		if (!isJavaClass(obj.getClass())) {
			Object[] arr = (Object[]) obj; // 装换成数组
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
					logger.debug("出现空数组元素");
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
		// OPT 改成特定节点Map或者枚举
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
	 * 获取特定的对象的节点名称
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
	 * 判断一个类是JAVA类型还是用户定义类型
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
