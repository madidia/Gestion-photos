package src.menu;

import java.sql.SQLException;
import java.util.ArrayList;

import src.models.Administrateur;
import src.models.Adresse;
import src.models.Client;
import src.models.Commande;
import src.models.Impression;
import src.models.LectureClavier;
import src.models.Support;
import src.procedureJdbc.AdresseDAO;
import src.procedureJdbc.ClientDAO;
import src.procedureJdbc.CodePersonnelDAO;
import src.procedureJdbc.CommandeDAO;
import src.procedureJdbc.SupportDAO;
import src.models.Code;

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
	
	public int menuAdmin(Administrateur c) throws SQLException {
		
		System.out.println("----------------------------------");
        System.out.println("          ESPACE ADMIN            ");
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("| 1 | -> Supprimer Client");
        System.out.println("| 2 | -> Ajouter un support");
        System.out.println("| 0 | -> Quitter");
        int choix = LectureClavier.lireEntier("Veuillez entrer un choix");
        switch(choix) {
        	case 1 : this.supprimerClient(c);
        			this.menuAdmin(c);
        	case 2 : this.AjouterSupport(c);
        			this.menuAdmin(c);
        			break;
        	case 3 : this.creerUnClient();break;
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
        	case 1 : this.creerCommande(c);
        			this.menuClient(c);
        	case 2 : this.voirCommande(c);
        			this.menuClient(c);
        			break;
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
        	
        	System.out.println("|"+(i+1)+" | -> "+adrs.get(i).getAdresse()+" id "+adrs.get(i).getId());
        }
        int choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
        while(choix > adrs.size() && choix !=0) {
        	choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
            System.out.println("| 0 | -> Retour espace client");
        }
        if(choix==0) {
        	this.menuClient(c);
        }
        System.out.println("choix "+choix);
        System.out.println("id "+adrs.get(choix-1).getId());
		return adrs.get(choix-1);
		
	}
	
	private Commande creerCommande(Client c) throws SQLException {
		Adresse adresse=null;
		ClientDAO cdao = new ClientDAO();
		CodePersonnelDAO code = new CodePersonnelDAO();
		ArrayList<Code> mescodes;
		ArrayList<Adresse> adrs = cdao.getAdresse(c);
		AdresseDAO adao = new AdresseDAO();
		CommandeDAO cmdDao = new CommandeDAO();
		boolean rep;
		Code codeutilise=null;
		/** Choisir adresse */
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
		Commande cmd = new Commande(c, adresse, "", null);
		cmdDao.create(cmd);
		/** Creer impression **/
		this.creerImpression(cmd, this.choixSupport());
		rep=LectureClavier.lireOuiNon("Voulez-vous ajouter une autre impression ?");
		while(rep) {
			this.creerImpression(cmd, this.choixSupport());
			rep=LectureClavier.lireOuiNon("Voulez-vous ajouter une autre impression ?");
		}
		
		/** Choisir un code */
		mescodes=code.getMesCodes(c);
		if(mescodes.size()>0) {
			rep=LectureClavier.lireOuiNon("Voulez-vous utiliser un code ?");
			if(rep) {
				codeutilise=this.choixCode(mescodes);
			}
		}
		
		
		cmd.setIdLivraison(adresse.getId());
		cmd.setCode(codeutilise);
		cmd.getMontant();
		
		System.out.println(cmd.getStringCommande());
		
		
		return cmd;
	}
	
	private void supprimerClient(Administrateur c) throws SQLException {
		
        String mailC;
        System.out.println("Veuillez saisir l'email du Client :");
        mailC = LectureClavier.lireChaine();
        ClientDAO cld = new ClientDAO();
        cld.delete(new Client(mailC, null, null, null));
	}
	
	private Support AjouterSupport(Administrateur c) throws SQLException {
		return null;
	}
	
	private Impression creerImpression(Commande cmd,Support s) {

		String format,qualite;
		int nb;
        System.out.println("Veuillez saisir le format d impression :");
        format=LectureClavier.lireChaine();
        System.out.println("Veuillez saisir la qualite d impression:");
        qualite=LectureClavier.lireChaine();
        nb=LectureClavier.lireEntier("Veuillez saisir le nombre d'exemplaire :");
        Impression imp = new Impression(format, qualite, nb, cmd, s);
        cmd.getImpressions().add(imp);
		return imp;
	}
	
	private Support choixSupport() throws SQLException {
		SupportDAO supdao =new SupportDAO();
		ArrayList<Support> sup=supdao.getAllSupport();
		Support s = null;
		System.out.println("----------------------------------");
        System.out.println("           CHOIX SUPPORT          ");
        System.out.println("----------------------------------");
        System.out.println("");
		for (int i=0;i<sup.size();i++) {
        	System.out.println("|"+(i+1)+" | -> "+sup.get(i).getMonSupport());
        }
		int choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
        while(choix > sup.size() && choix !=0) {
        	choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
            System.out.println("| 0 | -> Retour espace commande");
        }
        if(choix!=0) {
        	s=sup.get(choix-1);
        }
		
		return s;
	}

	private Code choixCode(ArrayList<Code> mescodes) {
		Code c=null;
		System.out.println("----------------------------------");
        System.out.println("            CHOIX CODE            ");
        System.out.println("----------------------------------");
        System.out.println("");
		for (int i=0;i<mescodes.size();i++) {
        	System.out.println("|"+(i+1)+" | -> "+mescodes.get(i).getIdCode());
        }
		int choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
        while(choix > mescodes.size() && choix !=0) {
        	choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
            System.out.println("| 0 | -> Retour espace commande");
        }
        if(choix!=0) {
        	c=mescodes.get(choix);
        }
		return c;
				
	}

	private Client creerUnClient() throws SQLException {
		
		String nom,prenom,email,mdp;
		//----------------------nom----------------------
        System.out.println("Veuillez saisir votre nom :");
        nom=LectureClavier.lireChaine();
        //----------------------prenom----------------------
        System.out.println("Veuillez saisir votre prenom :");
        prenom=LectureClavier.lireChaine();
        //----------------------email----------------------
        System.out.println("Veuillez saisir votre email :");
        email=LectureClavier.lireChaine();
        //----------------------mdp----------------------
        System.out.println("Veuillez saisir votre mot de passe :");
        mdp=LectureClavier.lireChaine();
        ClientDAO cdao = new ClientDAO();
        Client c = cdao.create(new Client(email, nom, prenom, mdp));
        return c;
	}
	
	private Client connexionClient() throws SQLException {
		String mail,pwd;
		System.out.println("----------------------------------");
        System.out.println("       ESPACE DE CONNEXION        ");
        System.out.println("----------------------------------");
		//----------------------email----------------------
        System.out.println("saisissez votre email :");
        mail=LectureClavier.lireChaine();
        //----------------------mdp----------------------
        System.out.println("saisissez votre mot de passe :");
        pwd=LectureClavier.lireChaine();
		ClientDAO c = new ClientDAO();
        return c.find(mail, pwd);
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
	
	private void voirCommande(Client c) throws SQLException {
		CommandeDAO cdao = new CommandeDAO();
		ArrayList<Commande> cmds =cdao.getAllCommande(c);
		System.out.println("----------------------------------");
        System.out.println("          MES COMMANDES           ");
        System.out.println("----------------------------------");
		for(int i=0;i<cmds.size();i++) {
			System.out.println(cmds.get(i).getStringCommande());
		}
		
		
	}
	
	
}
