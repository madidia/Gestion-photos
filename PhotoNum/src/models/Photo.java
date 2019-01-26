package models;

public class Photo {

	private int id;
	private String chemin;
	private String resolution;
	private String parametre;
	
	public Photo(int id, String chemin, String resolution, String parametre) {
		this.id = id;
		this.chemin = chemin;
		this.resolution = resolution;
		this.parametre = parametre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getParametre() {
		return parametre;
	}

	public void setParametre(String parametre) {
		this.parametre = parametre;
	}
	
	
}
