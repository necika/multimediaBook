package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Dokument implements Component, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String naziv;
	
	private List<Stranica> stranice;
	
	public Dokument() {
		super();
		this.stranice = new ArrayList<>();
	}
	
	public Dokument(String naziv) {
		this();
		this.naziv = naziv;
	}
	
	public Dokument(String naziv, List<Stranica> stranice) {
		super();
		this.naziv = naziv;
		this.stranice = stranice;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Stranica> getStranice() {
		return stranice;
	}

	public void setStranice(List<Stranica> stranice) {
		this.stranice = stranice;
	}

	@Override
	public void addChilds(DefaultMutableTreeNode koren) {
		// TODO Auto-generated method stub
		for(Stranica s : this.stranice) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(s);
			koren.add(node);
		}
		
	}
	
	
}
