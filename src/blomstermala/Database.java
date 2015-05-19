package blomstermala;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;





public class Database {

	private Article article;
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
			String kommentar = getComments();
			conn = connectToDB();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from Artikel");
			while (rs.next()) {
				Article article1 = new Article(rs.getInt("ID"), rs.getString("Rubrik"),
				rs.getString("Innehåll"), rs.getString("Publiceringsdatum"), rs.getString("Kategori"),
				kommentar);
				System.out.println(kommentar);
				System.out.println("Kategorier hämtade");
				
			}
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
				kommentar = rs.getString("Namn") + " " +  rs.getString("Innehåll")
						+ " " + rs.getString("Datum");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kommentar;
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
	public void setUserDB(String username) {
		System.out.println("Database: setUser()");
		try {
			conn = connectToDB();
			Statement stat = conn.createStatement();
			String sql = "insert into Kommentar " + "(Namn)"
					+ "values(" + "'" + username + "'";
			stat.executeUpdate(sql);
			System.out.println("User added!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String [] args){
		Database db = new Database();
		db.getArticles();
	}
}
