package blomstermala;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Controller {
	
	private String[] sportSub = { "Fotboll", "Hockey", "Bandy", "Korvätning" };
	private String[] entSub = { "TV", "Film", "Serier", "Skvaller", "Spel" };
	private String[] PolSub = {"Inrikes", "Utrikes"};
	private String[] foodSub = {"Träning", "Mat", "Själ"};
	
	private UI ui;

	public Controller() {
		ui = new UI();
		setUI();
	}
	
	public void setSport() {
		
	}
	
	public void setUI() {
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(900, 700));
		frame.add(ui);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public static void main(String [] args) {
		Controller cont = new Controller();
	}
}
