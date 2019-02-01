package src.models;

public class Administrateur extends Utilisateur{

	private String nom;
	private String prenom;
	private String password;
	
	/**
	 * 
	 * @param mail
	 * @param nom
	 * @param prenom
	 * @param password
	 */
	public Administrateur(String mail, String nom, String prenom, String password) {
		super(mail);
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}

	/**
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * 
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
