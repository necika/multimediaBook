package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;




import javax.swing.tree.DefaultMutableTreeNode;


import model.Dokument;
import model.RadniProstor;
import model.Stranica;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6153592950153920328L;
	
	private static MainFrame instance = null;
	
	private RadniProstor radniProstor;
	private JTextField jf;
	
	private TreeHandler treeHandler;
	private DefaultMutableTreeNode selectedDokument;
	
	
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
			instance.initGUI();
		}
		return instance;
	}
	
	public void initGUI() {
		
		this.treeHandler = new TreeHandler();
		this.radniProstor = new RadniProstor();
		this.treeHandler.setRadniProstor(radniProstor);
		
		this.treeHandler.initTree();
		
		setTitle("MuMKa");
		setSize(800, 600);
		setIconImage(new ImageIcon("images/malilogo.png").getImage());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		MyMenuBar meni = new MyMenuBar();
		this.setJMenuBar(meni);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JScrollPane scrollPaneTree = new JScrollPane(this.treeHandler.getTree());
		JPanel desniPanel = new JPanel();
		splitPane.add(scrollPaneTree);
		splitPane.add(desniPanel);
		
		splitPane.setDividerLocation(150);
		splitPane.setOneTouchExpandable(true);
		desniPanel.setBackground(Color.getHSBColor(150,(float) 150.07,(float) 100.4));
		
		JPanel panelUDesnomPanelu = new JPanel();
		desniPanel.add(panelUDesnomPanelu,BorderLayout.CENTER);
		panelUDesnomPanelu.setPreferredSize(new Dimension(500,450));
		panelUDesnomPanelu.setBackground(Color.WHITE);
		
		
		//panel za dugmice
		JPanel panelZaDugmice = new JPanel();
		desniPanel.add(panelZaDugmice,BorderLayout.SOUTH);
		panelZaDugmice.setPreferredSize(new Dimension(500,150));
		panelZaDugmice.setBackground(Color.getHSBColor(150,(float) 150.07,(float) 100.4));
		
		
		//dodavanje dugmica
		
		JButton btnPrikazStraniceDokumenta = new JButton("Ucitavanje Stranica");
		panelZaDugmice.add(btnPrikazStraniceDokumenta,BorderLayout.WEST);
		
		//labela samo da razdvoji
		JLabel jlTemp = new JLabel("                                           ");
		panelZaDugmice.add(jlTemp,BorderLayout.WEST);
		
		JButton btnPrethodna = new JButton("Prethodna");
		panelZaDugmice.add(btnPrethodna,BorderLayout.WEST);
		
		JButton btnSledeca = new JButton("Sledeca");
		panelZaDugmice.add(btnSledeca,BorderLayout.WEST);
		
		//labela samo da razdvoji
		JLabel jlTemp1 = new JLabel("                                                                             ");
		panelZaDugmice.add(jlTemp1,BorderLayout.WEST);
		
		JLabel jl = new JLabel("Skoci na stranu : ");
		panelZaDugmice.add(jl,BorderLayout.WEST);
		
		jf = new JTextField(3);
		panelZaDugmice.add(jf,BorderLayout.WEST);
		
		JButton btnSkoci = new JButton("Skoci");
		panelZaDugmice.add(btnSkoci,BorderLayout.WEST);
		
		
		
		//Panel koji ispisuje naziv stranice
		JPanel panelUDesnomPaneluGore = new JPanel();
		panelUDesnomPanelu.add(panelUDesnomPaneluGore,BorderLayout.NORTH);
		panelUDesnomPaneluGore.setBackground(Color.WHITE);
		panelUDesnomPaneluGore.setPreferredSize(new Dimension(350,50));
		JLabel nazivStranice = new JLabel();
		panelUDesnomPaneluGore.add(nazivStranice);
		
		
		
		//pomocni panel koji deli gornji i donji
		JPanel panelUDesnomPaneluSredina = new JPanel();
		panelUDesnomPanelu.add(panelUDesnomPaneluSredina,BorderLayout.CENTER);
		panelUDesnomPaneluSredina.setPreferredSize(new Dimension(500,350));
		panelUDesnomPaneluSredina.setBackground(Color.WHITE);
		
		//panel za ispis broja stranice
		JPanel panelUDesnomPaneluDole = new JPanel();
		panelUDesnomPanelu.add(panelUDesnomPaneluDole,BorderLayout.SOUTH);
		panelUDesnomPaneluDole.setBackground(Color.WHITE);
		panelUDesnomPaneluDole.setPreferredSize(new Dimension(350,50));
		JLabel brojStranice = new JLabel();
		panelUDesnomPaneluDole.add(brojStranice);
		
		btnPrikazStraniceDokumenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 selectedDokument = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
				
				if(selectedDokument == null){
					JOptionPane.showMessageDialog(null, "Niste selektovali nijedan cvor..");
				}
				else {
					
					if(selectedDokument.getUserObject() instanceof Dokument){
						Dokument d = (Dokument) selectedDokument.getUserObject();
						TreeHandler.listaSelektovanihStranica = (ArrayList<Stranica>) d.getStranice();
						for(Stranica s : TreeHandler.listaSelektovanihStranica){
							nazivStranice.setText("Naziv stranice : "+s.getNaslovStranice());
							brojStranice.setText("1");
							break;
						}
						
						revalidate();
						repaint();
					}
					else {
						JOptionPane.showMessageDialog(null, "Niste selektovali dokument cvor..");
					}
				} 
				
			}
		});
		
		btnSledeca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int trenutniBrojstranice = Integer.parseInt(brojStranice.getText());
				int i = 1;
				for(Stranica s : TreeHandler.listaSelektovanihStranica){
					if(i == (trenutniBrojstranice + 1)){
						nazivStranice.setText("Naziv stranice : "+s.getNaslovStranice());
						brojStranice.setText(Integer.toString(i));
						break;
					}
					i++;
				}
				revalidate();
				repaint();
				
			}
		});
		
		btnPrethodna.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int prethodniBrojstranice = Integer.parseInt(brojStranice.getText()) - 1;
				
				int i = 1;
					for(Stranica s : TreeHandler.listaSelektovanihStranica){
						if(i == prethodniBrojstranice){
							nazivStranice.setText("Naziv stranice : "+s.getNaslovStranice());
							brojStranice.setText(Integer.toString(i));
							break;
						}
					i++;
					}
				
				revalidate();
				repaint();
				
			}
		});
		
		btnSkoci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isInt = false;
				String sy = jf.getText();
				for(int i = 0;i < jf.getText().length();++i){
					char c = sy.charAt(i);
					if(c == '0' || c == '1' || c == '2' || c == '3'
							|| c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'){
						isInt = true;
					}
				}
				int skokNaStranicu;
				if(isInt == true){
					 skokNaStranicu = Integer.parseInt(jf.getText());
				
					 if(jf.getText() == null || jf.getText() == ""){
						 JOptionPane.showMessageDialog(null, "Niste uneli broj stranice..");
					 }
					 else {
						 if(skokNaStranicu < 1){
							 JOptionPane.showMessageDialog(null, "Molimo unesite broj stranice veci od 0..");
						 }
						 else if(skokNaStranicu > TreeHandler.listaSelektovanihStranica.size()){
							 JOptionPane.showMessageDialog(null, "Molimo unesite broj stranice manji od broja stranica..");
						 }
						 else {
							 int i = 1;
							 for(Stranica s : TreeHandler.listaSelektovanihStranica){
								 if(i == skokNaStranicu){
									 nazivStranice.setText("Naziv stranice : "+s.getNaslovStranice());
									 brojStranice.setText(Integer.toString(i));
									 break;
								 }
								 i++;
							 }
							 revalidate();
							 repaint();
						 }
					 }
				}else {
					JOptionPane.showMessageDialog(null, "Nepravilan format podatka..");
				}
			}
		});
		
		
		this.add(splitPane, BorderLayout.CENTER);
	}

	public RadniProstor getRadniProstor() {
		return radniProstor;
	}

	public void setRadniProstor(RadniProstor radniProstor) {
		this.radniProstor = radniProstor;
	}

	public TreeHandler getTreeHandler() {
		return treeHandler;
	}

	public void setTreeHandler(TreeHandler treeHandler) {
		this.treeHandler = treeHandler;
	}

	public static void setInstance(MainFrame instance) {
		MainFrame.instance = instance;
	}

	
	
	
	
	
}


 
