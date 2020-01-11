package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainFrame;
import model.Stranica;

public class IzmeniStranicuAction extends AbstractAction {

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IzmeniStranicuAction() {
		
		putValue(NAME, "Izmeni stranicu");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		
		if(selectedNode == null){
			
			JOptionPane.showMessageDialog(null, "Niste selektovali nijedan cvor..");
		}
		else if(selectedNode.getUserObject() instanceof Stranica){			
			
			Stranica s = (Stranica)selectedNode.getUserObject();
			
			String izmeniIme = JOptionPane.showInputDialog("Molimo vas unesite ime Stranice:",s.getNaslovStranice());
			//IzmeniIme = selektovanaKolekcija.getNaziv();
			
			s.setNaslovStranice(izmeniIme);;
			
			
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Niste selektovali cvor klase \"Stranica..\"");
		} 
		
	}

}
