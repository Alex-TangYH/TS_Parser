package com.alex.ts_parser.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
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
import javax.swing.tree.TreePath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.AddTableThread;
import com.alex.ts_parser.AddTableThread.SiTableType;
import com.alex.ts_parser.AddTableThread.PsiTableType;
import com.alex.ts_parser.FillEpgDataThread;
import com.alex.ts_parser.bean.EpgTableInfoBean;
import com.alex.ts_parser.bean.EpgTableModel;
import com.alex.ts_parser.bean.psi.PAT_ProgramInfo;
import com.alex.ts_parser.utils.StringResocesHelper;
import com.alex.ts_parser.utils.TS_Utils;
import com.alex.ts_parser.vo.EpgTableInfoList;
import com.alex.ts_parser.vo.ProgramInfoList;
import com.alex.ts_parser.vo.ProgramTypeInfoList;
import com.alex.ts_parser.vo.TableData;

public class MainWindow {
	public static ToastOfSwing toast;
	public static FillEpgDataThread fillEpgDataThread;
	public static JFrame frmTs;
	private JMenuBar jmbMainMenuBar;
	private Logger logger = LogManager.getLogger("MainWindow");
	private String filePath = null;
	private String fileName = null;
	private static JTree jTree;
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

		initMainPanel();
	}

	/**
	 * 初始化窗口主体内容
	 */
	private void initMainPanel() {
		initTabPanel();

		initEpgPanel();
	}

	/**
	 * 初始化epg内容
	 * 
	 * @param epgPanel
	 *            epg内容容器
	 */
	private void initEpgPanel() {
		JPanel epgPanel = new JPanel();
		epgPanel.setBorder(null);
		frmTs.getContentPane().add(epgPanel, BorderLayout.CENTER);
		epgPanel.setLayout(new BorderLayout(0, 0));

		epgInfoPanel = new JPanel();
		epgPanel.add(epgInfoPanel);
		epgInfoPanel.setLayout(new BorderLayout(0, 0));

		initEpgTitlePanel(epgPanel);
		initEpgTable();
	}

	/**
	 * 初始化主窗体
	 */
	private void initMainFrame() {
		frmTs = new JFrame();
		frmTs.setTitle(StringResocesHelper.getStringByKey("MainWindow.FrmTS.Title"));
		// 覆盖任务栏
		// frmTs.getGraphicsConfiguration().getDevice().setFullScreenWindow(frmTs);
		// 不覆盖任务栏
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
	 * 初始化EPG标题部分容器
	 * 
	 * @param parentPanel
	 *            epg标题父容器
	 */
	private void initEpgTitlePanel(JPanel parentPanel) {
		JPanel epgTitlePanel = new JPanel();
		epgTitlePanel.setLayout(new BorderLayout(0, 0));
		JLabel lbEpgTitle = new JLabel(StringResocesHelper.getStringByKey("MainWindow.TitlePanel.EPGTitle"),
				JLabel.CENTER);
		epgTitlePanel.add(lbEpgTitle);
		parentPanel.add(epgTitlePanel, BorderLayout.NORTH);

		JPanel epgButtunPanel = new JPanel();
		epgTitlePanel.add(epgButtunPanel, BorderLayout.EAST);

		JButton btnShowAllEpg = new JButton(StringResocesHelper.getStringByKey("MainWindow.ShowAllEpg"));
		epgButtunPanel.add(btnShowAllEpg);
		btnShowAllEpg.addActionListener(new showAllEpgBtnActionListener());
	}

	/**
	 * 初始化选项卡窗口
	 */
	private void initTabPanel() {
		JPanel tabPanel = new JPanel();
		frmTs.getContentPane().add(tabPanel, BorderLayout.WEST);
		tabPanel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabPanel.add(tabbedPane);

		initTreeTab(tabbedPane);

		initProgramListTab(tabbedPane);

		initProgramTypeTab(tabbedPane);

	}

	private void initProgramTypeTab(JTabbedPane tabbedPane) {
		JPanel programTypeListPanel = new JPanel();
		tabbedPane.addTab("节目类别", null, programTypeListPanel, null);
		programTypeListPanel.setLayout(new BorderLayout(0, 0));

		programTypeList = new JList<Object>();
		JScrollPane programTypeScrollPane = new JScrollPane(programTypeList);
		programTypeListPanel.add(programTypeScrollPane, BorderLayout.CENTER);
		programTypeList.addListSelectionListener(new programTypeListSelectionListener());
	}

	private void initProgramListTab(JTabbedPane tabbedPane) {
		JPanel programListPanel = new JPanel();
		tabbedPane.addTab("节目列表", null, programListPanel, null);
		programListPanel.setLayout(new BorderLayout(0, 0));

		programList = new JList<Object>();
		JScrollPane programInfoScrollPane = new JScrollPane(programList);
		programListPanel.add(programInfoScrollPane, BorderLayout.CENTER);
		programList.addListSelectionListener(new programListSelectionListener());
	}

	private void initTreeTab(JTabbedPane tabbedPane) {
		psisiTreePanel = new JPanel();
		tabbedPane.addTab(StringResocesHelper.getStringByKey("MainWindow.TitlePanel.Title"), null, psisiTreePanel,
				null);
		psisiTreePanel.setBorder(null);
		psisiTreePanel.setPreferredSize(new Dimension(400, 150));
		psisiTreePanel.setLayout(new BorderLayout(0, 0));

		treeRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("Tree.root"));
		treeModel = new MyTreeModel(treeRoot);
		jTree = new JTree(treeModel);

		psisiScrollPane = new JScrollPane();
		psisiScrollPane.setViewportView(jTree);
		psisiTreePanel.add(psisiScrollPane, BorderLayout.CENTER);
	}

	/**
	 * 初始化Epg信息表
	 */
	private void initEpgTable() {
		programInfoTable = new JTable();
		epgTableModel = new EpgTableModel(EpgTableInfoList.getInstance().getEpgTableInfolist());
		programInfoTable.setModel(epgTableModel);
		programInfoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 设置表格模式为单选
		programInfoTable.getTableHeader().setReorderingAllowed(false);// 不能整列移动
		programInfoTable.getTableHeader().setResizingAllowed(false);// 列大小不能调整
		((DefaultTableCellRenderer) programInfoTable.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);// 表头内容居中
		programInfoTable.setColumnModel(getColumn(programInfoTable, epgTableWidth, EPG_TABLE_MAX_WIDTH));
		JScrollPane scrollPane = new JScrollPane(programInfoTable);
		epgInfoPanel.add(scrollPane, BorderLayout.CENTER);

		RowSorter<EpgTableModel> sorter = new TableRowSorter<EpgTableModel>(epgTableModel);
		programInfoTable.setRowSorter(sorter);
	}

	/**
	 * 设置EPG表格列宽度
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
	 * 初始化菜单栏
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
		// OPT 增加助记符
	}

	/**
	 * 在jPanel中添加表数据树
	 * 
	 * @param jPanel
	 */
	private void addTree() {
		addPsi(treeRoot);
		addSi(treeRoot);
	}

	/**
	 * 添加si表到parentNode节点
	 * 
	 * @param parentNode
	 */
	private void addSi(DefaultMutableTreeNode parentNode) {
		DefaultMutableTreeNode siRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI"));
		parentNode.add(siRoot);
		for (SiTableType type : SiTableType.values()) {
			DefaultMutableTreeNode siTableNode = new DefaultMutableTreeNode(type);
			siRoot.add(siTableNode);
			AddTableThread addTableThread = new AddTableThread(type, siTableNode, filePath);
			addTableThread.start();
		}
	}

	/**
	 * 添加Psi表到parentNode节点
	 * 
	 * @param parentNode
	 */
	private void addPsi(DefaultMutableTreeNode parentNode) {
		DefaultMutableTreeNode psiRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI"));
		parentNode.add(psiRoot);
		for (PsiTableType type : PsiTableType.values()) {
			DefaultMutableTreeNode psiTableNode = new DefaultMutableTreeNode(type);
			psiRoot.add(psiTableNode);
			AddTableThread addTableThread = new AddTableThread(type, psiTableNode, filePath);
			addTableThread.start();
		}
	}

	/**
	 * 打开流文件事件监听类
	 * 
	 * @author Administrator
	 */
	private class ActionListener_OpenFile implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser jFileChooser = new JFileChooser(
					StringResocesHelper.getStringByKey("MainWindow.FileChooser.Default_Directory"));
			int fileChooserState = jFileChooser.showOpenDialog(null);
			if (fileChooserState == JFileChooser.APPROVE_OPTION) { // 打开文件
				filePath = jFileChooser.getSelectedFile().getAbsolutePath();
				fileName = jFileChooser.getSelectedFile().getName();
				logger.info("当前文件路径：" + filePath + ";当前文件名：" + fileName);
				if (filePath == null || filePath.isEmpty()) {
					logger.info("没有选中文件");
				} else if (TS_Utils.isResolvableFile(filePath)) {
					frmTs.setTitle(StringResocesHelper.getStringByKey("MainWindow.FrmTS.Title") + "   " + filePath);
					cleanData();
					reflashData();
					addTree();
					fillEpgDataThread = new FillEpgDataThread();
					frmTs.setEnabled(false);
					toast = new ToastOfSwing(frmTs, "解析中，请稍候", 0, ToastOfSwing.msg);
					toast.setVisible(true);
				} else {
					logger.info("不是ts、mts、trp文件");
					toast = new ToastOfSwing(frmTs, "无法解析此类型文件", 2000, ToastOfSwing.msg);
					toast.start();
				}
			} else {
				logger.info("没有选中文件");
			}
			logger.info(filePath);
		}
	}

	/**
	 * 关闭按钮监听类，清空界面数据
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
	 * 清空数据
	 * 
	 * @author Administrator
	 */
	private static void cleanData() {
		// 清空界面
		programTypeList.removeAll();
		programTypeList.repaint();
		programList.removeAll();
		programList.repaint();
		treeRoot.removeAllChildren();
		// 清空数据
		ProgramTypeInfoList.getInstance().init();
		ProgramInfoList.getInstance().init();
		TableData.getInstance().init();
		EpgTableInfoList.getInstance().init();
	}

	/**
	 * 刷新界面数据
	 * 
	 * @author Administrator
	 */
	public static void reflashData() {
		treeModel.reload();
		expandNode(treeRoot, jTree);

		reflashProgramTypeList();
		reflashProgramList();
		reflashEpgTable();
	}

	/**
	 * 展开第一层节点
	 */
	private static void expandNode(DefaultMutableTreeNode node, JTree tree) {
		int childCountAt1Leave = node.getChildCount();
		for (int i = 0; i < childCountAt1Leave; i++) {
			jTree.expandPath(new TreePath(((DefaultMutableTreeNode) node.getChildAt(i)).getPath()));
		}
	}

	/**
	 * 展开节电下全部节点
	 */
	private static void expandAllNode(DefaultMutableTreeNode node, JTree tree) {
		int childCount = node.getChildCount();
		for (int i = 0; i < childCount; i++) {
			DefaultMutableTreeNode childNode = ((DefaultMutableTreeNode) node.getChildAt(i));
			tree.expandPath(new TreePath(childNode.getPath()));
			expandAllNode(childNode, tree);
		}
	}

	/**
	 * 刷新节目类型列表数据
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
		} else {
			programTypeList.setModel(new AbstractListModel<Object>() {

				private static final long serialVersionUID = 1L;

				public int getSize() {
					return 1;
				}

				public Object getElementAt(int index) {
					return "无类型信息！";
				}

			});
		}
		programTypeList.updateUI();
	}

	/**
	 * 刷新节目列表数据
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
					return "节目号：" + values.get(index);
				}
			});
		} else if (TableData.getInstance() != null && TableData.getInstance().getPatTable() != null
				&& TableData.getInstance().getPatTable().getPatProgramInfo().length > 0) {
			PAT_ProgramInfo[] proInfoArray = TableData.getInstance().getPatTable().getPatProgramInfo();
			List<Integer> values = new LinkedList<Integer>();
			for (int index = 0; index < proInfoArray.length; index++) {
				PAT_ProgramInfo programInfo = proInfoArray[index];
				values.add(programInfo.getProgramNumber());
			}

			programList.setModel(new AbstractListModel<Object>() {

				private static final long serialVersionUID = 1L;

				public int getSize() {
					return values.size();
				}

				public Object getElementAt(int index) {
					return "节目号：" + values.get(index);
				}
			});
		} else {
			programList.setModel(new AbstractListModel<Object>() {
				private static final long serialVersionUID = 1L;

				public int getSize() {
					return 1;
				}

				public Object getElementAt(int index) {
					return "无节目！";
				}
			});
		}

		programList.updateUI();
	}

	class programTypeListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (programTypeList.getSelectedValue() != null && !programTypeList.getSelectedValue().equals("无类型信息！")) {
				List<EpgTableInfoBean> listTemp = new ArrayList<>();
				for (EpgTableInfoBean epgInfoBean : epgTableInfoListVo) {
					if (epgInfoBean.getProgramType() != null && epgInfoBean.getProgramType()
							.contains((CharSequence) programTypeList.getSelectedValue())) {
						listTemp.add(epgInfoBean);
					}
				}
				EpgTableInfoList.getInstance().getEpgTableInfolist().clear();
				EpgTableInfoList.getInstance().getEpgTableInfolist().addAll(listTemp);
				reflashEpgTable();
			}
		}
	}

	class programListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (programList.getSelectedValue() != null && !programList.getSelectedValue().equals("无节目！")
					&& epgTableInfoListVo != null) {
				List<EpgTableInfoBean> listTemp = new ArrayList<>();
				String digit = TS_Utils.getDigit((String) programList.getSelectedValue());
				for (EpgTableInfoBean epgInfoBean : epgTableInfoListVo) {
					if (digit.equals("" + epgInfoBean.getServiceId())) {
						listTemp.add(epgInfoBean);
					}
				}
				EpgTableInfoList.getInstance().getEpgTableInfolist().clear();
				EpgTableInfoList.getInstance().getEpgTableInfolist().addAll(listTemp);
				reflashEpgTable();
			}
		}
	}

	class showAllEpgBtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (epgTableInfoListVo != null) {
				EpgTableInfoList.getInstance().getEpgTableInfolist().clear();
				EpgTableInfoList.getInstance().getEpgTableInfolist().addAll(epgTableInfoListVo);
				reflashEpgTable();
			}
		}
	}

	/**
	 * 刷新Epg表数据方法
	 */
	public static synchronized void reflashEpgTable() {
		// OPT 考虑是否改为对数据进行操作时，相应的对Model进行操作
		programInfoTable.updateUI();
	}
}
