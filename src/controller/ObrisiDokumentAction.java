package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainFrame;
import model.Dokument;
import model.Kolekcija;

public class ObrisiDokumentAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	public ObrisiDokumentAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME, "Obrisi dokument");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null) {
			return;
		}
		
		if(childNodeView.getUserObject() instanceof Dokument) {
			
			Dokument childNodeModel = (Dokument) childNodeView.getUserObject();
			
			DefaultMutableTreeNode parentPackage = (DefaultMutableTreeNode)childNodeView.getParent();
			
			((Kolekcija)parentPackage.getUserObject()).getKomponente().remove(childNodeModel);
			
			MainFrame.getInstance().getTreeHandler().getTreeModel().removeNodeFromParent(childNodeView);
		
		} else {
			
			return;
		}
		

		
	}
}
