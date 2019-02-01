package src.main;

import java.sql.SQLException;
import java.text.ParseException;

import src.connexion.Connexion;
import src.menu.Menu;
import src.procedureJdbc.*;

public class Test {

	public static void main(String[] args) throws SQLException, ParseException {
		DAO.conn = Connexion.getConnection();
		Menu m = new Menu();
		m.menuPrincipal();
        DAO.conn.close();
        System.out.println("fin");
	}

}
