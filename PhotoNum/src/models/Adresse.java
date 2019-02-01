package src.models;

public class Adresse {
	private int id;
	private String adresse;
	private Utilisateur user;

	public Adresse(String adresse, Utilisateur user) {
		this.adresse = adresse;
		this.user=user;
	}

	public void infoAdresse() {
		System.out.println(this.adresse);
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the user
	 */
	public Utilisateur getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(Utilisateur user) {
		this.user = user;
	}



}
