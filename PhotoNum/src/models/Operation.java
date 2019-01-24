package models;

import java.sql.Date;

public class Operation {

	private Date date;
	private String detail;
	
	public Operation(Date date, String detail) {
		super();
		this.date = date;
		this.detail = detail;
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
	
	
}
