package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainFrame;
import model.Dokument;

public class IzmeniDokumentAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public IzmeniDokumentAction () {
		putValue(NAME,"Izmena dokumenta");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		
		if(selectedNode == null){
			
			JOptionPane.showMessageDialog(null, "Niste selektovali nijedan cvor..");
		}
		else if(selectedNode.getUserObject() instanceof Dokument){			
			
			Dokument d = (Dokument)selectedNode.getUserObject();
			
			String izmeniIme = JOptionPane.showInputDialog("Molimo vas unesite ime Dokumenta:",d.getNaziv());
			//IzmeniIme = selektovanaKolekcija.getNaziv();
			
			d.setNaziv(izmeniIme);
			
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Niste selektovali cvor klase \"Dokument..\"");
		} 
		
	}

	
	
	
	
}
