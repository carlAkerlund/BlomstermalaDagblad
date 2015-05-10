package blomstermala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Database {

	private Connection conn;
	private Statement stat;
	private ResultSet rs;
	private final String DATABASE_URL = "jdbc:mysql:///";
	private final String USERNAME = "";
	private final String PASSWORD = "";
	
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
	public void getCategorys() {
		System.out.println("Database: ");
		try {
			conn = connectToDB();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from ");
			while (rs.next()) {
				
				System.out.println("Kategorier hämtade");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getArticles() {
		System.out.println("Database: ");
		try {
			conn = connectToDB();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from ");
			while (rs.next()) {
				
				System.out.println("Artiklar hämtade");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getArticle() {
		System.out.println("Database: ");
		try {
			conn = connectToDB();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from ");
			while (rs.next()) {
				
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
			String sql = "insert into User " + "(Username)"
					+ "values(" + "'" + username + "'";
			stat.executeUpdate(sql);
			System.out.println("User added!");

		} catch (Exception e) {
			System.out.println("");
		}
	}
	public void main(String [] args){
		Database db = new Database();
	}
}
