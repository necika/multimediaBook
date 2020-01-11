package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainFrame;
import model.Dokument;
import model.Kolekcija;

public class DodajDokumentAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	public static Kolekcija k; 

	public DodajDokumentAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME, "Dodaj dokument" );
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null) {
			return;
		}
		
		if(!(childNodeView.getUserObject() instanceof Kolekcija)) {
			JOptionPane.showMessageDialog(null, "Molimo vas odaberite kolekciju u koju zelite dodati dokument.");
			return;
		}
		
		String inputName = JOptionPane.showInputDialog("Molimo vas unesite ime dokumenta:");
		
		if (inputName == "" || inputName == null) {
			return;
		}
			
		if(childNodeView.getUserObject() instanceof Kolekcija) {
			Kolekcija k = (Kolekcija)childNodeView.getUserObject();
			Dokument noviDokument = new Dokument(inputName);
			k.getKomponente().add(noviDokument);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(noviDokument);
			
			MainFrame.getInstance().getTreeHandler().getTreeModel().insertNodeInto(node, childNodeView,
					childNodeView.getChildCount());
		}
		
	}

}
