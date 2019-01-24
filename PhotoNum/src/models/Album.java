package models;

public class Album {

	private String titre;
	private String format;
	private String qualite;
	
	public Album(String titre, String format, String qualite) {
		super();
		this.titre = titre;
		this.format = format;
		this.qualite = qualite;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getQualite() {
		return qualite;
	}

	public void setQualite(String qualite) {
		this.qualite = qualite;
	}
	
	
}
