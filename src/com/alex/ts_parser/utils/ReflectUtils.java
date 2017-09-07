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
							System.out.println("变量： " + varName + " = " + Arrays.toString((byte[]) o));
						}
					}
				} else {
					System.out.println("变量： " + varName + " = " + o);
				}

				if (!access)
					field.setAccessible(false);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static DefaultMutableTreeNode getTreeByObjAttr(Object obj, DefaultMutableTreeNode parentNode) {
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
						if(field.getName().equals("descriptorArray")) {
							varName = "描述子";
						}
						DefaultMutableTreeNode arrayChilds = new DefaultMutableTreeNode(varName);
						parentNode.add(arrayChilds);
						for (Object a : arr) {
							System.out.println(a.getClass().toString());
							if(a instanceof Descriptor) {
								varName = ((Descriptor) a).getDescriptorName();
							}else {
							}
							childs = new DefaultMutableTreeNode(varName);
							arrayChilds.add(getTreeByObjAttr(a, childs));
						}
					} else {
						Class<?> cla = o.getClass();
						if (cla.getName().equals("[B")) {
							System.out.println("变量： " + varName + " = " + Arrays.toString((byte[]) o));
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
}
