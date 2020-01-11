package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import controller.DodajDokumentAction;
import controller.DodajKolekcijuAction;
import controller.DodajStranicuAction;
import controller.IzmeniDokumentAction;
import controller.IzmeniKolekcijuAction;
import controller.IzmeniRadniProstorAction;
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
		//JMenu izmeni = new JMenu("Izmeni radni prostor");
		
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
		IzmeniRadniProstorAction izmeniAction = new IzmeniRadniProstorAction();
		
		
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
		
		//izmeni.add(izmeniAction);
		
		this.add(file);
		this.add(kolekcijaMeni);
		this.add(dokumentMeni);
		this.add(stranicaMeni);
		//this.add(izmeni);
		
		
		
	}
	public static String inputName; 

}
