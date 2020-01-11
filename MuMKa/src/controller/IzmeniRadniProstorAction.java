package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.RadniProstor;
import view.MainFrame;
import view.MyMenuBar;

public class IzmeniRadniProstorAction extends AbstractAction{

	
	public IzmeniRadniProstorAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME, "Izmeni radni prostor" );
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		MyMenuBar.inputName = JOptionPane.showInputDialog("Molimo unesite ime radnog prostora:");
		
		RadniProstor radniProstor = (RadniProstor)MainFrame.getInstance().getTreeHandler().getTreeModel().getRoot();
		radniProstor.setNaziv(MyMenuBar.inputName);
		
		
		//MainFrame.getInstance().getTreeHandler().getTreeModel().setRoot((TreeNode)r);
	}

}