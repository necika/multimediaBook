package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import model.RadniProstor;
import model.Stranica;
import observer.EventType;
import observer.Observable;
import observer.Observer;


public class TreeHandler implements Observer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTree tree;
	
	private DefaultTreeModel treeModel;
	
	private DefaultMutableTreeNode root;
	
	private RadniProstor radniProstor;
	
	public static ArrayList<Stranica> listaSelektovanihStranica = new ArrayList<Stranica>();
	
	public TreeHandler() {}
	
	public TreeHandler(RadniProstor radniProstor) {
		this.radniProstor = radniProstor;
	}
	
	public TreeHandler(JTree tree, DefaultTreeModel treeModel, DefaultMutableTreeNode root) {
		super();
		this.tree = tree;
		this.treeModel = treeModel;
		this.root = root;
	}
	
	public void initTree() {	
		
		initData();
		
		this.treeModel = new DefaultTreeModel(this.root);
		this.treeModel.setAsksAllowsChildren(true);
		this.tree = new JTree(treeModel) {

			private static final long serialVersionUID = 2789999619139248302L;

			@Override
			public boolean isPathEditable(TreePath path) {
				return false;
			}
		};
		this.tree.setEditable(true);
		this.tree.setCellRenderer(new NodeTreeCellRenderer());
		expandAllNodes(this.tree, 0, tree.getRowCount());
		this.tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);	
		
	}
	
	private void initData() {
		this.root = new DefaultMutableTreeNode(this.radniProstor);
		this.radniProstor.addChilds(root);
	}
	
	private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
	    for(int i=startingIndex;i<rowCount;++i){
	        tree.expandRow(i);
	    }

	    if(tree.getRowCount()!=rowCount){
	        expandAllNodes(tree, rowCount, tree.getRowCount());
	    }
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	public DefaultMutableTreeNode getRoot() {
		return root;
	}

	public void setRoot(DefaultMutableTreeNode root) {
		this.root = root;
	}

	public RadniProstor getRadniProstor() {
		return radniProstor;
	}

	public void setRadniProstor(RadniProstor radniProstor) {
		this.radniProstor = radniProstor;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> en = ((DefaultMutableTreeNode) treeModel.getRoot()).breadthFirstEnumeration();
		
		if (arg1 == EventType.REMOVED) {
			
			Stranica stranica = (Stranica)arg0;
			
			while (en.hasMoreElements()) {
				DefaultMutableTreeNode curr = en.nextElement();

				if (curr.getUserObject() instanceof Stranica && 
						((Stranica)curr.getUserObject()).getNaslovStranice() == stranica.getNaslovStranice()) {
					
					this.treeModel.removeNodeFromParent(curr);
				}
			}
			
			MainFrame.getInstance();
			
		} else if (arg1 == EventType.ADDED) {
			
			Stranica stranica = (Stranica)arg0;
			
			DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
			
			this.treeModel.insertNodeInto(new DefaultMutableTreeNode(stranica), childNodeView, childNodeView.getChildCount());
		}
	}
	

}
