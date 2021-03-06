package src.menu;

import java.sql.SQLException;
import java.util.ArrayList;

import src.models.Administrateur;
import src.models.Adresse;
import src.models.Client;
import src.models.Commande;
import src.models.Image;
import src.models.Impression;
import src.models.LectureClavier;
import src.models.Support;
import src.procedureJdbc.AdministrateurDAO;
import src.procedureJdbc.AdresseDAO;
import src.procedureJdbc.ClientDAO;
import src.procedureJdbc.CodePersonnelDAO;
import src.procedureJdbc.CommandeDAO;
import src.procedureJdbc.ImageDAO;
import src.procedureJdbc.ImpressionDAO;
import src.procedureJdbc.SupportDAO;
import src.models.Code;

public class Menu {

	/**
	 * 
	 * @throws SQLException
	 */
	public void menuPrincipal() throws SQLException {
		System.out.println("------Bienvenue sur PHOTONUM------");
		System.out.println("----------------------------------");
		System.out.println("            MENU                  ");
		System.out.println("----------------------------------");
		System.out.println("");
		System.out.println("| 1 | -> Connexion Administrateur");
		System.out.println("| 2 | -> Connexion Client");
		System.out.println("| 3 | -> Créer un compte");
		System.out.println("| 0 | -> Quitter");
		int choix = LectureClavier.lireEntier(" > Veuillez entrer un choix");
		Client c=null;
		switch(choix) {
		case 1 : Administrateur a = this.connexionAdmin();
		this.menuAdministrateur(a);break;
		case 2 : c=this.connexionClient();
		while(c==null) {
			this.reessayerConnexion(c);
		}        			
		break;
		case 3 :  c=this.creerUnClient();break;
		case 0 : System.out.println("Vous avez quitté l'application");break;
		}
		if(c!=null) {
			this.menuClient(c);
		}else {
			this.menuPrincipal();
		}
	}

	/**
	 * 
	 * @return l'administrateur qui est connecté
	 * @throws SQLException
	 */
	private Administrateur connexionAdmin() throws SQLException {
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
		AdministrateurDAO a = new AdministrateurDAO();
		return a.find(mail, pwd);
	}

	/**
	 * 
	 * @param c 
	 * @throws SQLException
	 */
	public void menuClient(Client c) throws SQLException {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("                         ESPACE CLIENT                              ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("");
		System.out.println("| 1 | -> Créer une commande      	| 2 | -> Consulter mes commandes");
		System.out.println("| 3 | -> Informations du Compte  	| 4 | -> Modifier mon compte");
		System.out.println("| 5 | -> Ajouter une image       	| 6 | -> Modifier une image - Creer photo");
		System.out.println("| 7 | -> Mes codes de reduction     | 8 | -> Voir mes images");
		int choix = LectureClavier.lireEntier(" > Veuillez entrer un choix");
		switch(choix) {
		case 1 : this.creerCommande(c);break;
		case 2 : this.voirCommande(c);break;
		case 3 : c.infosClient();break;
		case 4 : this.modifierCompte(c);break;
		case 5 : this.ajouterImage(c);break;
		case 7 : this.voirMesCodes(c);break;
		case 8 : this.voiImages(c);break;
		default : System.out.println("Vous avez quitté l'application");return;
		}
		System.out.println("");
		System.out.println("| 0 | -> Retour espace client ");
		System.out.println("| 1 | -> QUITTER ");
		choix = LectureClavier.lireEntier(" > Veuillez entrer un choix");
		switch(choix) {
		case 0:this.menuClient(c);break;
		default : System.out.println("Vous avez quitté l'application");break;
		}
		return;
	}

	/**
	 * 
	 * @param c
	 * @throws SQLException
	 */
	private void voiImages(Client c) throws SQLException {
		ArrayList<Image> mesImages = new ArrayList<>();
		ImageDAO idao = new ImageDAO();
		mesImages=idao.getClientImages(c);
		if(mesImages.size()==0) {
			System.out.println("Vous n'avez pas d'image enregistree");
		}else {
			for(int i=0;i<mesImages.size();i++) {
				System.out.println(mesImages.get(i).infosImage());
			}
		}
	}

	/**
	 * 
	 * @param c
	 * @throws SQLException
	 */
	private void modifierCompte(Client c) throws SQLException {
		String nom,prenom,mdp;
		ClientDAO cdao = new ClientDAO();
		System.out.println("----------------------------------");
		System.out.println("          MODIFIER COMPTE         ");
		System.out.println("----------------------------------");
		System.out.println("");
		System.out.println("| 1 | -> Changer le nom");
		System.out.println("| 2 | -> Changer le prenom");
		System.out.println("| 3 | -> Changer le mot de passe");
		System.out.println("| 4 | -> Retour espace client");
		System.out.println("| 0 | -> QUITTER");
		int choix = LectureClavier.lireEntier(" > Veuillez entrer un choix");
		switch(choix) {
		case 0:return;
		case 1:System.out.println("Saisissez le nom");
		nom=LectureClavier.lireChaine();
		c.setNom(nom);break;
		case 2:System.out.println("Saisissez le prenom");
		prenom=LectureClavier.lireChaine();
		c.setPrenom(prenom);break;
		case 3:System.out.println("Saisissez le mot de passe");
		mdp=LectureClavier.lireChaine();
		c.setPassword(mdp);break;
		default:this.menuClient(c);
		}
		cdao.update(c);
		boolean rep=LectureClavier.lireOuiNon("Modifier un autre champ ? : o,n");
		while(rep) {
			this.modifierCompte(c);
		}
	}

	/**
	 * 
	 * @param c
	 * @param adrs
	 * @return
	 * @throws SQLException
	 */
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

	private void creerCommande(Client c) throws SQLException {
		Adresse adresse=null;
		ClientDAO cdao = new ClientDAO();
		CodePersonnelDAO code = new CodePersonnelDAO();
		ArrayList<Code> mescodes;
		ArrayList<Adresse> adrs = cdao.getAdresse(c);
		AdresseDAO adao = new AdresseDAO();
		CommandeDAO cmdDao = new CommandeDAO();
		boolean rep;
		Code codeutilise=null;
		double montant;
		/** Choisir adresse */
		if(adrs.size()==0) {
			System.out.println("Fournir une adresse de livraison");
			adresse=adao.creerAdresse(c);
		}else {
			System.out.println("| 1 | -> Saisir une nouvelle adresse");
			System.out.println("| 2 | -> Choisir une adresse");
			System.out.println("| 0 | -> Retour espace client");
			int choix = LectureClavier.lireEntier(" > Veuillez entrer un choix");
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
		Commande cmd = new Commande(c, adresse, null);

		/** Creer impression **/
		this.creerImpression(cmd, this.choixSupportClient(c));
		rep=LectureClavier.lireOuiNon("Voulez-vous ajouter une autre impression ?");
		ArrayList<Impression> imps = new ArrayList<>();
		Impression imp;
		while(rep) {
			imp=this.creerImpression(cmd, this.choixSupportClient(c));
			rep=LectureClavier.lireOuiNon("Voulez-vous ajouter une autre impression ?");
			imps.add(imp);
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
		montant=cmd.calculeMontant(imps);
		cmd.setMontant(montant);
		c.getListCommande().add(cmd);
		cmdDao.create(cmd);
		System.out.println("Votre commande a été ajouté");
		System.out.println(cmd.getStringCommande());

		ImpressionDAO iDAO = new ImpressionDAO();
		iDAO.addImpressions(cmd.getImpressions());
	}

	/**
	 * 
	 * @param cmd
	 * @param s
	 * @return
	 */
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

	/**
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	private Support choixSupportClient(Client c) throws SQLException {
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
		System.out.println("| 0 | -> Retour");
		int choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
		while(choix > sup.size() && choix !=0) {
			choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
			System.out.println("| 0 | -> Retour");
		}
		if(choix!=0) {
			s=sup.get(choix-1);
		}else {
			this.menuClient(c);
		}

		return s;
	}

	/**
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	private Support choixSupportAdmin(Administrateur c) throws SQLException {
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
		System.out.println("| 0 | -> Retour");
		int choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
		while(choix > sup.size() && choix !=0) {
			choix = LectureClavier.lireEntier(" > Choisissez le numero correspondant");
			System.out.println("| 0 | -> Retour");
		}
		if(choix!=0) {
			s=sup.get(choix-1);
		}else {
			this.menuAdministrateur(c);
		}

		return s;
	}

	/**
	 * 
	 * @param mescodes
	 * @return
	 */
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

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	private Client reessayerConnexion(Client c) throws SQLException {
		int i=0;
		boolean rep=LectureClavier.lireOuiNon("Voulez-vous reessayer ?");
		while((i<3 || c==null)&& rep) {
			System.out.println("Nombre dessais restants : "+(3-i));
			i++;
			c=this.connexionClient();
			if(c==null && i<3) rep=LectureClavier.lireOuiNon("Voulez-vous reessayer ?");
		}
		return c;

	}

	/**
	 * 
	 * @param c
	 * @throws SQLException
	 */
	private void voirCommande(Client c) throws SQLException {
		CommandeDAO cdao = new CommandeDAO();
		ArrayList<Commande> cmds =cdao.getAllCommande(c);
		System.out.println("----------------------------------");
		System.out.println("          MES COMMANDES           ");
		System.out.println("----------------------------------");
		if(cmds.size()>0) {
			for(int i=0;i<cmds.size();i++) {
				System.out.println(cmds.get(i).getStringCommande());
			}
		}else {
			System.out.println("Vous n avez pas de commande");
		}
		System.out.println("");

	}

	/**
	 * 
	 * @param c
	 * @throws SQLException
	 */
	private void ajouterImage(Client c) throws SQLException {
		String chemin,partage="non";
		double resolution;
		boolean rep;
		ImageDAO idao = new ImageDAO();
		Image img;
		System.out.println("----------------------------------");
		System.out.println("            AJOUT IMAGE           ");
		System.out.println("----------------------------------");
		System.out.println("Donnez le chemin :");
		chemin=LectureClavier.lireChaine();
		resolution=LectureClavier.lireDouble("Donnez la resolution :");
		rep=LectureClavier.lireOuiNon("Voulez-vous partagez l image ?");
		if(rep) {
			partage="oui";
		}
		img = new Image(chemin, c, resolution, partage);
		idao.create(img);
		System.out.println("Votre image a ete ajoutee avec succes :");
		img.infosImage();
	}

	/**
	 * 
	 * @param c
	 * @throws SQLException
	 */
	private void voirMesCodes(Client c) throws SQLException {
		CodePersonnelDAO cpdao = new CodePersonnelDAO();
		ArrayList<Code> codes=cpdao.getMesCodes(c);
		if(codes.size()>0) {
			for(int i=0;i<codes.size();i++) {
				System.out.println(codes.get(i).infosCode());
			}
		}else {
			System.out.println("Vous n'avez pas de code de reduction");
		}
		System.out.println("");

	}


	/**
	 * 
	 * @param a
	 * @return
	 * @throws SQLException
	 */
	private Support ajouterSupport(Administrateur a) throws SQLException {
		String type,format,qualite;
		int quantite;
		int prix;
		//----------------------Type----------------------
		System.out.println("Veuillez saisir le type :");
		type=LectureClavier.lireChaine();
		//----------------------Format----------------------
		System.out.println("Veuillez saisir le format :");
		format=LectureClavier.lireChaine();
		//----------------------Qualite----------------------
		System.out.println("Veuillez saisir la qualite :");
		qualite=LectureClavier.lireChaine();
		//----------------------Quantite----------------------
		System.out.println("Veuillez saisir la quantite :");
		quantite=LectureClavier.lireEntier("");
		//----------------------Prix----------------------
		System.out.println("Veuillez saisir le prix unitaire :");
		prix=LectureClavier.lireEntier("");
		SupportDAO sdao = new SupportDAO();
		Support s = new Support(type, format, qualite, quantite, prix);
		return sdao.create(s);	
	}

	/**
	 * 
	 * @param a
	 * @throws SQLException
	 */
	private void supprimerClient(Administrateur a) throws SQLException {
		AdministrateurDAO adm = new AdministrateurDAO();
		System.out.println("Veuillez saisir l'email du Client :");
		String mailc = LectureClavier.lireChaine();
		adm.deleteClient(new Client(mailc,null,null,null));
	}

	/**
	 * 
	 * @param a
	 * @return
	 * @throws SQLException
	 */
	public int menuAdministrateur(Administrateur a) throws SQLException {

		System.out.println("----------------------------------");
		System.out.println("          ESPACE Administrateur   ");
		System.out.println("----------------------------------");
		System.out.println("");
		System.out.println("| 1 | -> Supprimer Client");
		System.out.println("| 2 | -> Ajouter Support");
		System.out.println("| 3 | -> Modifier Support");
		System.out.println("| 4 | -> Modifier Commande");
		System.out.println("| 0 | -> Quitter");
		int choix = LectureClavier.lireEntier("Veuillez entrer un choix");
		switch(choix) {
		case 1 : this.supprimerClient(a);break;
		case 2 : this.ajouterSupport(a);break;
		case 3 : this.ModifierSupport(a,this.choixSupportAdmin(a));break;
		case 4 : this.ModifierCommande();break;
		case 0 : System.out.println("Vous avez quitté l'application");break;
		}
		System.out.println("");
		System.out.println("| 0 | -> Retour espace admin ");
		System.out.println("| 1 | -> QUITTER ");
		choix = LectureClavier.lireEntier(" > Veuillez entrer un choix");
		switch(choix) {
		case 0:this.menuAdministrateur(a);break;
		default : System.out.println("Vous avez quitté l'application");break;
		}
		return 0;
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Commande ModifierCommande() throws SQLException {
		int numCommande;
		String Statut;
		//----------------------Numero Commande----------------------
		System.out.println("Veuillez saisir le numero de la commande :");
		numCommande=LectureClavier.lireEntier("");
		//----------------------Statut----------------------
		System.out.println("Veuillez saisir le nouveau statut:");
		Statut=LectureClavier.lireChaine();
		CommandeDAO cdao = new CommandeDAO();

		Commande com = cdao.find(numCommande);
		System.out.println("num commande "+com.getId());

		com.setStatut(Statut);
		Commande cm = cdao.update(com);
		return cm;
	}

	/**
	 * 
	 * @param a
	 * @param s
	 * @throws SQLException
	 */
	private void ModifierSupport(Administrateur a,Support s) throws SQLException {
		int qte;
		double pu;
		SupportDAO sdao = new SupportDAO();
		System.out.println("----------------------------------");
		System.out.println("          MODIFIER SUPPORT        ");
		System.out.println("----------------------------------");
		System.out.println("");
		System.out.println("| 1 | -> Changer la quantite");
		System.out.println("| 2 | -> Changer le prix");
		System.out.println("| 3 | -> Retour espace admin");
		System.out.println("| 0 | -> QUITTER");
		int choix = LectureClavier.lireEntier(" > Veuillez entrer un choix");
		switch(choix) {
		case 0:return;
		case 1:qte=LectureClavier.lireEntier("Donnez la nouvelle quantite");
		s.setQuantite(qte);break;
		case 2:pu=LectureClavier.lireDouble("Donnez le nouveau prix");
		s.setPrix(pu);break;
		default:this.menuAdministrateur(a);break;
		}
		sdao.update(s);

		boolean rep=LectureClavier.lireOuiNon("Modifier un autre champ ? : o,n");
		while(rep) {
			this.ModifierSupport(a, s);
		}
	}




}
