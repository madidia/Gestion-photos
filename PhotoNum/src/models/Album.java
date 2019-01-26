package models;

import java.util.ArrayList;

public class Album extends Impression{

	private String titre;
	private ArrayList<Page> pageAlb = new ArrayList<Page>();
	
	public Album(int idImp, String titre, String format, String qualite, int nbExemplaire) {
		super(idImp,format,qualite,nbExemplaire);
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public ArrayList<Page> getPageAlb() {
		return pageAlb;
	}

	public void setPageAlb(ArrayList<Page> pageAlb) {
		this.pageAlb = pageAlb;
	}
}
