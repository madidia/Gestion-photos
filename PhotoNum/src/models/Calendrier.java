package models;

import java.util.ArrayList;

public class Calendrier extends Impression{
	
	private ArrayList<Page> pageCal = new ArrayList<Page>(); 
	private String model;
	
	public Calendrier(int idImp ,String format, String qualite, int nbExemp, String model) {
		super(idImp,format,qualite,nbExemp);
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
