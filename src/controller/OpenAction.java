package controller;

import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import view.MainFrame;
import model.Component;
import model.Dokument;
import model.Kolekcija;
import model.RadniProstor;
import model.Stranica;

public class OpenAction extends AbstractAction{

	private File f;
	private ObjectInputStream ois;
	
	public OpenAction() {
		putValue(NAME, "Otvori");
		f = new File("save.txt");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(f.exists() == true){
			try {
				ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				MainFrame.getInstance().setRadniProstor((RadniProstor)ois.readObject());
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					ois.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(MainFrame.getInstance().getRadniProstor() != null) {
				for(Kolekcija k : MainFrame.getInstance().getRadniProstor().getKolekcije()){
					DefaultMutableTreeNode node = new DefaultMutableTreeNode("");
					node.setUserObject(k);
					MainFrame.getInstance().getTreeHandler().getTreeModel().insertNodeInto(node, MainFrame.getInstance().getTreeHandler().getRoot(),MainFrame.getInstance().getTreeHandler().getRoot().getChildCount());

					for(Component cc : k.getKomponente()){
						if(cc instanceof Kolekcija) { 
							dodajNovuKolekciju((Kolekcija)cc, node);
						}else {
							for(Component c : k.getKomponente()){
								if(c instanceof Dokument) {
									Dokument d = (Dokument)c;
									DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("");
									node2.setUserObject(d);
									MainFrame.getInstance().getTreeHandler().getTreeModel().insertNodeInto(node2, node,node.getChildCount());
									for(Stranica s : d.getStranice()){
										DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("");
										node3.setUserObject(s);
										MainFrame.getInstance().getTreeHandler().getTreeModel().insertNodeInto(node3, node2,node2.getChildCount());
										
									}
								} 
					
							}
						

						}
					}
				}
			}
			

			
		}
	}
	public void dodajNovuKolekciju(Kolekcija k,DefaultMutableTreeNode node){
		
			DefaultMutableTreeNode df = new DefaultMutableTreeNode();
			df.setUserObject(k);
			MainFrame.getInstance().getTreeHandler().getTreeModel().insertNodeInto(df,node, node.getChildCount());
		
			if(k.getKomponente() != null){
				for(Component k1 : k.getKomponente()){
					if(k1 instanceof Kolekcija){
						dodajNovuKolekciju((Kolekcija)k1,df);
					}
					else {
						for(Component c : k.getKomponente()){
							if(c instanceof Dokument) {
								Dokument d = (Dokument)c;
								DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("");
								node2.setUserObject(d);
								MainFrame.getInstance().getTreeHandler().getTreeModel().insertNodeInto(node2, df,df.getChildCount());
								for(Stranica s : d.getStranice()){
									DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("");
									node3.setUserObject(s);
									MainFrame.getInstance().getTreeHandler().getTreeModel().insertNodeInto(node3, node2,node2.getChildCount());
									
								}
							}
						}
				
						
					}
				}	
			}
	}

}


