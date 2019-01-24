package models;

public class Tirage {
	private String format;
	private String qualite;
	
	public Tirage(String format, String qualite) {
		super();
		this.format = format;
		this.qualite = qualite;
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
	
	
}
