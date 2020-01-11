package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import controller.DodajDokumentAction;
import controller.DodajKolekcijuAction;
import controller.DodajStranicuAction;
import controller.IzmeniDokumentAction;
import controller.IzmeniKolekcijuAction;
import controller.IzmeniStranicuAction;
import controller.ObrisiDokumentAction;
import controller.ObrisiKolekcijuAction;
import controller.ObrisiStranicuAction;
import controller.OpenAction;
import controller.SaveAction;

public class MyMenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4273777597552585506L;

	public MyMenuBar() {
		JMenu file = new JMenu("Fajl");
		JMenu kolekcijaMeni = new JMenu("Kolekcija");
		JMenu dokumentMeni = new JMenu("Dokument");
		JMenu stranicaMeni = new JMenu("Stranica");
		
		DodajKolekcijuAction dodajKolekcijuAction = new DodajKolekcijuAction();
		DodajDokumentAction dodajDokumentAction = new DodajDokumentAction();
		DodajStranicuAction dodajStranicuAction = new DodajStranicuAction();
		
		ObrisiKolekcijuAction obrisiKolekcijuAction = new ObrisiKolekcijuAction();
		ObrisiDokumentAction obrisiDokumentAction = new ObrisiDokumentAction();
		ObrisiStranicuAction obrisiStranicuAction = new ObrisiStranicuAction();
		
		IzmeniKolekcijuAction izmeniKolekcijuAction = new IzmeniKolekcijuAction();
		IzmeniDokumentAction izmeniDokumentAction = new IzmeniDokumentAction();
		IzmeniStranicuAction izmeniStranicuAction = new IzmeniStranicuAction();
		
		SaveAction saveAction = new SaveAction();
		OpenAction openAction = new OpenAction();
		
		file.add(saveAction);
		file.add(openAction);
		
		kolekcijaMeni.add(dodajKolekcijuAction);
		kolekcijaMeni.add(obrisiKolekcijuAction);
		kolekcijaMeni.add(izmeniKolekcijuAction);
		
		dokumentMeni.add(dodajDokumentAction);
		dokumentMeni.add(obrisiDokumentAction);
		dokumentMeni.add(izmeniDokumentAction);
			
		stranicaMeni.add(dodajStranicuAction);
		stranicaMeni.add(obrisiStranicuAction);
		stranicaMeni.add(izmeniStranicuAction);
		
		this.add(file);
		this.add(kolekcijaMeni);
		this.add(dokumentMeni);
		this.add(stranicaMeni);
		
	}
	

}
