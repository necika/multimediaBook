package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Stranica;
import observer.EventType;
import view.MainFrame;

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
			
			childNodeModel.getDokument().getStranice().remove(childNodeModel);
			
			childNodeModel.notifyObservers(EventType.REMOVED);
		
		} else {
			JOptionPane.showMessageDialog(null, "Niste izabrali stranicu.");
			return;
		}
		
		
		
	}
}
