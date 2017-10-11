package com.alex.ts_parser.ui;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyTreeModel extends DefaultTreeModel {
	private Logger logger = LogManager.getLogger("MyTreeModel");
	private Lock lock = new ReentrantLock();    
	public MyTreeModel(TreeNode root) {
		super(root);
	}

	@Override
	public void removeNodeFromParent(MutableTreeNode node) {
		lock.lock();
		try{
			//处理任务
			super.removeNodeFromParent(node);
		}catch(Exception ex){
			logger.error("removeNodeFromParent", ex);
		}finally{
			//释放锁
		    lock.unlock();   
		}
	}

	private static final long serialVersionUID = 1L;

}
