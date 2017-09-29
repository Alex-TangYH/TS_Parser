package com.alex.ts_parser.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.AddTableThread;
import com.alex.ts_parser.FillEpgDataThread;
import com.alex.ts_parser.bean.EpgTableInfoBean;
import com.alex.ts_parser.bean.EpgTableModel;
import com.alex.ts_parser.utils.StringResocesHelper;
import com.alex.ts_parser.utils.TS_Utils;
import com.alex.ts_parser.vo.EpgTableInfoList;
import com.alex.ts_parser.vo.ProgramInfoList;
import com.alex.ts_parser.vo.ProgramTypeInfoList;
import com.alex.ts_parser.vo.TableData;

public class MainWindow {

	public JFrame frmTs;
	private JMenuBar jmbMainMenuBar;
	private Logger logger = LogManager.getLogger("MainWindow");
	private String filePath = null;
	private String fileName = null;
	private JTree jTree;
	public static JTable programInfoTable;
	public static DefaultMutableTreeNode treeRoot;
	public static MyTreeModel treeModel;
	private static JList<Object> programList;
	private static JList<Object> programTypeList;
	private JScrollPane psisiScrollPane;
	private JPanel psisiTreePanel;
	private static EpgTableModel epgTableModel;
	public static List<EpgTableInfoBean> epgTableInfoListVo;
	private JPanel epgInfoPanel;
	private int[] epgTableWidth = { 60, 50, 50, 130, 70, 130, 130, 130, 80, 0 };
	private final int EPG_TABLE_MAX_WIDTH = 1015;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initMainFrame();

		initMenu();

		initTabPanel();
	}

	/**
	 * ��ʼ��������
	 */
	private void initMainFrame() {
		frmTs = new JFrame();
		frmTs.setTitle(StringResocesHelper.getStringByKey("MainWindow.FrmTS.Title"));
		// ����������
		// frmTs.getGraphicsConfiguration().getDevice().setFullScreenWindow(frmTs);
		// ������������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle bounds = new Rectangle(screenSize);
		Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(frmTs.getGraphicsConfiguration());
		bounds.x += insets.left;
		bounds.y += insets.top;
		bounds.width -= insets.left + insets.right;
		bounds.height -= insets.top + insets.bottom;
		frmTs.setBounds(bounds);
		frmTs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * ��ʼ��ѡ�����
	 */
	private void initTabPanel() {
		JPanel epgPanel = new JPanel();
		epgPanel.setBorder(null);
		frmTs.getContentPane().add(epgPanel, BorderLayout.CENTER);
		epgPanel.setLayout(new BorderLayout(0, 0));

		JPanel epgTitlePanel = new JPanel();
		JLabel lbEpgTitle = new JLabel(StringResocesHelper.getStringByKey("MainWindow.TitlePanel.EPGTitle"));
		epgTitlePanel.add(lbEpgTitle);
		epgPanel.add(epgTitlePanel, BorderLayout.NORTH);

		epgInfoPanel = new JPanel();
		epgPanel.add(epgInfoPanel);
		epgInfoPanel.setLayout(new BorderLayout(0, 0));

		initEpgTable();

		JPanel tabPanel = new JPanel();
		frmTs.getContentPane().add(tabPanel, BorderLayout.WEST);
		tabPanel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabPanel.add(tabbedPane);

		psisiTreePanel = new JPanel();
		tabbedPane.addTab(StringResocesHelper.getStringByKey("MainWindow.TitlePanel.Title"), null, psisiTreePanel,
				null);
		psisiTreePanel.setBorder(null);
		psisiTreePanel.setPreferredSize(new Dimension(400, 150));
		psisiTreePanel.setLayout(new BorderLayout(0, 0));

		treeRoot = new DefaultMutableTreeNode("PSI/SI");
		treeModel = new MyTreeModel(treeRoot);
		jTree = new JTree(treeModel);

		psisiScrollPane = new JScrollPane();
		psisiScrollPane.setViewportView(jTree);
		psisiTreePanel.add(psisiScrollPane, BorderLayout.CENTER);

		JPanel programListPanel = new JPanel();
		tabbedPane.addTab("��Ŀ�б�", null, programListPanel, null);
		programListPanel.setLayout(new BorderLayout(0, 0));

		programList = new JList<Object>();
		JScrollPane programInfoScrollPane = new JScrollPane(programList);
		programListPanel.add(programInfoScrollPane, BorderLayout.CENTER);

		JPanel programTypeListPanel = new JPanel();
		tabbedPane.addTab("��Ŀ���", null, programTypeListPanel, null);
		programTypeListPanel.setLayout(new BorderLayout(0, 0));

		programTypeList = new JList<Object>();
		JScrollPane programTypeScrollPane = new JScrollPane(programTypeList);
		programTypeListPanel.add(programTypeScrollPane, BorderLayout.CENTER);

		programList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				List<EpgTableInfoBean> listTemp = new ArrayList<>();
				for (EpgTableInfoBean epgInfoBean : epgTableInfoListVo) {
					// TODO �ĳɻ�ȡ����
					if (epgInfoBean.getServiceId() != 0 && programList.getSelectedValue() != null
							&& ((String) programList.getSelectedValue()).substring(4)
									.equals("" + epgInfoBean.getServiceId())) {
						listTemp.add(epgInfoBean);
					}
				}
				EpgTableInfoList.getInstance().getEpgTableInfolist().clear();
				EpgTableInfoList.getInstance().getEpgTableInfolist().addAll(listTemp);
				reflashEpgTable();
			}
		});

		programTypeList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				List<EpgTableInfoBean> listTemp = new ArrayList<>();
				for (EpgTableInfoBean epgInfoBean : epgTableInfoListVo) {
					if (epgInfoBean.getProgramType() != null && programTypeList.getSelectedValue() != null
							&& programTypeList.getSelectedValue().equals(epgInfoBean.getProgramType())) {
						listTemp.add(epgInfoBean);
					}
				}
				EpgTableInfoList.getInstance().getEpgTableInfolist().clear();
				EpgTableInfoList.getInstance().getEpgTableInfolist().addAll(listTemp);
				reflashEpgTable();
			}
		});

	}

	/**
	 * ��ʼ��Epg��Ϣ��
	 */
	private void initEpgTable() {
		programInfoTable = new JTable();
		epgTableModel = new EpgTableModel(EpgTableInfoList.getInstance().getEpgTableInfolist());
		programInfoTable.setModel(epgTableModel);
		programInfoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ���ñ��ģʽΪ��ѡ
		programInfoTable.getTableHeader().setReorderingAllowed(false);// ���������ƶ�
		programInfoTable.getTableHeader().setResizingAllowed(false);// �д�С���ܵ���
		((DefaultTableCellRenderer) programInfoTable.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);// ��ͷ���ݾ���
		programInfoTable.setColumnModel(getColumn(programInfoTable, epgTableWidth, EPG_TABLE_MAX_WIDTH));
		JScrollPane scrollPane = new JScrollPane(programInfoTable);
		epgInfoPanel.add(scrollPane, BorderLayout.CENTER);

		RowSorter<EpgTableModel> sorter = new TableRowSorter<EpgTableModel>(epgTableModel);
		programInfoTable.setRowSorter(sorter);
	}

	/**
	 * ����EPG����п��
	 * 
	 * @param table
	 * @param width
	 * @param maxWidth
	 * @return
	 */
	private TableColumnModel getColumn(JTable table, int[] width, int maxWidth) {
		int otherLength = 0;
		for (int i : width) {
			otherLength += i;
		}
		width[width.length - 1] = maxWidth - otherLength;
		TableColumnModel columns = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			TableColumn column = columns.getColumn(i);
			column.setPreferredWidth(width[i]);
		}
		return columns;
	}

	/**
	 * ��ʼ���˵���
	 */
	private void initMenu() {
		jmbMainMenuBar = new JMenuBar();
		jmbMainMenuBar.setBorderPainted(false);
		frmTs.setJMenuBar(jmbMainMenuBar);

		JMenu mnFileMenu = new JMenu(StringResocesHelper.getStringByKey("MainWindow.MenuBar.MenuItem.File"));
		jmbMainMenuBar.add(mnFileMenu);

		JMenuItem mniOpen = new JMenuItem(StringResocesHelper.getStringByKey("MainWindow.MenuBar.MenuItem.Open"));
		mnFileMenu.add(mniOpen);
		mniOpen.addActionListener(new ActionListener_OpenFile());

		JMenuItem mniClose = new JMenuItem(StringResocesHelper.getStringByKey("MainWindow.MenuBar.MenuItem.Close"));
		mnFileMenu.add(mniClose);
		mniClose.addActionListener(new ActionListener_Close());

		JMenuItem mniHelp = new JMenuItem(StringResocesHelper.getStringByKey("MainWindow.MenuBar.MenuItem.Help"));
		jmbMainMenuBar.add(mniHelp);
		// TODO �������Ƿ�
	}

	/**
	 * ��jPanel����ӱ�������
	 * 
	 * @param jPanel
	 */
	private void addTree() {
		// ����
		addPsiTableNode(treeRoot);
		addSiTableNode(treeRoot);
	}

	/**
	 * ���PSI��treeRoot
	 * 
	 * @param treeRoot
	 */
	private void addPsiTableNode(DefaultMutableTreeNode treeRoot) {
		DefaultMutableTreeNode psiRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI"));
		treeRoot.add(psiRoot);

		// cat��
		DefaultMutableTreeNode catRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI.CAT"));
		psiRoot.add(catRoot);
		AddTableThread addCatTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.PSI.CAT"), catRoot,
				filePath);
		addCatTableThread.start();

		// nit��
		DefaultMutableTreeNode nitRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI.NIT"));
		psiRoot.add(nitRoot);
		AddTableThread addNitTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.PSI.NIT"), nitRoot,
				filePath);
		addNitTableThread.start();

		// pat��
		DefaultMutableTreeNode patRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI.PAT"));
		psiRoot.add(patRoot);
		AddTableThread addPatTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.PSI.PAT"), patRoot,
				filePath);
		addPatTableThread.start();

		// pmt��
		DefaultMutableTreeNode pmtRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI.PMT"));
		psiRoot.add(pmtRoot);
		AddTableThread addPmtTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.PSI.PMT"), pmtRoot,
				filePath);
		addPmtTableThread.start();
	}

	/**
	 * ���si������treeRoot�ڵ�
	 * 
	 * @param treeRoot
	 */
	private void addSiTableNode(DefaultMutableTreeNode treeRoot) {
		DefaultMutableTreeNode siRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI"));
		treeRoot.add(siRoot);

		// sdt��
		DefaultMutableTreeNode sdtRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.SDT"));
		siRoot.add(sdtRoot);
		AddTableThread addSdtTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.SDT"), sdtRoot,
				filePath);
		addSdtTableThread.start();

		// tdt��
		DefaultMutableTreeNode tdtRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.TDT"));
		siRoot.add(tdtRoot);
		AddTableThread addTdtTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.TDT"), tdtRoot,
				filePath);
		addTdtTableThread.start();

		// tot��
		DefaultMutableTreeNode totRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.TOT"));
		siRoot.add(totRoot);
		AddTableThread addTotTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.TOT"), totRoot,
				filePath);
		addTotTableThread.start();

		// st��
		DefaultMutableTreeNode stRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.ST"));
		siRoot.add(stRoot);
		AddTableThread addStTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.ST"), stRoot,
				filePath);
		addStTableThread.start();

		// dit��
		DefaultMutableTreeNode ditRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.DIT"));
		siRoot.add(ditRoot);
		AddTableThread addDitTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.DIT"), ditRoot,
				filePath);
		addDitTableThread.start();

		// rst��
		DefaultMutableTreeNode rstRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.RST"));
		siRoot.add(rstRoot);
		AddTableThread addRstTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.RST"), rstRoot,
				filePath);
		addRstTableThread.start();

		// sit��
		DefaultMutableTreeNode sitRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.SIT"));
		siRoot.add(sitRoot);
		AddTableThread addSitTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.SIT"), sitRoot,
				filePath);
		addSitTableThread.start();

		// eit��
		DefaultMutableTreeNode eitRoot = new DefaultMutableTreeNode(
				StringResocesHelper.getStringByKey("TS.SI.EIT_PF_Actual"));
		siRoot.add(eitRoot);
		AddTableThread addEitTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.EIT_PF_Actual"),
				eitRoot, filePath);
		addEitTableThread.start();

		// eit��(0x50)
		DefaultMutableTreeNode eitOther50Root = new DefaultMutableTreeNode(
				StringResocesHelper.getStringByKey("TS.SI.EIT_Schedule_Actual_50"));
		siRoot.add(eitOther50Root);
		AddTableThread addEitOther50TableThread = new AddTableThread(
				StringResocesHelper.getStringByKey("TS.SI.EIT_Schedule_Actual_50"), eitOther50Root, filePath);
		addEitOther50TableThread.start();

		// eit��(0x51)
		DefaultMutableTreeNode eitOther51Root = new DefaultMutableTreeNode(
				StringResocesHelper.getStringByKey("TS.SI.EIT_Schedule_Actual_51"));
		siRoot.add(eitOther51Root);
		AddTableThread addEitOther51TableThread = new AddTableThread(
				StringResocesHelper.getStringByKey("TS.SI.EIT_Schedule_Actual_51"), eitOther51Root, filePath);
		addEitOther51TableThread.start();

		// bat��
		DefaultMutableTreeNode batRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.BAT"));
		siRoot.add(batRoot);
		AddTableThread addBatTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.BAT"), batRoot,
				filePath);
		addBatTableThread.start();
	}

	/**
	 * �����ļ��¼�������
	 * 
	 * @author Administrator
	 */
	private class ActionListener_OpenFile implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser jFileChooser = new JFileChooser(
					StringResocesHelper.getStringByKey("MainWindow.FileChooser.Default_Directory"));
			int fileChooserState = jFileChooser.showOpenDialog(null);
			if (fileChooserState == JFileChooser.APPROVE_OPTION) { // ���ļ�
				filePath = jFileChooser.getSelectedFile().getAbsolutePath();
				fileName = jFileChooser.getSelectedFile().getName();
				logger.info("��ǰ�ļ�·����" + filePath + ";��ǰ�ļ�����" + fileName);
				if (filePath == null || filePath.isEmpty()) {
					logger.info("û��ѡ���ļ�");
				} else if (TS_Utils.isTsFile(filePath)) {
					frmTs.setTitle(StringResocesHelper.getStringByKey("MainWindow.FrmTS.Title") + "   " + filePath);
					cleanData();
					addTree();
					new FillEpgDataThread().start();
				} else {
					logger.info("����TS�ļ�");
				}
			} else {
				logger.info("û��ѡ���ļ�");
			}
			logger.info(filePath);
		}
	}

	/**
	 * �رհ�ť�����࣬��ս�������
	 * 
	 * @author Administrator
	 */
	private class ActionListener_Close implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			cleanData();
			reflashData();
		}
	}

	/**
	 * �������
	 * 
	 * @author Administrator
	 */
	private void cleanData() {
		// ��ս���
		programTypeList.removeAll();
		programTypeList.repaint();
		programList.removeAll();
		programList.repaint();
		treeRoot.removeAllChildren();
		// �������
		ProgramTypeInfoList.getInstance().init();
		ProgramInfoList.getInstance().init();
		TableData.getInstance().init();
		EpgTableInfoList.getInstance().init();
	}

	/**
	 * ˢ�½�������
	 * 
	 * @author Administrator
	 */
	public static synchronized void reflashData() {
		treeModel.reload();
		reflashProgramTypeList();
		reflashProgramList();
		reflashEpgTable();
	}

	/**
	 * ˢ�½�Ŀ�����б�����
	 */
	public static synchronized void reflashProgramTypeList() {
		if (ProgramTypeInfoList.getInstance().getProgramTypeList().size() > 0) {
			programTypeList.setModel(new AbstractListModel<Object>() {
				private static final long serialVersionUID = 1L;
				List<String> values = ProgramTypeInfoList.getInstance().getProgramTypeList();
				
				public int getSize() {
					return values.size();
				}
				
				public Object getElementAt(int index) {
					return values.get(index);
				}
			});
		}else {
			programTypeList.setModel(new AbstractListModel<Object>() {
				private static final long serialVersionUID = 1L;

				public int getSize() {
					return 1;
				}

				public Object getElementAt(int index) {
					return "��������Ϣ��";
				}
			});
		}
		programTypeList.validate();
		programTypeList.repaint();
	}

	/**
	 * ˢ�½�Ŀ�б�����
	 */
	public static synchronized void reflashProgramList() {
		if (ProgramInfoList.getInstance().getProgramIdList().size() > 0) {
			programList.setModel(new AbstractListModel<Object>() {
				private static final long serialVersionUID = 1L;
				List<Integer> values = ProgramInfoList.getInstance().getProgramIdList();

				public int getSize() {
					return values.size();
				}

				public Object getElementAt(int index) {
					return "��Ŀ�ţ�" + values.get(index);
				}
			});
		} else {
			programList.setModel(new AbstractListModel<Object>() {
				private static final long serialVersionUID = 1L;

				public int getSize() {
					return 1;
				}

				public Object getElementAt(int index) {
					return "�޽�Ŀ��";
				}
			});
		}

		programList.validate();
		programList.repaint();
	}

	/**
	 * ˢ��Epg�����ݷ���
	 */
	public static synchronized void reflashEpgTable() {
		// TOOD �����Ƿ��Ϊ�����ݽ��в���ʱ����Ӧ�Ķ�Model���в���
		programInfoTable.revalidate();
	}
}
