package com.alex.ts_parser.utils;

import java.lang.reflect.Field;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReflectUtils {
	private static Logger logger = LogManager.getLogger("");

	public static void getObjAttr(Object obj) {
		// ��ȡ����obj������������
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
					Object[] arr = (Object[]) o; // װ��������
					for (Object a : arr) {
						getObjAttr(a);
					}
				} else {
					System.out.println("������ " + varName + " = " + o);
				}

				if (!access)
					field.setAccessible(false);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static DefaultMutableTreeNode getTreeByObjAttr(Object obj, DefaultMutableTreeNode parentNode) {
		// ��ȡ����obj������������
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
				DefaultMutableTreeNode childs = null;
				if (o == null) {
					logger.info(varName + "is null");
				} else if (o.getClass().isArray()) { // �ж��Ƿ�������
					Object[] arr = (Object[]) o; // װ��������
					DefaultMutableTreeNode arrayChilds = new DefaultMutableTreeNode(varName);
					parentNode.add(arrayChilds);
					for (Object a : arr) {
						childs = new DefaultMutableTreeNode(varName);
						arrayChilds.add(getTreeByObjAttr(a, childs));
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
	 * �ж�һ������JAVA���ͻ����û���������
	 * 
	 * @param clz
	 * @return
	 */
	public static boolean isJavaClass(Class<?> clz) {
		return clz != null && clz.getClassLoader() == null;
	}
}
