package blomstermala;

public class Kommentar {
	private String innehall;
	private String namn;
	
	public Kommentar(String namn, String innehall){
		this.namn = namn;
		this.innehall = innehall;
	}
	
	public String getInnehall() {
		return innehall;
	}
	public void setInnehall(String innehall) {
		this.innehall = innehall;
	}
	public String getNamn() {
		return namn;
	}
	public void setNamn(String namn) {
		this.namn = namn;
	}
}
