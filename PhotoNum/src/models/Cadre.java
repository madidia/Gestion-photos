package models;

public class Cadre extends Impression{
	private String model;
	private String taille;
	
	public Cadre(int idImp ,String format, String qualite, int nbEx ,String model, String taille) {
		super(idImp,format,qualite,nbEx);
		this.model = model;
		this.taille = taille;
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
