package com.alex.ts_parser.ui;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class MyTreeModel extends DefaultTreeModel {
	private Lock lock = new ReentrantLock();    
	public MyTreeModel(TreeNode root) {
		super(root);
	}

	@Override
	public void removeNodeFromParent(MutableTreeNode node) {
		lock.lock();
		try{
			//��������
			super.removeNodeFromParent(node);
		}catch(Exception ex){
		 
		}finally{
		    lock.unlock();   //�ͷ���
		}
	}

	private static final long serialVersionUID = 1L;

}
