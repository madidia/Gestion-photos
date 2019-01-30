package main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import connexion.Connexion;
import models.Adresse;
import models.Client;
import models.Code;
import models.Commande;
import models.Impression;
import models.Support;
import procedureJdbc.*;

public class Test {

	public static void main(String[] args) throws SQLException, ParseException {
		ClientDAO c = new ClientDAO();
		c.conn = Connexion.getConnection();
		Client ac = c.find("sgidney0@typepad.com");
		
		CommandeDAO com = new CommandeDAO();
		com.conn=Connexion.getConnection();
		Commande cmd = new Commande(ac, 
				new Adresse(1,"6 bis rue du vieux temple 38000 Grenoble", ac), new Date(), 
				"en attente", new Code("assane", 5));
					
		cmd.getImpressions().add(new Impression("A3", "faible", 100,cmd,new Support("papier",
				"A3", "faible", 500, 1.5)));
		
		cmd.calculeMontant(cmd.getImpressions());
		
		/** creer commande */
		com.create(cmd);
		
		System.out.println("commande num "+cmd.getId());
		
		SupportDAO s= new SupportDAO();
		s.conn=Connexion.getConnection();
		//Support sp=s.find("papier-A3-faible");
		Support sup=s.create(new Support("papier","A4", "faible", 500, 1.5));
		/**creer support */
		System.out.println("format du support "+sup.getFormat());
		
		ImpressionDAO idao = new ImpressionDAO();
		idao.conn=Connexion.getConnection();
		Impression i=idao.create(new Impression("A3", "faible", 100,cmd,sup));
		
		/** creer impression */
		System.out.println("id du imp "+i.getId());
		
		System.out.println("le code du client ac est "+ac.getListCode().get(0).getIdCode()); 

		 
	}

}
