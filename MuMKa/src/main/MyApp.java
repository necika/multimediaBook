package main;

import javax.swing.JOptionPane;

import view.MainFrame;
import view.MyMenuBar;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMenuBar.inputName = JOptionPane.showInputDialog("Molimo unesite ime radnog prostora:");
		MainFrame mf = MainFrame.getInstance();
		mf.setVisible(true);
	}

}
