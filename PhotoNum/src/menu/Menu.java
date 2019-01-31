package src.menu;

import java.sql.SQLException;
import java.util.ArrayList;

import src.models.Adresse;
import src.models.Client;
import src.models.Commande;
import src.models.LectureClavier;
import src.procedureJdbc.AdresseDAO;
import src.procedureJdbc.ClientDAO;

public class Menu {

	
	
	
	public int menuPrincipal() throws SQLException {
		
		System.out.println("----------------------------------");
        System.out.println("            MENU                  ");
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("| 1 | -> Connexion Administrateur");
        System.out.println("| 2 | -> Connexion Client");
        System.out.println("| 3 | -> Créer un compte");
        System.out.println("| 0 | -> Quitter");
        int choix = LectureClavier.lireEntier("Veuillez entrer un choix");
        Client c=null;
        switch(choix) {
        	case 1 : break;
        	case 2 : c=this.connexionClient();
        			if(c==null) {
        				this.reessayerConnexion(c);
        			}
        			else{
        				this.menuClient(c);
        			}
        			break;
        	case 3 :  c=this.creerUnClient();
        			this.menuClient(c);break;
        	case 0 : System.out.println("Vous avez quitté l'application");break;
        }
		return 0;
    }
	
	public int menuClient(Client c) throws SQLException {
		
		System.out.println("----------------------------------");
        System.out.println("          ESPACE CLIENT           ");
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("| 1 | -> Créer une commande");
        System.out.println("| 2 | -> Consulter mes commandes");
        System.out.println("| 3 | -> Modifier mon compte");
        System.out.println("| 4 | -> Ajouter une image");
        System.out.println("| 0 | -> Quitter");
        int choix = LectureClavier.lireEntier("Veuillez entrer un choix");
        switch(choix) {
        	case 1 : this.creerCommande(c);break;
        	case 2 : break;
        	case 3 : this.creerUnClient();break;
        	case 0 : System.out.println("Vous avez quitté l'application");break;
        }
		return 0;
    }
	
	private Adresse choixAdresse(Client c,ArrayList<Adresse> adrs) throws SQLException {
		System.out.println("----------------------------------");
        System.out.println("          CHOIX ADRESSE           ");
        System.out.println("----------------------------------");
        System.out.println("");
        for (int i=0;i<adrs.size();i++) {
        	
        	System.out.println("|"+(i+1)+" | -> "+adrs.get(i).getAdresse());
        }
        int choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
        while(choix > adrs.size() && choix !=0) {
        	choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
            System.out.println("| 0 | -> Retour espace client");
        }
        if(choix==0) {
        	this.menuClient(c);
        }
        
		return adrs.get(choix);
		
	}
	
	private Commande creerCommande(Client c) throws SQLException {
		Adresse adresse=null;
		ClientDAO cdao = new ClientDAO();
		ArrayList<Adresse> adrs = cdao.getAdresse(c);
		AdresseDAO adao = new AdresseDAO();
		if(adrs.size()==0) {
			System.out.println("Fournir une adresse de livraison");
			adresse=adao.creerAdresse(c);
		}else {
	        System.out.println("| 1 | -> Saisir une nouvelle adresse");
	        System.out.println("| 2 | -> Choisir une adresse");
            System.out.println("| 0 | -> Retour espace client");
	        int choix = LectureClavier.lireEntier("Veuillez entrer un choix");
	        while(choix !=1 && choix !=0 && choix !=2) {
	        	choix = LectureClavier.lireEntier(" > Choisissez un numero valide");
	        }
	        if(choix==1) {
	        	adresse=adao.creerAdresse(c);
	        }else if(choix==2) {
	        	adresse=this.choixAdresse(c, adrs);
	        }else {
	        	this.menuClient(c);
	        }

		}
		System.out.println("choisir un statut : en attente,en cours,pret a lenvoi,envoyee");
		String s = LectureClavier.lireChaine();
		Commande cmd = new Commande(c, adresse, s, null);
		
		
		return cmd;
	}

	private Client creerUnClient() throws SQLException {
		ClientDAO c = new ClientDAO();
		return c.saisir();		
	}
	
	private Client connexionClient() throws SQLException {
		ClientDAO c = new ClientDAO();
		return c.seConnecter();		
	}
	
	private Client reessayerConnexion(Client c) throws SQLException {
		int i=0;
		boolean rep=LectureClavier.lireOuiNon("Voulez-vous reessayer ?");
		while((i<3 && c==null)&& rep) {
			System.out.println("Nombre dessais restants : "+(3-i));
			i++;
			c=this.connexionClient();
			if(c==null && i<3) rep=LectureClavier.lireOuiNon("Voulez-vous reessayer ?");
		}
		return c;
		
	}
	
	
}
