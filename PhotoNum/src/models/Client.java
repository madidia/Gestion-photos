package src.models;

import java.util.ArrayList;

public class Client extends Utilisateur{
	private String nom;
	private String prenom;
	private String password;
	private String etat;
	private ArrayList<Commande> ListCommande= new ArrayList<Commande>();
	private ArrayList<Code> ListCode= new ArrayList<Code>();
	private ArrayList<Adresse> ListAdresse= new ArrayList<Adresse>();
	private ArrayList<Image> ListImage = new ArrayList<Image>();
	
	public Client(String mail,String nom, String prenom, String password) {
		super(mail);
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.setEtat("actif");
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

	

	public ArrayList<Adresse> getListAdresse() {
		return ListAdresse;
	}

	public ArrayList<Image> getListImage() {
		return ListImage;
	}
	

	/**
	 * @return the listCode
	 */
	public ArrayList<Code> getListCode() {
		return ListCode;
	}

	/**
	 * @param listCode the listCode to set
	 */
	public void setListCode(ArrayList<Code> listCode) {
		ListCode = listCode;
	}

	/**
	 * @return the listCommande
	 */
	public ArrayList<Commande> getListCommande() {
		return ListCommande;
	}

	/**
	 * @param listCommande the listCommande to set
	 */
	public void setListCommande(ArrayList<Commande> listCommande) {
		ListCommande = listCommande;
	}
	
	public void infosClient() {
		System.out.println("Nom : "+this.getNom()+",prenom : "+this.getPrenom()
			+",email : "+this.getMail()+", mot de passe : "+this.getPassword());		
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
