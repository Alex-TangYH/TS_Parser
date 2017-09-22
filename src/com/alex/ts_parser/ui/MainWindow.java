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
	 * ��ʼ��������
	 */
	private void initMainFrame() {
		frmTs = new JFrame();
		frmTs.setTitle(StringResocesHelper.getStringByKey("MainWindow.FrmTS.Title"));
		frmTs.setBounds(100, 100, 904, 623);
		frmTs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * ��ʼ���ײ�����
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
	 * ��ʼ�����ⴰ��
	 */
	private void initTitlePanel() {
		JPanel titlePanel = new JPanel();
		frmTs.getContentPane().add(titlePanel, BorderLayout.NORTH);
		JLabel lbTitle = new JLabel(StringResocesHelper.getStringByKey("MainWindow.TitlePanel.Title"));
		titlePanel.add(lbTitle);
	}

	/**
	 * ��ʼ���м䲿�ִ���
	 */
	private void initContentPanel() {
		jpContentPanel = new JPanel();
		frmTs.getContentPane().add(jpContentPanel, BorderLayout.CENTER);
		jpContentPanel.setLayout(new BorderLayout(0, 0));
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
		// mniOpen.setAccelerator(KeyStroke.getKeyStroke('O'));
		// mniOpen.setMnemonic('O');
	}

	/**
	 * ��jPanel����ӱ�������
	 * 
	 * @param jPanel
	 */
	private void addTree(JPanel jPanel) {
		JScrollPane jScrollPane1 = new JScrollPane();
		// ����
		treeRoot = new DefaultMutableTreeNode();
		
		jTree = new JTree(treeRoot);
		treeModel = (DefaultTreeModel) jTree.getModel();  
		
		addPsiTableNode(treeRoot);
		addSiTableNode(treeRoot);

		// ��������
		jScrollPane1.setViewportView(jTree);
		jPanel.add(jScrollPane1);
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
		DefaultMutableTreeNode eitRoot = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.EIT"));
		siRoot.add(eitRoot);
		AddTableThread addEitTableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.EIT"), eitRoot,
				filePath);
		addEitTableThread.start();

		// eit��(0x50)
		DefaultMutableTreeNode eitOther50Root = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.EIT_OTHER_50"));
		siRoot.add(eitOther50Root);
		AddTableThread addEitOther50TableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.EIT_OTHER_50"), eitOther50Root,
				filePath);
		addEitOther50TableThread.start();
		
		// eit��(0x51)
		DefaultMutableTreeNode eitOther51Root = new DefaultMutableTreeNode(StringResocesHelper.getStringByKey("TS.SI.EIT_OTHER_51"));
		siRoot.add(eitOther51Root);
		AddTableThread addEitOther51TableThread = new AddTableThread(StringResocesHelper.getStringByKey("TS.SI.EIT_OTHER_51"), eitOther51Root,
				filePath);
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
					addTree(jpContentPanel);
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
		}
	}

	/**
	 * ��ս�������
	 * 
	 * @author Administrator
	 */
	private void cleanData() {
		jpContentPanel.removeAll();
		jpContentPanel.repaint();
	}
	
	/**
	 * ˢ��PSI/SI��������
	 * 
	 * @author Administrator
	 */
	public static void reflashData() {
		treeModel.reload();		
	}
}
