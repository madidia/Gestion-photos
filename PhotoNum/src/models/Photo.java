package src.models;

public class Photo {

	private int id;
	private Image img;
	private int resolution;
	private String parametre;
	
	public Photo(Image img, int resolution, String parametre) {
		this.setImg(img);
		this.setResolution(resolution);
		this.parametre = parametre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParametre() {
		return parametre;
	}

	public void setParametre(String parametre) {
		this.parametre = parametre;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
	
	
}
