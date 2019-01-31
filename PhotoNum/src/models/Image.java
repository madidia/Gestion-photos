package src.models;

import java.util.Date;

public class Image {
	private String chemin;
	private int resolution;
	private String partage;
	private Date dateDUtilisation;
	private String mailProprio;
	
	public Image(String chemin,String mail,int resolution,String partage) {
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

	public String isPartage() {
		return partage;
	}

	public void setPartage(String partage) {
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
