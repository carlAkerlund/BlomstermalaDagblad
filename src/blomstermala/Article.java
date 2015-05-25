package blomstermala;

public class Article {

	private int ID;
	private String Rubrik;
	private String Innehåll;
	private String underkategori;
	private String Kategori;
	private String[] Kommentar;
	private String ingress;
	
	public Article(int inID, String inRubrik, String inInnehåll,String inIngress
			, String inKategori, String inUnderkategori){
		this.Rubrik = inRubrik;
		this.ID = inID;
		this.Innehåll = inInnehåll;
		this.Kategori = inKategori;
		this.ingress = inIngress;
		this.underkategori = inUnderkategori;
	}

	public String[] getKommentar() {
		return Kommentar;
	}

	public void setKommentar(String kommentar) {
		String[] nyKommentar = new String[Kommentar.length + 1];
		for(int i=0 ; i<nyKommentar.length ; i++){
			if(i==nyKommentar.length-1){
				nyKommentar[i] = kommentar;
			}else{
				nyKommentar[i] = Kommentar[i];
			}
		}
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

	public String getUnderkategori() {
		return underkategori;
	}

	public void setUnderkategori(String underkategori) {
		this.underkategori = underkategori;
	}

	public String getIngress() {
		return ingress;
	}

	public void setIngress(String ingress) {
		this.ingress = ingress;
	}

	public String getKategori() {
		return Kategori;
	}

	public void setKategori(String kategori) {
		Kategori = kategori;
	}
	
}
