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
								"%s serviceId = %d, section Number = %d, versionNumber = %d",
								getObjectClassFileName(objElem), ((EIT_Table) objElem).getServiceId(),
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
						// TODO ȥ��ע��
//						logger.info(String.format("%s is null", varName));
					} else if (o.getClass().isArray()) { // �ж��Ƿ�������
						if (!isJavaClass(o.getClass())) {
							Object[] arr = (Object[]) o; // װ��������
							if (arr.length == 0) {
								continue;
							}
							switch (field.getName()) {
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

							DefaultMutableTreeNode arrayChilds = new DefaultMutableTreeNode(varName);
							parentNode.add(arrayChilds);
							for (int index = 0; index < arr.length; index++) {
								Object a = arr[index];
								if (a == null) {
//									logger.info("���ֿ�����Ԫ��");
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
										if (varName.equals("com.alex.ts_parser.bean.si.EIT_Table")) {
											childs = new DefaultMutableTreeNode(String.format(
													"%s serviceId = %d, section Number = %d, versionNumber = %d [%d]",
													varName, ((EIT_Table) a).getServiceId(),
													((EIT_Table) a).getSectionNumber(),
													((EIT_Table) a).getVersionNumber(), index));
										} else {
											childs = new DefaultMutableTreeNode(
													String.format("%s [%d]", varName, index));
										}
										arrayChilds.add(getTreeByObjAttr(a, childs));
									}
								}
							}
						} else {
							Class<?> cla = o.getClass();
							if (cla.getName().equals("[B")) {
								// logger.info("������ " + varName + " = " + Arrays.toString((byte[]) o));
								// TODO ��Щ�������ܴ���ʽ��ͬ
								childs = new DefaultMutableTreeNode(varName + " = " + new String((byte[]) o) + " (ԭʼ���ݣ�"
										+ Arrays.toString((byte[]) o) + ")");
								parentNode.add(childs);
							} else if (cla.getName().equals("[J")) {
								// logger.info("������ " + varName + " = " + Arrays.toString((long[]) o));
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
							nodeName = String.format("%s = %d(%s)", varName, o,
									ContentNibbleLevelMap.contentNibbleLevel1Map.get(o));
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
