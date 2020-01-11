package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainFrame;
import model.Dokument;
import model.Stranica;

public class DodajStranicuAction extends AbstractAction{
	
	private static final long serialVersionUID = 1L;

	public DodajStranicuAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME, "Dodaj stranicu" );
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null) {
			return;
		}
		
		if(!(childNodeView.getUserObject() instanceof Dokument)) {
			return;
		}
		
		String inputName = JOptionPane.showInputDialog("Molimo vas unesite ime stranice:");
		
		if (inputName == "" || inputName == null) {
			return;
		}
			
		if(childNodeView.getUserObject() instanceof Dokument) {
			Dokument d = (Dokument)childNodeView.getUserObject();
			Stranica novaStranica = new Stranica(inputName);
			d.getStranice().add(novaStranica);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(novaStranica);
			
			MainFrame.getInstance().getTreeHandler().getTreeModel().insertNodeInto(node, childNodeView,
					childNodeView.getChildCount());
		}
		
	}

	
}
