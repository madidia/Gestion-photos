package models;

public class Adresse {
	private String id;
	private String adresse;
	private String mail;
	
	public Adresse(String id, String adresse, String mail) {
		this.id = id;
		this.adresse = adresse;
		this.setMail(mail);
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
