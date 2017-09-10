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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.bean.psi.CAT_Table;
import com.alex.ts_parser.bean.psi.PAT_Table;
import com.alex.ts_parser.native_function.NativeFunctionManager;
import com.alex.ts_parser.utils.ReflectUtils;
import com.alex.ts_parser.utils.StringResocesHelper;
import com.alex.ts_parser.utils.TS_Utils;

public class MainWindow {

	public JFrame frmTs;
	private JPanel jpContentPanel;
	private JMenuBar jmbMainMenuBar;
	private JPanel jpBottomPanel;
	private Logger logger = LogManager.getLogger("");
	private String filePath = null;
	private String fileName = null;
	
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
		// TODO 将各个表解析后放入jtree
		JScrollPane jScrollPane1 = new JScrollPane();

		// 树根
		DefaultMutableTreeNode treeRoot = new DefaultMutableTreeNode();
		DefaultMutableTreeNode psiRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI"));
		DefaultMutableTreeNode siRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI"));
		treeRoot.add(psiRoot);
		treeRoot.add(siRoot);

		// pat表
		DefaultMutableTreeNode patRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI.PAT"));
		PAT_Table pat = NativeFunctionManager.parsePAT(filePath);
		if (pat != null) {
			ReflectUtils.getTreeByObjAttr(pat, patRoot);
			psiRoot.add(patRoot);
		}else {
			logger.info("pat is null");
		}

		// cat表
		DefaultMutableTreeNode catRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.PSI.CAT"));
		CAT_Table cat = NativeFunctionManager.parseCAT(filePath);
		if (cat != null) {
			ReflectUtils.getTreeByObjAttr(cat, catRoot);
			psiRoot.add(catRoot);
		}else {
			logger.info("cat is null");
		}
		
		// 加入容器
		JTree tree = new JTree(treeRoot);
		jScrollPane1.setViewportView(tree);
		jPanel.add(jScrollPane1);
	}

	/**
	 * 打开流文件事件监听类
	 * 
	 * @author Administrator
	 */
	private class ActionListener_OpenFile implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser jFileChooser = new JFileChooser();
			int i = jFileChooser.showOpenDialog(null);
			if (i == JFileChooser.APPROVE_OPTION) { // 打开文件
				filePath = jFileChooser.getSelectedFile().getAbsolutePath();
				fileName = jFileChooser.getSelectedFile().getName();
				logger.info("当前文件路径：" + filePath + ";当前文件名：" + fileName);
				if (filePath == null || filePath.isEmpty()) {
					logger.info("没有选中文件");
				} else if (TS_Utils.isTsFile(filePath)) {
					frmTs.setTitle(StringResocesHelper.getStringByKey("MainWindow.FrmTS.Title") + "   " + filePath);
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
	private void cleanData()
	{
		jpContentPanel.removeAll();
		jpContentPanel.repaint();
	}
}
