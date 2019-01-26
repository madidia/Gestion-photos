package models;

public class Code {
	
	private String code;
	private int valeur;
	
	public Code(String code, int valeur) {
		this.setCode(code);
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
