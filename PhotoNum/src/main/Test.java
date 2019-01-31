package src.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import src.connexion.Connexion;
import src.menu.Menu;
import src.models.*;
import src.procedureJdbc.*;

public class Test {

	public static void main(String[] args) throws SQLException, ParseException {
		DAO.conn = Connexion.getConnection();
		Menu m = new Menu();
		m.menuPrincipal();
		/*
		ClientDAO c = new ClientDAO();
		Client ac = c.find("sgidney0@typepad.com");
		CommandeDAO com = new CommandeDAO();
		Commande cmd = new Commande(ac, 
				new Adresse(1,"6 bis rue du vieux temple 38000 Grenoble", ac), new Date(), 
				"en attente", new Code("assane", 5));
		
		//System.out.println("commande num "+cmd.getId());
		SupportDAO s= new SupportDAO();
		//Support sp=s.find("papier-A3-faible");
		Support sup=s.create(new Support("papier","A19", "faible", 500, 1.5));
		/**creer support 
		System.out.println("format du support "+sup.getFormat());
		
		cmd.getImpressions().add(new Impression("A6", "faible", 100,cmd,sup));
		
		cmd.calculeMontant(cmd.getImpressions());
		ImageDAO imgd = new ImageDAO();
		Image img = imgd.create(new Image("ABCD","sgidney0@typepad.com",10,"oui"));
		/** creer commande 
		com.create(cmd);
		
		ImpressionDAO impd = new ImpressionDAO();
		Impression imp = impd.create(new Impression("A6", "faible", 100,cmd,sup));
		
		AlbumDAO idao = new AlbumDAO();
		Album i=idao.create(new Album(imp, "monalbum","ABCD"));
		
		/** creer impression 
		System.out.println("id du imp "+i.getId());
		//System.out.println("impression de notre commande : "+cmd.getImpressions().get(cmd.getImpressions().size()-1).getId());
	    //System.out.println("le code du client ac est "+ac.getListCode().get(0).getIdCode()); */
        DAO.conn.close();
        System.out.println("fin");
	}

}
