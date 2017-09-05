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
	Logger logger = LogManager.getLogger("");

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
		frmTs.setTitle("TS\u6D41\u89E3\u6790\u7A0B\u5E8F");
		frmTs.setBounds(100, 100, 904, 623);
		frmTs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 初始化底部窗口
	 */
	private void initBottomPanel() {
		jpBottomPanel = new JPanel();
		frmTs.getContentPane().add(jpBottomPanel, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("PSI/SI");
		jpBottomPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("EPG");
		jpBottomPanel.add(btnNewButton_1);
	}

	/**
	 * 初始化标题窗口
	 */
	private void initTitlePanel() {
		JPanel titlePanel = new JPanel();
		frmTs.getContentPane().add(titlePanel, BorderLayout.NORTH);
		JLabel lbTitle = new JLabel("PSI/SI \u5B8C\u5168\u89E3\u6790");
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

		// pat表
		DefaultMutableTreeNode patRoot = new DefaultMutableTreeNode("PAT");
		PAT_Table pat = NativeFunctionManager.parsePAT();
		ReflectUtils.getTreeByObjAttr(pat, patRoot);
		JTree tree = new JTree(patRoot);

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
			String filePath = null;
			String name = null;

			int i = jFileChooser.showOpenDialog(null);
			if (i == JFileChooser.APPROVE_OPTION) { // 打开文件
				filePath = jFileChooser.getSelectedFile().getAbsolutePath();
				name = jFileChooser.getSelectedFile().getName();
				logger.info("当前文件路径：" + filePath + ";当前文件名：" + name);
				if (filePath == null || filePath.isEmpty()) {
					logger.info("没有选中文件");
				} else if (TS_Utils.isTsFile(filePath)) {
					frmTs.setTitle("TS\u6D41\u89E3\u6790\u7A0B\u5E8F" + "   " + filePath);
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
}
