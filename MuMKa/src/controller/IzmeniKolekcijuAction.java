package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainFrame;
import model.Kolekcija;

public class IzmeniKolekcijuAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public IzmeniKolekcijuAction() {

		putValue(NAME, "Izmeni kolekciju");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		
		if(selectedNode == null){
			
			JOptionPane.showMessageDialog(null, "Niste selektovali nijedan cvor..");
		}
		else if(selectedNode.getUserObject() instanceof Kolekcija){			
			
			Kolekcija k = (Kolekcija)selectedNode.getUserObject();
			
			String izmeniIme = JOptionPane.showInputDialog("Molimo vas unesite ime kolekcije:",k.getNaziv());
			//IzmeniIme = selektovanaKolekcija.getNaziv();
			
			k.setNaziv(izmeniIme);
			
			
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Niste selektovali cvor klase \"Kolekcija..\"");
		} 
		
		
	}

	
	
	
}