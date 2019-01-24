package models;

public class Cadre {

	private String format;
	private String qualite;
	private String model;
	private String taille;
	
	public Cadre(String format, String qualite, String model, String taille) {
		super();
		this.format = format;
		this.qualite = qualite;
		this.model = model;
		this.taille = taille;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}
	
	
}
