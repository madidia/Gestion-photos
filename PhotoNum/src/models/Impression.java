package models;

public class Impression {
	private int id;
	private String format;
	private String qualite;
	private int nbExemplaire;
	private int numCommande;
	private String formatSupport;
	private String qualiteSupport;
	private String typeSupport;
	
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

	public String getFormatSupport() {
		return formatSupport;
	}

	public void setFormatSupport(String formatSupport) {
		this.formatSupport = formatSupport;
	}

	public int getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}

	public String getQualiteSupport() {
		return qualiteSupport;
	}

	public void setQualiteSupport(String qualiteSupport) {
		this.qualiteSupport = qualiteSupport;
	}

	public String getTypeSupport() {
		return typeSupport;
	}

	public void setTypeSupport(String typeSupport) {
		this.typeSupport = typeSupport;
	}
	
	
	

}
