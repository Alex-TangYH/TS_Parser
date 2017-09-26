package com.alex.ts_parser.ui;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class MyTreeModel extends DefaultTreeModel {
	private String lock = "lock";
	
	public MyTreeModel(TreeNode root) {
		super(root);
	}

	@Override
	public void removeNodeFromParent(MutableTreeNode node) {
		synchronized (lock){
			super.removeNodeFromParent(node);
		}
	}

	private static final long serialVersionUID = 1L;

}
