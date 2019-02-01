package src.models;

import java.util.Date;

public class Image {
	private String chemin;
	private double resolution;
	private String partage;
	private Date dateDUtilisation;
	private Client proprio;
	
	public Image(String chemin,Client client,double resolution,String partage) {
		this.chemin = chemin;
		this.resolution=resolution;
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


	public Client getProprio() {
		return proprio;
	}

	public void setProprio(Client proprio) {
		this.proprio = proprio;
	}

	/**
	 * @return the resolution
	 */
	public double getResolution() {
		return resolution;
	}

	/**
	 * @param resolution the resolution to set
	 */
	public void setResolution(double resolution) {
		this.resolution = resolution;
	}
	
	public String  infosImage() {
		return "Chemin :"+this.getChemin()+"resolution :"+this.getResolution()
		+"visible par tous :"+this.isPartage();
	}
	
}
