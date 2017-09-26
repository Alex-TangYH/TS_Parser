package com.alex.ts_parser.utils;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.descriptor.ContentInfo;
import com.alex.ts_parser.bean.descriptor.ContentNibbleLevelMap;
import com.alex.ts_parser.bean.descriptor.Descriptor;
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

	public static DefaultMutableTreeNode getTreeByObjAttr(Object obj, DefaultMutableTreeNode parentNode) {
		if (obj == null) {
			DefaultMutableTreeNode nullNode = new DefaultMutableTreeNode("");
			return nullNode;
		} else if (obj.getClass().isArray()) {
			Object[] arr = (Object[]) obj;
			for (int i = 0; i < arr.length; i++) {
				Object objElem = arr[i];
				if (objElem != null) {
					DefaultMutableTreeNode objNode;
					if (getObjectClassFileName(objElem).equals("EIT_Table")) {
						objNode = new DefaultMutableTreeNode(String.format(
								"%s [%d] serviceId = %d, section Number = %d, versionNumber = %d",
								getObjectClassFileName(objElem), i, ((EIT_Table) objElem).getServiceId(),
								((EIT_Table) objElem).getSectionNumber(), ((EIT_Table) objElem).getVersionNumber()));
					} else {
						objNode = new DefaultMutableTreeNode(
								String.format("%s [%d]", getObjectClassFileName(objElem), i));
					}
					getTreeByObjAttr(objElem, objNode);
					parentNode.add(objNode);
				}
			}

		} else {
			// 获取对象obj的所有属性域
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
					DefaultMutableTreeNode childs = null;
					if (o == null) {
						// TODO 去除注释
						// logger.info(String.format("%s is null", varName));
					} else if (o.getClass().isArray()) { // 判断是否是数组
						if (!isJavaClass(o.getClass())) {
							Object[] arr = (Object[]) o; // 装换成数组
							if (arr.length == 0) {
								continue;
							}
							switch (field.getName()) {
							case "descriptorArray":
								varName = "描述子";
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

							DefaultMutableTreeNode arrayChilds = new DefaultMutableTreeNode(varName);
							parentNode.add(arrayChilds);
							for (int index = 0; index < arr.length; index++) {
								Object a = arr[index];
								if (a == null) {
									// logger.info("出现空数组元素");
									continue;
								} else {
									if (a instanceof Descriptor) {
										varName = ((Descriptor) a).getDescriptorName();
										childs = new DefaultMutableTreeNode(varName);

										if (!a.getClass().getName()
												.equals("com.alex.ts_parser.bean.descriptor.Descriptor")) {
											childs.add(new DefaultMutableTreeNode(
													"descriptorTag = " + ((Descriptor) a).getDescriptorTag()));
											childs.add(new DefaultMutableTreeNode(
													"descriptorLength = " + ((Descriptor) a).getDescriptorLength()));
										}
										arrayChilds.add(getTreeByObjAttr(a, childs));
									} else {
										varName = getObjectClassFileName(a);
										childs = new DefaultMutableTreeNode(String.format("%s [%d]", varName, index));
										arrayChilds.add(getTreeByObjAttr(a, childs));
									}
								}
							}
						} else {
							Class<?> cla = o.getClass();
							if (cla.getName().equals("[B")) {
								// logger.info("变量： " + varName + " = " + Arrays.toString((byte[]) o));
								// TODO 有些变量可能处理方式不同
								childs = new DefaultMutableTreeNode(varName + " = " + new String((byte[]) o) + " (原始数据："
										+ Arrays.toString((byte[]) o) + ")");
								parentNode.add(childs);
							} else if (cla.getName().equals("[J")) {
								// logger.info("变量： " + varName + " = " + Arrays.toString((long[]) o));
								childs = new DefaultMutableTreeNode(varName + " = " + Arrays.toString((long[]) o));
								parentNode.add(childs);
							}
						}
					} else if (!isJavaClass(o.getClass())) {
						childs = new DefaultMutableTreeNode(varName);
						getTreeByObjAttr(o, childs);
						parentNode.add(childs);
					} else {
						String nodeName = "";
						switch (varName) {
						case "contentNibbleLevel1":
							String level1Name = ContentNibbleLevelMap.contentNibbleLevel1Map.get(o);
							if (level1Name != null) {
								nodeName = String.format("%s = %d(%s)", varName, o, level1Name);
								boolean isTypeExist = false;
								// 将类型数据存入类型数组中
								for (int i = 0; i < ProgramTypeInfoList.getInstance().getProgramTypeList()
										.size(); i++) {
									if (level1Name
											.equals(ProgramTypeInfoList.getInstance().getProgramTypeList().get(i))) {
										isTypeExist = true;
										break;
									}
								}

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

							} else {
								// TODO 输出保留类型
								nodeName = String.format("%s = %d", varName, o);
							}

							break;
						case "contentNibbleLevel2":
							nodeName = String.format("%s = %d(%s)", varName, o,
									ContentNibbleLevelMap.contentNibbleLevel2Map.get(
											new Integer(((ContentInfo) obj).getContentNibbleLevel1()) * 16 + (int) o));
							break;

						default:
							nodeName = String.format("%s = %d", varName, o);
							break;
						}

						childs = new DefaultMutableTreeNode(nodeName);
						parentNode.add(childs);
					}
					if (!access)
						field.setAccessible(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return parentNode;

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
