package com.alex.ts_parser.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alex.ts_parser.native_function.NativeFunctionManager;
import com.alex.ts_parser.utils.StringResocesHelper;
import com.alex.ts_parser.utils.TS_Utils;

public class MainWindow {

	public JFrame frame;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 904, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar mainMenuBar = new JMenuBar();
		frame.setJMenuBar(mainMenuBar);

		JMenu mnFileMenu = new JMenu(StringResocesHelper.GetStringByKey("MainWindow.MenuBar.MenuItem.File"));
		mainMenuBar.add(mnFileMenu);

		JMenuItem mniOpen = new JMenuItem(StringResocesHelper.GetStringByKey("MainWindow.MenuBar.MenuItem.Open"));
		mnFileMenu.add(mniOpen);
		mniOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFileChooser = new JFileChooser();
				String filePath = null;
				String name = null;

				int i = jFileChooser.showOpenDialog(null);
				if (i == JFileChooser.APPROVE_OPTION) { // ���ļ�
					filePath = jFileChooser.getSelectedFile().getAbsolutePath();
					name = jFileChooser.getSelectedFile().getName();
					logger.info("��ǰ�ļ�·����" + filePath + ";��ǰ�ļ�����" + name);
					if (filePath == null || filePath.isEmpty()) {
						logger.info("û��ѡ���ļ�");
					} else if (TS_Utils.isTsFile(filePath)) {
						NativeFunctionManager.parseTSFileNative(filePath);
					} else {
						logger.info("����TS�ļ�");
					}
				} else {
					logger.info("û��ѡ���ļ�");
					logger.info("11111");
				}

				logger.info(filePath);
			}

		});
		// TODO �������Ƿ�
		// mniOpen.setAccelerator(KeyStroke.getKeyStroke('O'));
		// mniOpen.setMnemonic('O');

		JMenuItem mniClose = new JMenuItem(StringResocesHelper.GetStringByKey("MainWindow.MenuBar.MenuItem.Close"));
		mnFileMenu.add(mniClose);

		JMenuItem mniHelp = new JMenuItem(StringResocesHelper.GetStringByKey("MainWindow.MenuBar.MenuItem.Help"));
		mainMenuBar.add(mniHelp);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}

}
