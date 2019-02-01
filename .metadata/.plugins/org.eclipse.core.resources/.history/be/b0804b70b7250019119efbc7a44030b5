package src.models;

import java.util.Date;

public class Image {
	private String chemin;
	private int resolution;
	private String partage;
	private Date dateDUtilisation;
	private Client proprio;
	
	public Image(String chemin,Client client,int resolution,String partage) {
		this.chemin = chemin;
		this.setResolution(resolution);
		this.dateDUtilisation = new Date();
		this.partage = partage;
		this.proprio = client;
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

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public Client getProprio() {
		return proprio;
	}

	public void setProprio(Client proprio) {
		this.proprio = proprio;
	}
	
}
