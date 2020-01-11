package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainFrame;
import model.Kolekcija;
import model.RadniProstor;

public class DodajKolekcijuAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	public DodajKolekcijuAction() {
	
		putValue(NAME, "Dodaj kolekciju" );
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null) {
			JOptionPane.showMessageDialog(null, "Morate selektovani zeljeni cvor..");
			return;
		}
		
		if(!((childNodeView.getUserObject() instanceof RadniProstor) || (childNodeView.getUserObject() instanceof Kolekcija))) {
			
			JOptionPane.showMessageDialog(null, "Kolekcija moze biti dodata samo u radni prostor ili drugu kolekciju.");
			return;
			//Ako nije ni kolekcija ni radni prostor ispisi obavestenje o gresci (inace bi bio exception)
			
		}
		
		
		String inputName = JOptionPane.showInputDialog("Molimo vas unesite ime kolekcije:");
		
		if (inputName == "" || inputName == null) {
			return;
		}
		
		if (childNodeView.getUserObject() instanceof RadniProstor) {
			
			RadniProstor rs = (RadniProstor)childNodeView.getUserObject();
			Kolekcija novaKolekcija = new Kolekcija(inputName);
			rs.getKolekcije().add(novaKolekcija);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(novaKolekcija);
			
			MainFrame.getInstance().getTreeHandler().getTreeModel().insertNodeInto(node, childNodeView,
					childNodeView.getChildCount());
			
		} else if (childNodeView.getUserObject() instanceof Kolekcija) {
			
			Kolekcija k = (Kolekcija)childNodeView.getUserObject();
			Kolekcija novaKolekcija = new Kolekcija(inputName);
			k.getKomponente().add(novaKolekcija);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(novaKolekcija);
			
			MainFrame.getInstance().getTreeHandler().getTreeModel().insertNodeInto(node, childNodeView, 
					childNodeView.getChildCount());
		} 
		 		
	}

	
}
