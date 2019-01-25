package models;

import java.sql.Date;

public class Operation {

	private Date date;
	private String detail;
	private Administrateur admin;
	
	public Operation(Date date, String detail, Administrateur admin) {
		this.date = date;
		this.detail = detail;
		this.setAdmin(admin);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}
	
	
}
