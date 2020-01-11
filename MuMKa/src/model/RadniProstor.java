package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import view.MyMenuBar;

public class RadniProstor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private String naziv;
	
	public List<Kolekcija> kolekcije;
	
	public RadniProstor() {
		if(MyMenuBar.inputName == null || MyMenuBar.inputName.equals("")){
			this.naziv = "Radni prostor";
		}
		else {
			this.naziv = MyMenuBar.inputName;
		}
		this.kolekcije = new ArrayList<>();
	}
	
	public RadniProstor(String naziv, List<Kolekcija> kolekcije) {
		super();
		this.naziv = naziv;
		this.kolekcije = kolekcije;
	}

	public void addChilds(DefaultMutableTreeNode root) {
		for(Kolekcija k : this.kolekcije) {
			DefaultMutableTreeNode  node = new DefaultMutableTreeNode(k);
			k.addChilds(node);
			root.add(node);
		}
	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Kolekcija> getKolekcije() {
		return kolekcije;
	}

	public void setKolekcije(List<Kolekcija> kolekcije) {
		this.kolekcije = kolekcije;
	}
	
	
}
