package blomstermala;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;





public class Database {

	
	private Article article1, article2, article3;
	private ArrayList <Article> articles = new ArrayList();
	private Connection conn;
	private Statement stat;
	private ResultSet rs;
	private final String DATABASE_URL = "jdbc:mysql://localhost:3306/BlomstermalaDagblad";
	private final String USERNAME = "root";
	private final String PASSWORD = "qweasd123";
	
	public Connection connectToDB() {
		System.out.println("Database: Start");
		try {
			conn = DriverManager
					.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void getArticles() {
		System.out.println("Database: ");
		try {
			conn = connectToDB();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from Artikel");
			while (rs.next()) {
				article1 = new Article (rs.getInt("ID"), rs.getString("Rubrik"),
				rs.getString("Innehåll"), rs.getString("Ingress"), rs.getString("Kategori"),rs.getString("Underkategori"));
				article2 = new Article (rs.getInt("ID"), rs.getString("Rubrik"),
						rs.getString("Innehåll"), rs.getString("Ingress"), rs.getString("Kategori"),rs.getString("Underkategori"));
//				article3 = new Article (rs.getInt("ID"), rs.getString("Rubrik"),
//						rs.getString("Innehåll"), rs.getString("Ingress"), rs.getString("Kategori"),rs.getString("Underkategori"));
				System.out.println("Kategorier hämtade");
				System.out.println(article1.getKategori());
				System.out.println(article2.getKategori());
				System.out.println(article3.getKategori());
				articles.add(article1);
				articles.add(article2);
				articles.add(article3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList <Article> returnarticle(){
		getArticles();
		System.out.println("Articles: " + articles.size());
		return articles;
		}
	
	public void getArticle() {
		System.out.println("Database: ");
		try {
			conn = connectToDB();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from Artikel");
			while (rs.next()) {
				String File = rs.getString("Innehåll");
				try(BufferedReader br = new BufferedReader(new FileReader(File))){
					StringBuilder sb = new StringBuilder();
					String line = br.readLine();
					while(line != null){
						sb.append(line);
						sb.append(System.lineSeparator());
						line = br.readLine();
					}
					String e = sb.toString();
					System.out.println(e);
				}
				
				System.out.println("Artikel hämtad");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setUserDB(String namn, String kommentar) {
		System.out.println("Database: setUser()");
		try {
			conn = connectToDB();
			Statement stat = conn.createStatement();
			String sql = "insert into Kommentar " + "(Namn)" + "(Innehåll)"
					+ "values(" + "'" + namn + "'" + "'" + kommentar  + "'" + ")";
			stat.executeUpdate(sql);
			System.out.println("User added!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getComments() {
		System.out.println("Database: ");
		String kommentar = " ";
		try {
			conn = connectToDB();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from Kommentar");
			while (rs.next()) {
				kommentar = rs.getString("Namn") + " " +  rs.getString("Innehåll");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kommentar;
	}
	public static void main(String [] args){
		Database db = new Database();
		db.getArticles();
	}
}
