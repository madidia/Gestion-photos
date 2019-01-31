package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.models.Administrateur;
import src.models.Adresse;
import src.models.LectureClavier;

public class AdministrateurDAO extends UtilisateurDAO<Administrateur> {

	@Override
	public Administrateur find(String mail) throws SQLException {
		Statement stmt;
		Administrateur admin = null;
		
		
		stmt = conn.createStatement();
		String query = "Select * from ClientP where mailC = '"+mail+"' ";
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()){
			admin = new Administrateur(rs.getString("mailA"), rs.getString("nomA") , 
					rs.getString("prenomA") , rs.getString("mdpasseA"));
		}
		rs.close();
		stmt.close();
		return admin;
	}

	@Override
	public Administrateur create(Administrateur obj) throws SQLException {
			Statement stmt  = conn.createStatement();
			String query = "Select * from Administrateur where mailA = '"+obj.getMail() +"'";
			ResultSet rs = stmt.executeQuery(query);
			if(!rs.next()) {
				stmt.executeUpdate("INSERT INTO Utilisateur Values ('"+obj.getMail()+"')");
				stmt.executeUpdate("INSERT INTO ClientP Values ('"+obj.getMail()+"','"+
		 				 obj.getNom()+"','"+obj.getPrenom()+"','"+obj.getPassword()+"')");
		 	} else {
		 		System.out.println("cette adresse mail est deja utilis�e");
			}
			rs.close();
			stmt.close();
			conn.commit();
			return obj;
	}

	@Override
	public Administrateur update(Administrateur obj) throws SQLException {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(" Update Administrateur SET nomA ='"+obj.getNom()
				+"' ,prenomA ='"+obj.getPrenom()+"',mdpasseA ='"+obj.getPassword()+"'"
					+ "WHERE mailA ='"+obj.getMail()+"'");
			stmt.close();
			conn.commit();
			return obj;
	}

	@Override
	public void delete(Administrateur obj) throws SQLException {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE from Administrateur where mailA = '"+obj.getMail()+"'");;
			stmt.close();
			conn.commit();
	}

	@Override
	public Administrateur find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrateur saisir() throws SQLException {
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
        Administrateur c = new Administrateur(email, nom, prenom, mdp);
        return this.create(c);
	}

	@Override
	public ArrayList<Adresse> getAdresse(Administrateur obj) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM adresse where mailAC='"+obj.getMail()+"'");
		ArrayList<Adresse> adresses = new ArrayList<>();
		Adresse a;
        while (rs.next()) {
        	a = new Adresse(rs.getString(2), this.find(rs.getString(3)));
            adresses.add(a);
        }
        if(adresses.size()==0) {
        	System.out.println("Vous n'avez pas encore d'adresse enregistrée");
        }
        rs.close();
        stmt.close();
		return adresses;
	}
}
