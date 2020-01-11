package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainFrame;
import model.Dokument;
import model.Stranica;

public class ObrisiStranicuAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	public ObrisiStranicuAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME, "Obrisi stranicu");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null) {
			return;
		}
		
		if(childNodeView.getUserObject() instanceof Stranica) {
			
			Stranica childNodeModel = (Stranica) childNodeView.getUserObject();
			
			DefaultMutableTreeNode parentPackage = (DefaultMutableTreeNode)childNodeView.getParent();
			
			((Dokument)parentPackage.getUserObject()).getStranice().remove(childNodeModel);
			
			MainFrame.getInstance().getTreeHandler().getTreeModel().removeNodeFromParent(childNodeView);
		
		} else {
			return;
		}
		
		
		
	}
}
