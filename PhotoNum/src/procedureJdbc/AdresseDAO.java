package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Adresse;
import src.models.Client;
import src.models.LectureClavier;

public class AdresseDAO extends DAO<Adresse>{
	@Override
	public Adresse find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse find(long id) throws SQLException {
		Adresse adrs = null;
	
			Statement stmt = conn.createStatement();
			int idAdresse=0;
			String adresse="";
			String mail="";
			String query = "Select * from Adresse where idAdresse = '"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				idAdresse=rs.getInt(1);
				adresse=rs.getString(2);
				mail=rs.getString(3);
				ClientDAO clt = new ClientDAO();
				adrs = new Adresse(adresse, clt.find(mail));
				adrs.setId(idAdresse);
			}else {
				System.out.println("Cette adresse n'existe pas");
			}
			rs.close();
			stmt.close();
		return adrs;
	}

	@Override
	public Adresse create(Adresse obj) throws SQLException {
	
			Statement stmt = conn.createStatement();
			/** recuperer l'id max dans adresse **/
			int idAdresse=0;
			ResultSet rs = stmt.executeQuery("select max(idAdresse) from Adresse");
			while(rs.next()) {
				   idAdresse=rs.getInt(1);
			}
			idAdresse = idAdresse+1;
			stmt.executeUpdate("Insert into Adresse VALUES("+idAdresse+",'"+obj.getAdresse()+
					"','"+obj.getUser().getMail()+"')");
			obj.setId(idAdresse);
			ClientDAO c = new ClientDAO();
			c.find(obj.getUser().getMail()).getListAdresse().add(obj);
			rs.close();
			stmt.close();
			conn.commit();
		
		return obj;
	}

	@Override
	public Adresse update(Adresse obj) throws SQLException {
		
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Update adresseC SET adresseC ='"+obj.getAdresse()+"',mailAC ='"+
					obj.getUser().getMail()+"' where idAdresse = '"+obj.getId()+"'");
			ClientDAO c = new ClientDAO();
			int i=c.find(obj.getUser().getMail()).getListAdresse().indexOf(obj);
			c.find(obj.getUser().getMail()).getListAdresse().get(i).setAdresse(obj.getAdresse());
			c.find(obj.getUser().getMail()).getListAdresse().get(i).setUser(obj.getUser());
			stmt.close();
			conn.commit();		
		
		return obj;
	}

	@Override
	public void delete(Adresse obj) throws SQLException {
	
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE from adresseC WHERE idAdresse = '"+obj.getId()+"'");
			stmt.close();
			conn.commit();
		
	}
	
	public Adresse creerAdresse(Client c) throws SQLException {
        System.out.println("Veuillez saisir votre adresse :");
        String adr=LectureClavier.lireChaine();
		return this.create(new Adresse(adr, c));
	}
	
	@Override
	public Adresse saisir() {
		// TODO Auto-generated method stub
		return null;
	}

}
