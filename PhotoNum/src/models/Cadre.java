package src.models;

public class Cadre extends Impression{
	private String model;
	private String taille;

	public Cadre(Impression imp,String model, String taille) {
		super(imp.getFormat(),imp.getQualite(),imp.getNbExemplaire(),imp.getCmd() , imp.getSupport());
		this.setModel(model);
		this.setTaille(taille);
	}

	/**
	 * @return the taille
	 */
	public String getTaille() {
		return taille;
	}

	/**
	 * @param taille the taille to set
	 */
	public void setTaille(String taille) {
		this.taille = taille;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}



}
