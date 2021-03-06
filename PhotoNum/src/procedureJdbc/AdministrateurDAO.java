package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.models.Administrateur;
import src.models.Adresse;
import src.models.Client;

public class AdministrateurDAO extends UtilisateurDAO<Administrateur> {

	@Override
	public Administrateur find(String mail) throws SQLException {
		Statement stmt;
		Administrateur admin = null;

		stmt = conn.createStatement();
		String query = "Select * from Administrateur where mailC = '"+mail+"' ";
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()){
			admin = new Administrateur(rs.getString("mailA"), rs.getString("nomA") , 
					rs.getString("prenomA") , rs.getString("mdpasseA"));
		}
		rs.close();
		stmt.close();
		return admin;
	}
	public Administrateur find(String mail,String pwd) throws SQLException {
		Statement stmt;
		Administrateur admin = null;

		String m="",prenom="",nom="",mdp="";
		stmt = conn.createStatement();
		String query1 = "Select * from Administrateur where mailA = '"+mail+"' and mdpasseA = '"+pwd+"'";
		ResultSet rs = stmt.executeQuery(query1);
		if(rs.next()) {
			m=rs.getString(1);
			nom=rs.getString(2);
			prenom=rs.getString(3);
			mdp=rs.getString(4);
			admin = new Administrateur(m,nom,prenom,mdp);
		}else {
			System.out.println("Vos identifiants sont incorrects");
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
			stmt.executeUpdate("INSERT INTO Administrateur Values ('"+obj.getMail()+"','"+
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

	public void deleteClient(Client obj) throws SQLException {

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("UPDATE ClientP set etat = 'desactif' where mailC ='"+obj.getMail()+"'");
		obj.setEtat("desactif");
		stmt.close();
		conn.commit();

	}

	@Override
	public Administrateur find(long id) {
		// TODO Auto-generated method stub
		return null;
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
