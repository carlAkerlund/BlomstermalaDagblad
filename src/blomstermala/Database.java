package blomstermala;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Blob;



public class Database {

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
	public void getCategorys() {
		System.out.println("Database: ");
		try {
			conn = connectToDB();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from Artikel");
			while (rs.next()) {
				System.out.println(rs.getString("Kategori"));
				System.out.println("Kategorier hämtade");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getHeadline() {
		System.out.println("Database: ");
		try {
			conn = connectToDB();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from Artikel");
			while (rs.next()) {
				System.out.println(rs.getString("Rubrik"));
				
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
			String sql = "insert into User " + "(Username)"
					+ "values(" + "'" + username + "'";
			stat.executeUpdate(sql);
			System.out.println("User added!");

		} catch (Exception e) {
			System.out.println("");
		}
	}
	public static void main(String [] args){
		Database db = new Database();
		db.getCategorys();
	}
}
