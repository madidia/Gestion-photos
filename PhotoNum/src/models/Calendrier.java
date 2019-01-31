package src.models;

import java.util.ArrayList;

public class Calendrier extends Impression{
	
	private ArrayList<Page> pageCal = new ArrayList<Page>(); 
	private String model;
	
	public Calendrier(Impression imp,String model) {
		super(imp.getFormat(),imp.getQualite(),imp.getNbExemplaire(),imp.getCmd(),imp.getSupport());
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
