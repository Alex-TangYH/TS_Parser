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

	public static DefaultMutableTreeNode getTreeByObjAttr(Object obj, DefaultMutableTreeNode parentNode) {
		if (obj == null) {
			DefaultMutableTreeNode nullNode = new DefaultMutableTreeNode("");
			return nullNode;
		}

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
					if (!isJavaClass(o.getClass())) {
						Object[] arr = (Object[]) o; // װ��������
						if (field.getName().equals("descriptorArray")) {
							varName = "������";
						} else if (field.getName().equals("patProgramInfoArray")) {
							varName = "PMT PID��Ϣ";
						}
						DefaultMutableTreeNode arrayChilds = new DefaultMutableTreeNode(varName);
						parentNode.add(arrayChilds);
//						for (Object a : arr) {
						for (int index = 0; index < arr.length; index++) {
							Object a = arr[index];
							if (a == null) {
								logger.info("���ֿ������Ӷ���");
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
							logger.info("������ " + varName + " = " + Arrays.toString((byte[]) o));
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
