package models;

public class Administateur {

	private String mail;
	private String nom;
	private String prenom;
	private String password;
	
	public Administateur(String mail, String nom, String prenom, String password) {
		super();
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
