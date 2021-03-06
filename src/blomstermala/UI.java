package blomstermala;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class UI extends JPanel {
	
	private JLabel lblTitle = new JLabel();
	private JLabel lblBack = new JLabel();
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
	private JButton btnFoot;
	private JButton btnHockey;
	private JButton btnBox;
	private JButton btnKorv;
	private Article[] articles;
	
	private JPanel panelRead = new JPanel();
	
	private Listener listener = new Listener();
	
	private Controller contr;
	
	private JButton lblHead = new JButton();
	private JTextArea areaText = new JTextArea();
	private JButton lblHead2 = new JButton();
	private JTextArea areaText2 = new JTextArea();
	private JButton lblHead3 = new JButton();
	private JTextArea areaText3 = new JTextArea();
	
	private JPanel panel1 = new JPanel(new BorderLayout());
	private JPanel panel2 = new JPanel(new BorderLayout());
	private JPanel panel3 = new JPanel(new BorderLayout());
	
	private ArrayList <Article>art;
	
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
//		lblBack.add(new ArtPanel(new Article(1, "Döva hej hej hej", "src/media/döva.txt", "", "", "")));
		panelSport.setVisible(false);
	}
	
	public UI(Controller inCont, Article art) {
		contr = inCont;
		lblBack.setIcon(backGround);
		lblBack.setLayout(new BorderLayout());
		lblBack.setForeground(Color.WHITE);
		lblBack.setBackground(Color.WHITE);
		add(lblBack);
		lblBack.add(getPanelNorth(), BorderLayout.NORTH);
		lblBack.add(getPanelWest(), BorderLayout.WEST);
//		lblBack.add(getPanelCenter(), BorderLayout.CENTER);
		System.out.println("*********************"+art.getKommentar()[0].getInnehall());
		lblBack.add(new ArtPanel(art, inCont));
		panelSport.setVisible(false);
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
	
	public JScrollPane getPanelCenter() {
		
		JPanel panelW = new JPanel();
		JPanel panelE = new JPanel();
		panelW.setPreferredSize(new Dimension(10, 100));
		panelE.setPreferredSize(new Dimension(150, 100));
		panelW.setOpaque(false);
		panelE.setOpaque(false);
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(getSportpanel(), BorderLayout.NORTH);
		panelCenter.add(getPanelCenterCenter(), BorderLayout.CENTER);
		panelCenter.add(panelW, BorderLayout.WEST);
		panelCenter.add(panelE, BorderLayout.EAST);
//		panelCenter.setBorder(BorderFactory.createTitledBorder("Sport"));
		panelCenter.setOpaque(false);
		JScrollPane scrollFrame = new JScrollPane(panelCenter);
		scrollFrame.setBorder(BorderFactory.createTitledBorder("Sport"));
		panelCenter.setAutoscrolls(true);
		return scrollFrame;
	}
	
	public void setCenter() {
		lblBack.add(getPanelCenter(), BorderLayout.CENTER);
	}
	
	public JPanel getPanelCenterCenter() {
		setPanelArt();
		panelCenterCenter.setOpaque(false);
//		panelCenterCenter.setLayout(new BorderLayout());
		panelCenterCenter.setLayout(new GridLayout(10, 1));
		lblHead.setFont(getFont().deriveFont(18.0f));
		lblHead.setBorderPainted(false);
		lblHead.addActionListener(listener);
		areaText.setLineWrap(true);
		areaText.setWrapStyleWord(true);
		lblHead2.setFont(getFont().deriveFont(18.0f));
		lblHead2.setBorderPainted(false);
		lblHead2.addActionListener(listener);
		areaText2.setLineWrap(true);
		areaText2.setWrapStyleWord(true);
		lblHead3.setFont(getFont().deriveFont(18.0f));
		lblHead3.setBorderPainted(false);
		lblHead3.addActionListener(listener);
		areaText3.setLineWrap(true);
		areaText3.setWrapStyleWord(true);
		
		panelCenterCenter.add(panel1);
		panelCenterCenter.add(panel2);
		panelCenterCenter.add(panel3);
		
		return panelCenterCenter;
		
	}
	
	public void setArticles(ArrayList<Article> art) {
		this.art = art;
		
		System.out.println(art.size());
				if(art.size()== 1){
					lblHead.setText(art.get(0).getRubrik());
					areaText.setText(art.get(0).getIngress());
					lblHead2.setText(" ");
					areaText2.setText(" ");
					lblHead3.setText(" ");
					areaText3.setText(" ");
				}
				if(art.size()== 2){
					lblHead.setText(art.get(0).getRubrik());
					areaText.setText(art.get(0).getIngress());
					lblHead2.setText(art.get(1).getRubrik());
					areaText2.setText(art.get(1).getIngress());
					lblHead3.setText(" ");
					areaText3.setText(" ");
				}
				if(art.size()== 3){
					lblHead.setText(art.get(0).getRubrik());
					areaText.setText(art.get(0).getIngress());
					lblHead2.setText(art.get(1).getRubrik());
					areaText2.setText(art.get(1).getIngress());
					lblHead3.setText(art.get(2).getRubrik());
					areaText3.setText(art.get(2).getIngress());
				}
		}
	
	
	
	public void setPanelArt() {
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		
		panel1.add(lblHead, BorderLayout.NORTH);
		panel1.add(areaText, BorderLayout.CENTER);
		panel2.add(lblHead2, BorderLayout.NORTH);
		panel2.add(areaText2, BorderLayout.CENTER);
		panel3.add(lblHead3, BorderLayout.NORTH);
		panel3.add(areaText3, BorderLayout.CENTER);
		
	}
	
	public JPanel getSportpanel() {
//		panelSport.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		btnFoot = new JButton("Fotboll");
		btnHockey = new JButton("Hockey");
		btnBox = new JButton("Boxning");
		btnKorv = new JButton("Korvätning");
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
				try {
					panelSport.setVisible(true);
					contr.transferArticles("Sport");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (e.getSource() == btnFoot) {
				try {
					contr.transferArticles("Sport", "Fotboll");
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (e.getSource() == lblHead){
				contr.article();
//				new ArtPanel(art.get(0));
			}
			if (e.getSource() == lblHead2){

				contr.setKommentarer();
				new ArtPanel(art.get(1), contr);
			}
			if (e.getSource() == lblHead3){
				contr.setKommentarer();
				new ArtPanel(art.get(2), contr);
			}
//			if (e.getSource() == btnSport) {
//				panelSport.setVisible(true);
//				contr.transferArticles("Sport");
//			}
			
		}
		
	}
}
