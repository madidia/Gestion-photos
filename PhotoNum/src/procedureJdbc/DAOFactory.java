package procedureJdbc;

public class DAOFactory {

	public static UtilisateurDAO getSocieteDAO(){
		
		return new ClientDAO();
	}
}
