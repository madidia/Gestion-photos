package models;

public class Calendrier {
	
	private String format;
	private String qualite;
	private String model;
	
	public Calendrier(String format, String qualite, String model) {
		super();
		this.format = format;
		this.qualite = qualite;
		this.model = model;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getQualite() {
		return qualite;
	}

	public void setQualite(String qualite) {
		this.qualite = qualite;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	

}
