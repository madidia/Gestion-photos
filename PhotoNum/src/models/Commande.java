package src.models;

import java.util.ArrayList;
import java.util.Date;

public class Commande {
	private int id;
	private Client client;
	private Date date;
	private Adresse adresse;
	private double montant;
	private String statut;
	private Code code;
	private ArrayList<Impression> impressions = new ArrayList<>();
	
	public Commande(Client client,Adresse adresse, String status, Code c) {
		this.client=client;
		this.adresse=adresse;
		this.date=new Date();
		this.setStatut(status);
		this.code=c;
	}

	

	public void calculeMontant(ArrayList<Impression> imp) {

		double m=0;
		int nb;
		double pu;
		
		for(int i=0;i<imp.size();i++) {
			nb=imp.get(i).getNbExemplaire();
			pu=imp.get(i).getSupport().getPrix();
			m=m+(nb*pu);
		}
		this.setMontant(m);
	}
	
	


	/**
	 * @return the impressions
	 */
	public ArrayList<Impression> getImpressions() {
		return impressions;
	}

	/**
	 * @param impressions the impressions to set
	 */
	public void setImpressions(ArrayList<Impression> impressions) {
		this.impressions = impressions;
	}

	
	/**
	 * @return the idAdresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param idAdresse the idAdresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the code
	 */
	public Code getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Code code) {
		this.code = code;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}



	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}



	/**
	 * @return the montant
	 */
	public double getMontant() {
		this.calculeMontant(this.impressions);
		return montant;
	}



	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}



	/**
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}



	/**
	 * @param statut the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}



	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}



	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
