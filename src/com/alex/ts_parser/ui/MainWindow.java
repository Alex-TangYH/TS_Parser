package com.alex.ts_parser.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.AddTableThread;
import com.alex.ts_parser.utils.StringResocesHelper;
import com.alex.ts_parser.utils.TS_Utils;

public class MainWindow {

	public JFrame frmTs;
	private static JPanel jpContentPanel;
	private JMenuBar jmbMainMenuBar;
	private JPanel jpBottomPanel;
	private Logger logger = LogManager.getLogger("MainWindow");
	private String filePath = null;
	private String fileName = null;
	public static DefaultMutableTreeNode treeRoot;
	private static DefaultTreeModel treeModel;
	private JTree jTree;
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

		initBottomPanel();

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
	 * 初始化底部窗口
	 */
	private void initBottomPanel() {
		jpBottomPanel = new JPanel();
		frmTs.getContentPane().add(jpBottomPanel, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton(StringResocesHelper.getStringByKey("MainWindow.Button.PSI_SI"));
		jpBottomPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(StringResocesHelper.getStringByKey("MainWindow.Button.EPG"));
		jpBottomPanel.add(btnNewButton_1);
	}

	/**
	 * 初始化标题窗口
	 */
	private void initTitlePanel() {
		JPanel titlePanel = new JPanel();
		frmTs.getContentPane().add(titlePanel, BorderLayout.NORTH);
		JLabel lbTitle = new JLabel(StringResocesHelper.getStringByKey("MainWindow.TitlePanel.Title"));
		titlePanel.add(lbTitle);
	}

	/**
	 * 初始化中间部分窗口
	 */
	private void initContentPanel() {
		jpContentPanel = new JPanel();
		frmTs.getContentPane().add(jpContentPanel, BorderLayout.CENTER);
		jpContentPanel.setLayout(new BorderLayout(0, 0));
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
		// mniOpen.setAccelerator(KeyStroke.getKeyStroke('O'));
		// mniOpen.setMnemonic('O');
	}

	/**
	 * 在jPanel中添加表数据树
	 * 
	 * @param jPanel
	 */
	private void addTree(JPanel jPanel) {
		JScrollPane jScrollPane1 = new JScrollPane();
		// 树根
		treeRoot = new DefaultMutableTreeNode();
		
		jTree = new JTree(treeRoot);
		treeModel = (DefaultTreeModel) jTree.getModel();  
		
		addPsiTableNode(treeRoot);
		addSiTableNode(treeRoot);

		// 加入容器
		jScrollPane1.setViewportView(jTree);
		jPanel.add(jScrollPane1);
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
		DefaultMutableTreeNode eitRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.EIT"));
		siRoot.add(eitRoot);
		AddTableThread addEitTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.EIT"), eitRoot,
				filePath);
		addEitTableThread.start();

		// eit表(0x50)
		DefaultMutableTreeNode eitOther50Root = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.EIT_OTHER_50"));
		siRoot.add(eitOther50Root);
		AddTableThread addEitOther50TableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.EIT_OTHER_50"), eitOther50Root,
				filePath);
		addEitOther50TableThread.start();
		
		// eit表(0x51)
		DefaultMutableTreeNode eitOther51Root = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.EIT_OTHER_51"));
		siRoot.add(eitOther51Root);
		AddTableThread addEitOther51TableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.EIT_OTHER_51"), eitOther51Root,
				filePath);
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
					addTree(jpContentPanel);
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
		jpContentPanel.removeAll();
		jpContentPanel.repaint();
	}
	
	/**
	 * 刷新PSI/SI界面数据
	 * 
	 * @author Administrator
	 */
	public static void reflashData() {
		treeModel.reload();		
	}
}
