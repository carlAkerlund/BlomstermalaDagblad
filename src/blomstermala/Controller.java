package blomstermala;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Controller {
	
	private UI ui;

	public Controller() {
		ui = new UI(this, new Database());
		setUI();
	}
	
	public void setSport() {
		
	}
	
	public void getArticles(String cat, String underCat) {
		
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
