package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import observer.Observable;
import observer.Observer;

public class Stranica implements Serializable, Observable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int brojStranice;
	
	private String naslovStranice;
	
	private Dokument dokument;

	List<Observer> observers = new ArrayList<>(); //Lista svih observera koji osluskuju promene u stranici
	
	public Stranica() {}

	public Stranica(int brojStranice, String naslovStranice, Dokument dokument) {
		super();
		this.brojStranice = brojStranice;
		this.naslovStranice = naslovStranice;
		
	}
	
	public Stranica(String naslovStranice) {
		this();
		this.naslovStranice = naslovStranice;
	}
	
	public Stranica(String naslovStranice, Dokument dokument) {
		super();
		this.naslovStranice = naslovStranice;
		this.dokument = dokument;
	}

	public int getBrojStranice() {
		return brojStranice;
	}

	public void setBrojStranice(int brojStranice) {
		this.brojStranice = brojStranice;
	}

	public String getNaslovStranice() {
		return naslovStranice;
	}

	public void setNaslovStranice(String naslovStranice) {
		this.naslovStranice = naslovStranice;
	}

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}
	
	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		for(Observer o : observers) {
			o.update(this, arg);
		}
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		this.observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		this.observers.remove(observer);
	}

	
	
	
}
