package models;

import java.util.ArrayList;

public class Calendrier extends Impression{
	
	private ArrayList<Page> pageCal = new ArrayList<Page>(); 
	private String model;
	
	public Calendrier(String format, String qualite, int nbExemp,Commande cmd,Support supp,String model) {
		super(format,qualite,nbExemp,cmd,supp);
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public ArrayList<Page> getPageCal() {
		return pageCal;
	}

	public void setPageCal(ArrayList<Page> pageCal) {
		this.pageCal = pageCal;
	}
	
	

}
