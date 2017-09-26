package com.alex.ts_parser.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
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
import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.AddTableThread;
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
	private JTable programInfoTable;
	public static DefaultMutableTreeNode treeRoot;
	public static MyTreeModel treeModel;
	private static JList<Object> programList;
	private static JList<Object> programTypeList;
	private JScrollPane psisiScrollPane;
	private JPanel psisiTreePanel;

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

		initTitlePanel();

		initContentPanel();

		initTabPanel();
	}

	/**
	 * 初始化主窗体
	 */
	private void initMainFrame() {
		frmTs = new JFrame();
		frmTs.setTitle(StringResocesHelper.getStringByKey("MainWindow.FrmTS.Title"));
		frmTs.setBounds(100, 100, 904, 623);
		frmTs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 初始化选项卡窗口
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

		JPanel epgInfoPanel = new JPanel();
		epgPanel.add(epgInfoPanel);
		epgInfoPanel.setLayout(new BorderLayout(0, 0));

		// TODO 初始化数据
		EpgTableModel epgTableModel = new EpgTableModel(EpgTableInfoList.getInstance().getEpgTableInfolist());
		programInfoTable = new JTable();
		programInfoTable.setModel(epgTableModel);
		JScrollPane scrollPane = new JScrollPane(programInfoTable);
		epgInfoPanel.add(scrollPane, BorderLayout.CENTER);

		JPanel tabPanel = new JPanel();
		frmTs.getContentPane().add(tabPanel, BorderLayout.WEST);
		tabPanel.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabPanel.add(tabbedPane);

		psisiTreePanel = new JPanel();
		tabbedPane.addTab(StringResocesHelper.getStringByKey("MainWindow.TitlePanel.Title"), null, psisiTreePanel,
				null);
		psisiTreePanel.setBorder(null);
		psisiTreePanel.setPreferredSize(new Dimension(290, 150));
		psisiTreePanel.setLayout(new BorderLayout(0, 0));

		treeRoot = new DefaultMutableTreeNode("PSI/SI");
		treeModel = new MyTreeModel(treeRoot);
		jTree = new JTree(treeModel);

		psisiScrollPane = new JScrollPane();
		psisiScrollPane.setViewportView(jTree);
		psisiTreePanel.add(psisiScrollPane, BorderLayout.CENTER);

		JPanel programListPanel = new JPanel();
		tabbedPane.addTab("节目列表", null, programListPanel, null);
		programListPanel.setLayout(new BorderLayout(0, 0));

		programList = new JList<Object>();
		JScrollPane programInfoScrollPane = new JScrollPane(programList);
		programListPanel.add(programInfoScrollPane, BorderLayout.CENTER);

		JPanel programTypeListPanel = new JPanel();
		tabbedPane.addTab("节目类别", null, programTypeListPanel, null);
		programTypeListPanel.setLayout(new BorderLayout(0, 0));

		programTypeList = new JList<Object>();
		JScrollPane programTypeScrollPane = new JScrollPane(programTypeList);
		programTypeListPanel.add(programTypeScrollPane, BorderLayout.CENTER);
	}

	/**
	 * 初始化标题窗口
	 */
	private void initTitlePanel() {
	}

	/**
	 * 初始化中间部分窗口
	 */
	private void initContentPanel() {
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
		// TODO 增加助记符
	}

	/**
	 * 在jPanel中添加表数据树
	 * 
	 * @param jPanel
	 */
	private void addTree() {
		// 树根
		addPsiTableNode(treeRoot);
		addSiTableNode(treeRoot);
	}

	/**
	 * 添加PSI表到treeRoot
	 * 
	 * @param treeRoot
	 */
	private void addPsiTableNode(DefaultMutableTreeNode treeRoot) {
		DefaultMutableTreeNode psiRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI"));
		treeRoot.add(psiRoot);

		// cat表
		DefaultMutableTreeNode catRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI.CAT"));
		psiRoot.add(catRoot);
		AddTableThread addCatTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.PSI.CAT"), catRoot,
				filePath);
		addCatTableThread.start();

		// nit表
		DefaultMutableTreeNode nitRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI.NIT"));
		psiRoot.add(nitRoot);
		AddTableThread addNitTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.PSI.NIT"), nitRoot,
				filePath);
		addNitTableThread.start();

		// pat表
		DefaultMutableTreeNode patRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI.PAT"));
		psiRoot.add(patRoot);
		AddTableThread addPatTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.PSI.PAT"), patRoot,
				filePath);
		addPatTableThread.start();

		// pmt表
		DefaultMutableTreeNode pmtRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI.PMT"));
		psiRoot.add(pmtRoot);
		AddTableThread addPmtTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.PSI.PMT"), pmtRoot,
				filePath);
		addPmtTableThread.start();
	}

	/**
	 * 添加si表树到treeRoot节点
	 * 
	 * @param treeRoot
	 */
	private void addSiTableNode(DefaultMutableTreeNode treeRoot) {
		DefaultMutableTreeNode siRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI"));
		treeRoot.add(siRoot);

		// sdt表
		DefaultMutableTreeNode sdtRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.SDT"));
		siRoot.add(sdtRoot);
		AddTableThread addSdtTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.SDT"), sdtRoot,
				filePath);
		addSdtTableThread.start();

		// tdt表
		DefaultMutableTreeNode tdtRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.TDT"));
		siRoot.add(tdtRoot);
		AddTableThread addTdtTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.TDT"), tdtRoot,
				filePath);
		addTdtTableThread.start();

		// tot表
		DefaultMutableTreeNode totRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.TOT"));
		siRoot.add(totRoot);
		AddTableThread addTotTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.TOT"), totRoot,
				filePath);
		addTotTableThread.start();

		// st表
		DefaultMutableTreeNode stRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.ST"));
		siRoot.add(stRoot);
		AddTableThread addStTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.ST"), stRoot,
				filePath);
		addStTableThread.start();

		// dit表
		DefaultMutableTreeNode ditRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.DIT"));
		siRoot.add(ditRoot);
		AddTableThread addDitTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.DIT"), ditRoot,
				filePath);
		addDitTableThread.start();

		// rst表
		DefaultMutableTreeNode rstRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.RST"));
		siRoot.add(rstRoot);
		AddTableThread addRstTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.RST"), rstRoot,
				filePath);
		addRstTableThread.start();

		// sit表
		DefaultMutableTreeNode sitRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.SIT"));
		siRoot.add(sitRoot);
		AddTableThread addSitTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.SIT"), sitRoot,
				filePath);
		addSitTableThread.start();

		// eit表
		DefaultMutableTreeNode eitRoot = new DefaultMutableTreeNode(
				StringResocesHelper.getStringByKey("TS.SI.EIT_PF_Actual"));
		siRoot.add(eitRoot);
		AddTableThread addEitTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.EIT_PF_Actual"),
				eitRoot, filePath);
		addEitTableThread.start();

		// eit表(0x50)
		DefaultMutableTreeNode eitOther50Root = new DefaultMutableTreeNode(
				StringResocesHelper.getStringByKey("TS.SI.EIT_Schedule_Actual_50"));
		siRoot.add(eitOther50Root);
		AddTableThread addEitOther50TableThread = new AddTableThread(
				StringResocesHelper.getStringByKey("TS.SI.EIT_Schedule_Actual_50"), eitOther50Root, filePath);
		addEitOther50TableThread.start();

		// eit表(0x51)
		DefaultMutableTreeNode eitOther51Root = new DefaultMutableTreeNode(
				StringResocesHelper.getStringByKey("TS.SI.EIT_Schedule_Actual_51"));
		siRoot.add(eitOther51Root);
		AddTableThread addEitOther51TableThread = new AddTableThread(
				StringResocesHelper.getStringByKey("TS.SI.EIT_Schedule_Actual_51"), eitOther51Root, filePath);
		addEitOther51TableThread.start();

		// bat表
		DefaultMutableTreeNode batRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.BAT"));
		siRoot.add(batRoot);
		AddTableThread addBatTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.BAT"), batRoot,
				filePath);
		addBatTableThread.start();
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
				} else if (TS_Utils.isTsFile(filePath)) {
					frmTs.setTitle(StringResocesHelper.getStringByKey("MainWindow.FrmTS.Title") + "   " + filePath);
					cleanData();
					addTree();
				} else {
					logger.info("不是TS文件");
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
		}
	}

	/**
	 * 清空界面数据
	 * 
	 * @author Administrator
	 */
	private void cleanData() {
		programTypeList.removeAll();
		programTypeList.repaint();
		new LinkedList<String>();
		ProgramTypeInfoList.getInstance().setProgramTypeList(new LinkedList<String>());
		TableData.getInstance().setFinishedThreadCount(0);
	}

	/**
	 * 刷新PSI/SI界面数据
	 * 
	 * @author Administrator
	 */
	public static synchronized void reflashData() {
		treeModel.reload();
		reflashProgramTypeList();
		reflashProgramList();
	}

	public static synchronized void reflashProgramTypeList() {
		programTypeList.setModel(new AbstractListModel<Object>() {
			private static final long serialVersionUID = -2625699078063016248L;
			List<String> values = ProgramTypeInfoList.getInstance().getProgramTypeList();

			public int getSize() {
				return values.size();
			}

			public Object getElementAt(int index) {
				return values.get(index);
			}
		});
		programTypeList.validate();
		programTypeList.repaint();
	}

	public static synchronized void reflashProgramList() {
		programList.setModel(new AbstractListModel<Object>() {
			private static final long serialVersionUID = -1517802494832517338L;
			List<Integer> values = ProgramInfoList.getInstance().getProgramIdList();

			public int getSize() {
				return values.size();
			}

			public Object getElementAt(int index) {
				return values.get(index);
			}
		});
		programList.validate();
		programList.repaint();
	}
}
