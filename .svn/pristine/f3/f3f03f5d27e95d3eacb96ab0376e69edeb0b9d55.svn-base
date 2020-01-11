package view;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Dokument;
import model.Kolekcija;
import model.RadniProstor;
import model.Stranica;

public class NodeTreeCellRenderer extends DefaultTreeCellRenderer{

	public NodeTreeCellRenderer() {
		
	}
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		
		if (value instanceof DefaultMutableTreeNode) {

			Object node = ((DefaultMutableTreeNode)value).getUserObject();
			
			if (node == null) {
				return this;
			}
			
			String iconPath, text = "";
			
			if (node instanceof RadniProstor) {
				text = ((RadniProstor)node).getNaziv();
				iconPath = "images/kolekcija-22.png";
			} else if (node instanceof Kolekcija) {
				text = ((Kolekcija)node).getNaziv();
				iconPath = "images/kolekcija-22.png";
			} else if (node instanceof Dokument) {
				text = ((Dokument)node).getNaziv();
				iconPath = "images/knjiga-22.png";
			} else {
				text = ((Stranica)node).getNaslovStranice();
				iconPath = "images/stranica-22.png";
			}
			
			
			setText(text);
			setIcon(new ImageIcon(iconPath));
		}
		
		return this;
	}
}
