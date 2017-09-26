package com.alex.ts_parser;

import java.awt.EventQueue;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.alex.ts_parser.ui.MainWindow;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.launchBeautyEyeLNF();
			BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
			UIManager.put("RootPane.setupButtonVisible", false);
			UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(3, 2, 2, 2));
		} catch (Exception e1) {
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow mainWindow = new MainWindow();
					mainWindow.frmTs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
