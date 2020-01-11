package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Kolekcija implements Component, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String naziv;
	
	public ArrayList<Component> komponente;
	

	public Kolekcija() {
		this.komponente = new ArrayList<>();
		
	}
	
	public Kolekcija(String naziv) {
		super();
		this.naziv = naziv;
		this.komponente = new ArrayList<>();
	}
	
	public Kolekcija(String naziv, ArrayList<Component> komponente) {
		this();
		this.naziv = naziv;
		this.komponente = komponente;
	}

	public void addChilds(DefaultMutableTreeNode koren) {
		for(Component c : this.komponente) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(c);
			c.addChilds(node);
			koren.add(node);
		}
	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Component> getKomponente() {
		return komponente;
	}

	public void setKomponente(ArrayList<Component> komponente) {
		this.komponente = komponente;
	}
	
	
}
