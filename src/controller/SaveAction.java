package controller;

import java.awt.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;

import javax.swing.AbstractAction;

import view.MainFrame;

public class SaveAction extends AbstractAction{

	private ObjectOutputStream oos;
	private File f;
	
	public SaveAction() {
		putValue(NAME, "Sacuvaj");
		f = new File("save.txt");
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			oos.writeObject(MainFrame.getInstance().getRadniProstor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	

}
