package blomstermala;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Controller {
	
	private UI ui;
	private Database dataB;

	public Controller() {
		ui = new UI(this);
		setUI();
		dataB = new Database();
	}
	
	public void setSport() {
		
	}
	
	public void transferArticles(String cat, String underCat) {
		dataB.getArticles();
	}
	
	public void saveComment(){
		
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
