package src.models;

import java.util.ArrayList;

public class Album extends Impression{

	private String titre;
	private String couverture;
	private ArrayList<Page> pageAlb = new ArrayList<Page>();
	
	public Album(Impression imp,String titre, String couverture) {
		super(imp.getFormat(),imp.getQualite(),imp.getNbExemplaire(),imp.getCmd(),imp.getSupport());
		this.setCouverture(couverture);
		this.setTitre(titre);
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the couverture
	 */
	public String getCouverture() {
		return couverture;
	}

	/**
	 * @param couverture the couverture to set
	 */
	public void setCouverture(String couverture) {
		this.couverture = couverture;
	}

	/**
	 * @return the pageAlb
	 */
	public ArrayList<Page> getPageAlb() {
		return pageAlb;
	}

	/**
	 * @param pageAlb the pageAlb to set
	 */
	public void setPageAlb(ArrayList<Page> pageAlb) {
		this.pageAlb = pageAlb;
	}

	
}
