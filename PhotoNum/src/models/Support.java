package src.models;

public class Support {

	private String type;
	private String format;
	private String qualite;
	private int quantite;
	private double prix;
	
	public Support(String type, String format, String qualite, int quantite, double prix) {
		this.type = type;
		this.format = format;
		this.qualite = qualite;
		this.quantite = quantite;
		this.prix = prix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String getMonSupport() {
		return "Type : "+this.getType()+", format :"+this.getFormat()+",qualite :"+
				this.getQualite()+", PU :"+this.getPrix()+", quantite disponible :"+this.getQuantite();
	}
	
	
}
