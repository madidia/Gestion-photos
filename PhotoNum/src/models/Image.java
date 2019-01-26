package models;

import java.util.Date;

public class Image {
	private String chemin;
	private int resolution;
	private boolean partage;
	private Date dateDUtilisation;
	private String mailProprio;
	
	public Image(String chemin,int resolution, String mail, boolean partage) {
		super();
		this.chemin = chemin;
		this.setResolution(resolution);
		this.dateDUtilisation = new Date();
		this.partage = partage;
		this.setMailProprio(mail);
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public boolean isPartage() {
		return partage;
	}

	public void setPartage(boolean partage) {
		this.partage = partage;
	}

	public Date getDateDUtilisation() {
		return dateDUtilisation;
	}

	public void setDateDUtilisation(Date dateDUtilisation) {
		this.dateDUtilisation = dateDUtilisation;
	}

	public String getMailProprio() {
		return mailProprio;
	}

	public void setMailProprio(String mailProprio) {
		this.mailProprio = mailProprio;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
	
}
