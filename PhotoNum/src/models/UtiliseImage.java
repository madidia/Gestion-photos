package models;

import java.util.Date;

public class UtiliseImage {

	private String chemin;
	private String mail;
	private Date date;
	
	public UtiliseImage(String chemin, String mail, Date date) {
		super();
		this.chemin = chemin;
		this.mail = mail;
		this.date = date;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
