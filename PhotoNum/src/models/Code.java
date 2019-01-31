package src.models;

import java.util.Random;

public class Code {
	
	private String idcode;
	private int valeur;
	
	public Code(String code, int valeur) {
		this.idcode=code;
		this.valeur = valeur;
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
	

}
