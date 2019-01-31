package src.models;

public class Agenda extends Impression{
    private String typeAgenda;
	private String model;
	
	public Agenda(Impression imp,String typeAgenda,String modelAgenda) {
		super(imp.getFormat(),imp.getQualite(),imp.getNbExemplaire(),imp.getCmd(),imp.getSupport());
		this.setModel(modelAgenda);
		this.setTypeAgenda(typeAgenda);
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
