package com.alex.ts_parser;

import java.awt.EventQueue;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.alex.ts_parser.ui.MainWindow;

public class Main { 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.launchBeautyEyeLNF();
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
