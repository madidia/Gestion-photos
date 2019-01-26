package models;

import java.util.ArrayList;

public class Page {

	private int id;
	private int numero;
	private ArrayList<Photo> PhotoPage = new ArrayList<Photo>();
	
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

	public ArrayList<Photo> getPhotoPage() {
		return PhotoPage;
	}

	public void setPhotoPage(ArrayList<Photo> photoPage) {
		PhotoPage = photoPage;
	}
	
	
}
