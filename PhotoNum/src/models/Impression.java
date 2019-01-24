package models;

public class Impression {
	private int id;
	private String format;
	private String qualite;
	private int nbExemplaire;
	
	public Impression(int id, String format, String qualite, int nbExemplaire) {
		super();
		this.id = id;
		this.format = format;
		this.qualite = qualite;
		this.nbExemplaire = nbExemplaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNbExemplaire() {
		return nbExemplaire;
	}

	public void setNbExemplaire(int nbExemplaire) {
		this.nbExemplaire = nbExemplaire;
	}
	
	
	

}
