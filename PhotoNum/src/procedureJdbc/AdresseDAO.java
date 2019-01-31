package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Adresse;

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
				adrs = new Adresse(idAdresse, adresse, clt.find(mail));
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
			stmt.executeUpdate("Insert into Adresse VALUES("+obj.getId()+",'"+obj.getAdresse()+
					"','"+obj.getUser().getMail()+"')");
			stmt.close();
			conn.commit();
		
		return obj;
	}

	@Override
	public Adresse update(Adresse obj) throws SQLException {
		
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Update adresseC SET adresseC ='"+obj.getAdresse()+"',mailAC ='"+
					obj.getUser().getMail()+"' where idAdresse = '"+obj.getId()+"'");
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

	@Override
	public Adresse saisir() {
		// TODO Auto-generated method stub
		return null;
	}

}
