package procedureJdbc;

public class DAOFactory {

	public static ClientDAO getSocieteDAO(){
		
		return new ClientDAO();
	}
}
