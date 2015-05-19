package blomstermala;

public class Article {

	private int ID;
	private String Rubrik;
	private String Innehåll;
	private String datum;
	private String Kategori;
	
	public Article(int inID, String inRubrik, String inInnehåll, String indatum, String inKategori){
		this.Rubrik = inRubrik;
		this.ID = inID;
		this.Innehåll = inInnehåll;
		this.datum = indatum;
		this.Kategori = inKategori;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRubrik() {
		return Rubrik;
	}

	public void setRubrik(String rubrik) {
		Rubrik = rubrik;
	}

	public String getInnehåll() {
		return Innehåll;
	}

	public void setInnehåll(String innehåll) {
		Innehåll = innehåll;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getKategori() {
		return Kategori;
	}

	public void setKategori(String kategori) {
		Kategori = kategori;
	}
	
}
