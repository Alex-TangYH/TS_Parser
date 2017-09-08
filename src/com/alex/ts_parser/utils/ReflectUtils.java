package com.alex.ts_parser.utils;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.descriptor.Descriptor;

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
		}

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
					logger.info(varName + "is null");
				} else if (o.getClass().isArray()) { // 判断是否是数组
					if (!isJavaClass(o.getClass())) {
						Object[] arr = (Object[]) o; // 装换成数组
						if (field.getName().equals("descriptorArray")) {
							varName = "描述子";
						} else if (field.getName().equals("patProgramInfoArray")) {
							varName = "PMT PID信息";
						}
						DefaultMutableTreeNode arrayChilds = new DefaultMutableTreeNode(varName);
						parentNode.add(arrayChilds);
//						for (Object a : arr) {
						for (int index = 0; index < arr.length; index++) {
							Object a = arr[index];
							if (a == null) {
								logger.info("出现空描述子对象");
								continue;
							} else {
								if (a instanceof Descriptor) {
									varName = ((Descriptor) a).getDescriptorName();
									childs = new DefaultMutableTreeNode(varName);
									childs.add(new DefaultMutableTreeNode(
											"descriptorTag = " + ((Descriptor) a).getDescriptorTag()));
									childs.add(new DefaultMutableTreeNode(
											"descriptorLength = " + ((Descriptor) a).getDescriptorLength()));
									arrayChilds.add(getTreeByObjAttr(a, childs));
								} else {
									varName = getObjectClassFileName(a);
//									childs = new DefaultMutableTreeNode(varName);
									childs = new DefaultMutableTreeNode(String.format("%s [%d]", varName,index));
									arrayChilds.add(getTreeByObjAttr(a, childs));
								}
							}
						}
					} else {
						Class<?> cla = o.getClass();
						if (cla.getName().equals("[B")) {
							logger.info("变量： " + varName + " = " + Arrays.toString((byte[]) o));
							childs = new DefaultMutableTreeNode(varName + " = " + Arrays.toString((byte[]) o));
							parentNode.add(childs);
						}
					}
				} else if (!isJavaClass(o.getClass())) {
					childs = new DefaultMutableTreeNode(varName);
					getTreeByObjAttr(o, childs);
					parentNode.add(childs);
				} else {
					childs = new DefaultMutableTreeNode(varName + " = " + o);
					parentNode.add(childs);
				}
				if (!access)
					field.setAccessible(false);
			} catch (Exception ex) {
				ex.printStackTrace();
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
