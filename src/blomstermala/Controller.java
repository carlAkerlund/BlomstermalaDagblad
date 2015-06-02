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
		
		ArrayList <Article>articles =  new ArrayList <Article> (dataB.returnarticle());
		ui.setArticles((ArrayList<Article>) articles);
	}
	
	public void setSport() {
		
	}
	
	public void transferArticles(String cat) throws FileNotFoundException, IOException {
		ArrayList <Article>inArticles =  new ArrayList <Article> (dataB.returnarticle());
		List<Article> outArticles = new ArrayList<Article>();
	
	
		int count=0;
		
		for(int i=0 ; i<inArticles.size(); i++){
			if(inArticles.get(i).getKategori().equals(cat)){
				outArticles.add((Article)inArticles.get(i));
				count++;
			}
		}
		
		for(int i=0; i<outArticles.size() ; i++){
			System.out.println(outArticles.get(i).getRubrik());
		}
		
		ui.setArticles((ArrayList<Article>) outArticles);
//		ui.setCenter();
		
	}
	
	public void transferArticles(String cat, String underCat) throws FileNotFoundException, IOException {
		ArrayList <Article>inArticles =  new ArrayList <Article> (dataB.returnarticle());
		List<Article> outArticles = new ArrayList<Article>();
		
		int count=0;
		
		for(int i=0 ; i<inArticles.size(); i++){
			if(inArticles.get(i).getKategori().equals(cat)){
				outArticles.add((Article)inArticles.get(i));
				count++;
			}
		}
		
		
		ui.setArticles((ArrayList<Article>) outArticles);
//		ui.setCenter();
	}
	
	
	
	public void saveComment(Article art, String commentName, String comment){
		art.setKommentar(comment);
		dataB.setUserDB(commentName, art.getKommentar()[art.getKommentar().length]);
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
