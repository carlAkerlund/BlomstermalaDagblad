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
	private JPanel[] articles;
	
	private JLabel lblHead = new JLabel("Världens längsta gylf sågs till i Centrum");
	private JTextArea areaText = new JTextArea("Flera personer hörde på onsdag förmiddag av sig till "
			+ "polisen och vittnade om att en ordentligt lång gylf sågs passera genom"
			+ " centrum. Polisen kunde konfrontera gylfen och konstaterade snabbt att det "
			+ "var den hittills längsta som någonsin vandrat på Malmös gator. 'Ett fynd', säger Polismästare"
			+ " Möller. Man har efter flera timmars förhör kunnat släppa gylfen mot borgen, samt "
			+ "ett löfte om att 'Ta det piano' i fortsättningen. Berörda myndigheter har kontaktats i syfte att"
			+ " händelsen inte ska inräffa igen.");
	private JLabel lblHead2 = new JLabel("Klippt utan Skuret");
	private JTextArea areaText2 = new JTextArea("Uttrycket 'Klippt och Skuret' har gått ur tiden. "
			+ "Det är 'Skuret' som helt enkelt tröttnat på att alltid komma sist och bestämt sig "
			+ "för att gå sin egen väg. Medlingsförsöken mellan 'Klippt' och 'Skuret', som skötts av "
			+ "advokat Thorulf Arwidson, avslutades igår efter ett fruktlöst tiotimmars möte. "
			+ "Arwidson, som tidigare lyckats medla i så svåra fall som mellan 'Klart' och 'Korvspad' "
			+ "erkände att förhandlingarna varit en pärs och nu tyvärr måste avbrytas, eller som Thorulf "
			+ "uttryckte det: - Förhandlingarna har varit en pärs och måste nu tyvärr avbrytas.");
	private JLabel lblHead3 = new JLabel("Meddelande till döva: ");
	private JTextArea areaText3 = new JTextArea("Döva bär ofta så kallad 'hängslebyxa', en byxa med hängslen som är känd "
			+ "bland snickare och hantverkare som en bekväm och praktisk byxa. Hängselbyxan lämnade modet för cirka "
			+ "10 år sedan bland vanligt folk, men hos döva lever denna byxa kvar. "
			+ "Efterforskningar påvisar att det inte någonstans skrivits att hängselbyxan inte längre är populär utan att detta mest är något som det snackats om på stan. "
			+ "Detta har alltså av förklarliga anledningar inte de döva hört."
			+ " Spermaharen vill, för att sätta stopp för dövbrallan, nu en gång för alla meddela alla döva; "
			+ "'Hängselbyxa hör till det förgångna. Hängselbyxa bärs av de som är hantverkare eller snickare. Inte av vanligt folk eller de med nedsatt eller obefintlig hörsel. Alla med koll har slutat bära hängslebyxa'. "
			+ "För att detta meddelande inte skall gå någon förbi följer det här på teckenspråk. " );
	
	private JPanel panel1 = new JPanel(new BorderLayout());
	private JPanel panel2 = new JPanel(new BorderLayout());
	private JPanel panel3 = new JPanel(new BorderLayout());
	
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
		panelCenter.setBorder(BorderFactory.createTitledBorder("Sport"));
		panelCenter.setOpaque(false);
		JScrollPane scrollFrame = new JScrollPane(panelCenter);
		panelCenter.setAutoscrolls(true);
		return scrollFrame;
	}
	
	public JPanel getPanelCenterCenter() {
		setPanelArt();
		panelCenterCenter.setOpaque(false);
//		panelCenterCenter.setLayout(new BorderLayout());
		panelCenterCenter.setLayout(new GridLayout(10, 1));
		lblHead.setFont(getFont().deriveFont(18.0f));
		areaText.setLineWrap(true);
		areaText.setWrapStyleWord(true);
		lblHead2.setFont(getFont().deriveFont(18.0f));
		areaText2.setLineWrap(true);
		areaText2.setWrapStyleWord(true);
		lblHead3.setFont(getFont().deriveFont(18.0f));
		areaText3.setLineWrap(true);
		areaText3.setWrapStyleWord(true);
		
		panelCenterCenter.add(panel1);
		panelCenterCenter.add(panel2);
		panelCenterCenter.add(panel3);
		
		return panelCenterCenter;
		
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
