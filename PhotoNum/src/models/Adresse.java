package models;

public class Adresse {
	private String id;
	private String adresse;
	
	public Adresse(String id, String adresse) {
		super();
		this.id = id;
		this.adresse = adresse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
