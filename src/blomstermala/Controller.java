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
	private ArrayList <Article>articles;

	public Controller() {
		ui = new UI(this);
		setUI();
		dataB = new Database();
		
		articles =  new ArrayList <Article> (dataB.returnarticle());
		ui.setArticles((ArrayList<Article>) articles);
	}
	
	public void setSport() {
		
	}
	
	public void article() {
		setKommentarer();
		System.out.println(articles.get(0).getKommentar()[0].getInnehall());
		ui = new UI(this, articles.get(0));
		setUI();
	}
	
	public void setComment(String namn, String innehåll){
		articles.get(0).tabortKommentarer();
		dataB.setComment(namn, innehåll);
	}
	
	public void transferArticles(String cat) throws FileNotFoundException, IOException {
		ArrayList <Article>inArticles =  new ArrayList <Article> (dataB.returnarticle());
		articles.clear();
		
		for(int i=0 ; i<inArticles.size(); i++){
			if(inArticles.get(i).getKategori().equals(cat)){
				articles.add((Article)inArticles.get(i));
			}
		}
		
		for(int i=0; i<articles.size() ; i++){
			System.out.println(articles.get(i).getRubrik());
		}
		
		ui.setArticles((ArrayList<Article>) articles);
//		ui.setCenter();
		
	}
	
	public void transferArticles(String cat, String underCat) throws FileNotFoundException, IOException {
		ArrayList <Article>inArticles =  new ArrayList <Article> (dataB.returnarticle());
		
		articles.clear();
		
		for(int i=0 ; i<inArticles.size(); i++){
			if(inArticles.get(i).getKategori().equals(cat) && inArticles.get(i).getUnderkategori().equals(underCat)){
				articles.add((Article)inArticles.get(i));
			}
		}
		
		
		ui.setArticles((ArrayList<Article>) articles);
	}
	
	
	public void setKommentarer(){
//		System.out.println("#1");
//		for(int i=0;i<1 ;i++){
//			System.out.println(dataB.returncomment().get(i).getNamn());
//			System.out.println(dataB.returncomment().get(i).getInnehall());
//		}
		for(int i=0;i<dataB.returncomment().size() ;i++){	
			articles.get(0).setKommentar(new Kommentar(dataB.returncomment().get(i).getNamn(), dataB.returncomment().get(i).getInnehall()));
		}
	}	
//	public void saveComment(Article art, String commentName, String comment){
//		art.setKommentar(comment);
//		dataB.setUserDB(commentName, art.getKommentar()[art.getKommentar().length]);
//	}
	
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
