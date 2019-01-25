package models;

public class Agenda extends Impression{
    private String typeAgenda;
	private String model;
	
	public Agenda(int idImp,String format, String qualite,int nbExp,String typeAgenda,String model) {
		super(idImp,format,qualite,nbExp);
		this.setTypeAgenda(typeAgenda);
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTypeAgenda() {
		return typeAgenda;
	}

	public void setTypeAgenda(String typeAgenda) {
		this.typeAgenda = typeAgenda;
	}
	
}
