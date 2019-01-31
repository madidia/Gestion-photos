package src.menu;

import src.models.Client;
import src.models.Commande;
import src.models.LectureClavier;
import src.procedureJdbc.ClientDAO;

public class Menu {

	
	
	
	public int menuPrincipal() {
		
		System.out.println("----------------------------------");
        System.out.println("            MENU                  ");
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("| 1 | -> Connexion Administrateur");
        System.out.println("| 2 | -> Connexion Client");
        System.out.println("| 3 | -> Créer un compte");
        System.out.println("| 0 | -> Quitter");
        int choix = LectureClavier.lireEntier("Veuillez entrer un choix");
        switch(choix) {
        	case 1 : break;
        	case 2 : Client c=this.connexionClient();
        			if(c==null) {this.reessayerConnexion(c);}
        			else{
        				this.menuClient();
        			}
        			break;
        	case 3 : this.creerUnClient();
        			this.menuClient();break;
        	case 0 : System.out.println("Vous avez quitté l'application");break;
        }
		return 0;
    }
	
	public int menuClient() {
		
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
        	case 1 : this.creerCommande();break;
        	case 2 : break;
        	case 3 : this.creerUnClient();break;
        	case 0 : System.out.println("Vous avez quitté l'application");break;
        }
		return 0;
    }

	private Commande creerCommande() {
		return null;
		// TODO Auto-generated method stub
		
	}

	private Client creerUnClient() {
		ClientDAO c = new ClientDAO();
		return c.saisir();		
	}
	
	private Client connexionClient() {
		ClientDAO c = new ClientDAO();
		return c.seConnecter();		
	}
	
	private Client reessayerConnexion(Client c) {
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
