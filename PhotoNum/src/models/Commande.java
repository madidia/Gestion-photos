package models;

import java.util.Date;

public class Commande {
	private String id;
	private Date date;
	private int montant;
	private String status;
	
	public Commande(String id, Date date, int montant, String status) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
