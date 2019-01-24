package models;

public class Page {

	private int id;
	private int numero;
	
	public Page(int id, int numero) {
		super();
		this.id = id;
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
