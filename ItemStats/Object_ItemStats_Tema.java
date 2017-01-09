package ItemStats;

public class Object_ItemStats_Tema {

	public String Egennavn_Norsk;
	public String Egennavn_Engelsk;
	
	public String Generalisering;
	
	public String Hovedkategori;
	public String Subkategori;
	
	public String Kategori_Miniatyrfigurer;
	
	public Object_ItemStats_Tema(String Egennavn_Norsk, String Egennavn_Engelsk, String Hovedkategori, String Subkategori, String Kategori_Miniatyrfigurer, String Generalisering ) {
		this.Egennavn_Norsk = Egennavn_Norsk;
		this.Egennavn_Engelsk = Egennavn_Engelsk;
		this.Hovedkategori = Hovedkategori;
		this.Subkategori = Subkategori;
		this.Kategori_Miniatyrfigurer = Kategori_Miniatyrfigurer;
		this.Generalisering = Generalisering;
	}
}
