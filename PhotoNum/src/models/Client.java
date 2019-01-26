package models;

import java.util.ArrayList;

public class Client extends Utilisateur{
	private String nom;
	private String prenom;
	private String password;
	private ArrayList<CodePersonnel> ListCode= new ArrayList<CodePersonnel>();
	private ArrayList<Adresse> ListAdresse= new ArrayList<Adresse>();
	private ArrayList<Image> ListImage = new ArrayList<Image>();
	
	public Client(String mail,String nom, String prenom, String password) {
		super(mail);
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
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

	public ArrayList<CodePersonnel> getListCode() {
		return ListCode;
	}

	public void setListCode(ArrayList<CodePersonnel> listCode) {
		ListCode = listCode;
	}

	public ArrayList<Adresse> getListAdresse() {
		return ListAdresse;
	}

	public void setListAdresse(ArrayList<Adresse> listAdresse) {
		ListAdresse = listAdresse;
	}

	public ArrayList<Image> getListImage() {
		return ListImage;
	}

	public void setListImage(ArrayList<Image> listImage) {
		ListImage = listImage;
	}
	
}
