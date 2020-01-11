package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainFrame;
import model.Kolekcija;
import model.RadniProstor;

public class ObrisiKolekcijuAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	public ObrisiKolekcijuAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME, "Obrisi kolekciju" );
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null) {
			return;
		}
		
		if(childNodeView.getUserObject() instanceof Kolekcija) {
			
			Kolekcija childNodeModel = (Kolekcija) childNodeView.getUserObject();
			
			DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) childNodeView.getParent();
			
			if (parentNode.getUserObject() instanceof RadniProstor) {
				
				((RadniProstor)parentNode.getUserObject()).getKolekcije().remove(childNodeModel);
			} else if (parentNode.getUserObject() instanceof Kolekcija) {
				
				((Kolekcija)parentNode.getUserObject()).getKomponente().remove(childNodeModel);
			
			}
			
			//proveriti kod brisanja kolekcije, da li se pri brisanju uklanja i dokument koji je treutno otvoren
			
			MainFrame.getInstance().getTreeHandler().getTreeModel().removeNodeFromParent(childNodeView);
		
		} else {
			JOptionPane.showMessageDialog(null, "Niste izabrali kolekciju");
			return;
		}
		
		
	}
}
