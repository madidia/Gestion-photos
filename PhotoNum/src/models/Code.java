package src.models;

import java.util.Random;

public class Code {
	
	private String idcode;
	private int valeur;
	private String utilise;
	
	public Code(String code, int valeur) {
		this.idcode=code;
		this.valeur = valeur;
		this.setUtilise("non");
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getIdCode() {
		return idcode;
	}

	public void setIdCode(String code) {
		this.idcode = code;
	}
	
	public String genererCode() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public String infosCode() {
		return "Code :"+this.getIdCode()+", Valeur :"+this.getValeur();
	}

	/**
	 * @return the utilise
	 */
	public String getUtilise() {
		return utilise;
	}

	/**
	 * @param utilise the utilise to set
	 */
	public void setUtilise(String utilise) {
		this.utilise = utilise;
	}
	

}
