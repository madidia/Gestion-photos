package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.models.Adresse;
import src.models.Client;

public class ClientDAO extends UtilisateurDAO<Client> {


	public Client find(String mail,String pwd) throws SQLException {
		Statement stmt;
		Client clt = null;

		String m="",prenom="",nom="",mdp="";
		stmt = conn.createStatement();
		String query1 = "Select * from ClientP where mailC = '"+mail+
				"' and mdpasseC = '"+pwd+"' and etat='actif'";
		ResultSet rs = stmt.executeQuery(query1);
		if(rs.next()) {
			m=rs.getString(1);
			nom=rs.getString(2);
			prenom=rs.getString(3);
			mdp=rs.getString(4);
			clt = new Client(m,nom,prenom,mdp);
		}else {
			System.out.println("Vos identifiants sont incorrects");
		}
		rs.close();
		stmt.close();

		return clt;
	}

	@Override
	public Client create(Client obj) throws SQLException {

		Statement stmt = conn.createStatement();
		String query1 = "Select mailU from Utilisateur where mailU = '"+obj.getMail()+"' ";
		ResultSet rs = stmt.executeQuery(query1);
		if(!rs.next()) {
			String query2 = "INSERT INTO Utilisateur Values ('"+obj.getMail()+"')";
			String query3 = "INSERT INTO ClientP Values ('"+obj.getMail()+"','"+obj.getNom()+"','"+
					obj.getPrenom()+"','"+obj.getPassword()+"','actif')";
			stmt.executeQuery(query2);
			stmt.executeQuery(query3);
			System.out.println("Votre compte a été créé avec succès");
			rs.close();
			stmt.close();
			conn.commit();
			return obj;
		} else {
			System.out.println("le mail est d�ja utilis�");
		}

		return null; 
	}

	@Override
	public Client update(Client obj) throws SQLException {

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Update ClientP SET nomC ='"+obj.getNom()+"' ,prenomC ='"+
				obj.getPrenom()+"',mdpasseC ='"+obj.getPassword()+"'"
				+ "WHERE mailC ='"+obj.getMail()+"'");
		stmt.close();
		conn.commit();
		System.out.println("Mise a jour effectuee avec succes");

		return obj;
	}



	@Override
	public Client find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client find(String id) throws SQLException {
		Statement stmt;
		Client clt = null;

		String m="",prenom="",nom="",mdp="";
		stmt = conn.createStatement();
		String query1 = "Select * from ClientP where mailC = '"+id+"'";
		ResultSet rs = stmt.executeQuery(query1);
		if(rs.next()) {
			m=rs.getString(1);
			nom=rs.getString(2);
			prenom=rs.getString(3);
			mdp=rs.getString(4);
			clt = new Client(m,nom,prenom,mdp);
		}else {
			System.out.println("Ce client n'hexiste pas");
		}
		rs.close();
		stmt.close();

		return clt;
	}

	@Override
	public ArrayList<Adresse> getAdresse(Client obj) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM adresse where mailAC='"+obj.getMail()+"'");
		ArrayList<Adresse> adresses = new ArrayList<>();
		Adresse a;
		while (rs.next()) {
			a = new Adresse(rs.getString(2), this.find(rs.getString(3)));
			a.setId(rs.getInt(1));;
			adresses.add(a);
		}
		if(adresses.size()==0) {
			System.out.println("Vous n'avez pas encore d'adresse enregistrée");
		}
		rs.close();
		stmt.close();
		return adresses;
	}

	@Override
	public void delete(Client obj) throws SQLException {
		// TODO Auto-generated method stub

	}
}
