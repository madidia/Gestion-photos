package models;

public class Image {
	private String chemin;
	private String resolution;
	private String partage;
	
	public Image(String chemin, String resolution, String partage) {
		super();
		this.chemin = chemin;
		this.resolution = resolution;
		this.partage = partage;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getPartage() {
		return partage;
	}

	public void setPartage(String partage) {
		this.partage = partage;
	}
	
}
