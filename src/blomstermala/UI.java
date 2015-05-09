package blomstermala;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UI extends JPanel {
	
	private JLabel lblTitle = new JLabel();
	private JLabel lblBack = new JLabel();
//	private ImageIcon titleIcon = new ImageIcon("/Users/gustavbodestad/Documents/Skola/Eclipse/BlomstermalaDagblad/res/blomstermåla.png");
//	private ImageIcon backGround = new ImageIcon("/Users/gustavbodestad/Documents/Skola/Eclipse/BlomstermalaDagblad/res/bakgrund.png");
	private ImageIcon titleIcon = new ImageIcon("src/media/blomstermåla.png");
	private ImageIcon backGround = new ImageIcon("src/media/bakgrund.png");
	
	private JPanel panelNorth = new JPanel();
	private JPanel panelWest = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JPanel panelCenterCenter = new JPanel();
	private JPanel panelSport = new JPanel();
	
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
	
	private JLabel lblHead = new JLabel("Världens längsta gylf sågs till i Centrum");
	private JTextArea areaText = new JTextArea("Flera personer hörde på onsdag förmiddag av sig till "
			+ "polisen och vittnade om att en ordentligt lång gylf sågs passera genom"
			+ " centrum. Polisen kunde konfrontera gylfen och konstaterade snabbt att det "
			+ "var den hittills längsta som någonsin vandrat på Malmös gator. 'Ett fynd', säger Polismästare"
			+ " Möller. ");

	
	public UI(Controller inCont) {
		contr = inCont;
		lblBack.setIcon(backGround);
		lblBack.setLayout(new BorderLayout());
		lblBack.setForeground(Color.WHITE);
		lblBack.setBackground(Color.WHITE);
		add(lblBack);
		lblBack.add(getPanelNorth(), BorderLayout.NORTH);
		lblBack.add(getPanelWest(), BorderLayout.WEST);
		lblBack.add(getPanelCenter(), BorderLayout.CENTER);
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
		JPanel panelW = new JPanel();
		JPanel panelE = new JPanel();
		panelW.setPreferredSize(new Dimension(10, 100));
		panelE.setPreferredSize(new Dimension(200, 100));
		panelW.setOpaque(false);
		panelE.setOpaque(false);
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(getSportpanel(), BorderLayout.NORTH);
		panelCenter.add(getPanelCenterCenter(), BorderLayout.CENTER);
		panelCenter.add(panelW, BorderLayout.WEST);
		panelCenter.add(panelE, BorderLayout.EAST);
		panelCenter.setBorder(BorderFactory.createTitledBorder("Sport"));
		panelCenter.setOpaque(false);
		return panelCenter;
	}
	
	public JPanel getPanelCenterCenter() {
		
		panelCenterCenter.setOpaque(false);
		panelCenterCenter.setLayout(new BorderLayout());
		lblHead.setFont(getFont().deriveFont(18.0f));
		areaText.setLineWrap(true);
		areaText.setWrapStyleWord(true);
		
		panelCenterCenter.add(lblHead, BorderLayout.NORTH);
		panelCenterCenter.add(areaText, BorderLayout.CENTER);
		
		return panelCenterCenter;
		
	}
	
	public JPanel getSportpanel() {
		panelSport.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		JButton btnFoot = new JButton("Fotboll");
		JButton btnHockey = new JButton("Hockey");
		JButton btnBox = new JButton("Boxning");
		JButton btnKorv = new JButton("Korvätning");
		btnFoot.setBorderPainted( false );
		btnHockey.setBorderPainted( false );
		btnBox.setBorderPainted( false );
		btnKorv.setBorderPainted( false );
		btnFoot.addActionListener(listener);
		btnHockey.addActionListener(listener);
		btnBox.addActionListener(listener);
		btnKorv.addActionListener(listener);
		panelSport.add(btnBox);
		panelSport.add(btnKorv);
		panelSport.add(btnHockey);
		panelSport.add(btnFoot);
		panelSport.setOpaque(false);
		return panelSport;
	}

	
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSport) {
				contr.setSport();
			}
			
		}
		
	}
}
