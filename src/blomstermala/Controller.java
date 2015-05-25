package blomstermala;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void transferArticles(String cat) throws FileNotFoundException, IOException {
		Article[] inArticles = dataB.returnarticle();
		List outArticles = new ArrayList();
	
	
		int count=0;
		
		for(int i=0 ; i<inArticles.length ; i++){
			if(inArticles[i].getKategori().equals(cat)){
				outArticles.add(inArticles[i]);
				count++;
			}
		}
		
		ui.setArticles(outArticles);
	}
	
	public void transferArticles(String cat, String underCat) throws FileNotFoundException, IOException {
		Article[] inArticles = dataB.returnarticle();
		Article[] outArticles = new Article[inArticles.length];
		
		int count=0;
		
		for(int i=0 ; i<inArticles.length ; i++){
			if(inArticles[i].getKategori().equals(cat) && inArticles[i].getUnderkategori().equals(underCat)){
				outArticles[count] = inArticles[i];
				count++;
			}
		}
		
		ui.setArticles(outArticles);
	}
	
	
	
	public void saveComment(Article art, String commentName, String comment){
		art.setKommentar(comment);
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
