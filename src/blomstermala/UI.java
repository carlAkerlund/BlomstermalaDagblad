package blomstermala;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UI extends JPanel {
	
	private JLabel lblTitle = new JLabel();
	private JLabel lblBack = new JLabel();
	private ImageIcon titleIcon = new ImageIcon("/Users/gustavbodestad/Documents/Skola/Eclipse/BlomstermalaDagblad/res/blomstermåla.png");
	private ImageIcon backGround = new ImageIcon("/Users/gustavbodestad/Documents/Skola/Eclipse/BlomstermalaDagblad/res/bakgrund.png");
	
	private JPanel panelNorth = new JPanel();
	private JPanel panelWest = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JPanel panelCenterWest = new JPanel();
	private JPanel panelCenterNorth = new JPanel();
	
	private JButton btnStart = new JButton("Startsida");
	private JButton btnSport = new JButton("Sport");
	private JButton btnEnt = new JButton("Nöje");
	private JButton btnPolitics = new JButton("Politik");
	private JButton btnFood = new JButton("Livsstil");
	
	private String[] sportSub = { "Fotboll", "Hockey", "Bandy", "Korvätning" };
	private String[] entSub = { "TV", "Film", "Serier", "Skvaller", "Spel" };
	private String[] PolSub = {"Inrikes", "Utrikes"};
	private String[] foodSub = {"Träning", "Mat", "Själ"};
	
	private Listener listener = new Listener();
	
	private Controller contr;

	
	public UI() {
		lblBack.setIcon(backGround);
		lblBack.setLayout(new BorderLayout());
		lblBack.setForeground(Color.WHITE);
		lblBack.setBackground(Color.WHITE);
		add(lblBack);
		lblBack.add(getPanelNorth(), BorderLayout.NORTH);
		lblBack.add(getPanelWest(), BorderLayout.WEST);
	}
	
	public void setController(Controller inCont) {
		contr = inCont;
	}
	
	public JPanel getPanelNorth() {
		lblTitle.setIcon(titleIcon);
		panelNorth.add(lblTitle);
		panelNorth.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		panelNorth.setOpaque(false);
		return panelNorth;
	}
	
	public JPanel getPanelWest() {
		panelWest.setPreferredSize(new Dimension(120, 30));
		btnSport.setBorderPainted( false );
		btnEnt.setBorderPainted( false );
		btnStart.setBorderPainted( false );
		btnPolitics.setBorderPainted( false );
		btnFood.setBorderPainted( false );
		panelWest.setBorder(BorderFactory.createTitledBorder("Ämnen"));
		panelWest.setLayout(new GridLayout(15,1));
		panelWest.add(btnStart);
		panelWest.add(btnSport);
		panelWest.add(btnEnt);
		panelWest.add(btnPolitics);
		panelWest.add(btnFood);
		btnSport.addActionListener(listener);
		btnFood.addActionListener(listener);
		btnStart.addActionListener(listener);
		btnEnt.addActionListener(listener);
		btnPolitics.addActionListener(listener);
		panelWest.setOpaque(false);
		return panelWest;	
	}
	
	public JPanel getPanelCenter() {
		panelCenter.setLayout(new BorderLayout());
		return panelCenter;
	}
	
	public JPanel getPanelCenterNorth(String[] inSubCats) {
		String[] subCats = inSubCats;
		panelCenterNorth.setLayout(new GridLayout(1, 5));
		for(int i = 0; i < subCats.length; i++) {
		}
		
		return panelCenterNorth;
	}
	
	public JPanel getPanelCenterWest() {
		return panelCenterWest;	
	}
	
	public void setPanel() {
		
	}
	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSport) {
				JOptionPane.showMessageDialog(null, "H");
			}
			
		}
		
	}
}
