package procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Client;

public class ClientDAO extends UtilisateurDAO<Client> {

	@Override
	public Client find(String mail) {
	   	Statement stmt;
  	    Client clt = null;
		try {
			String m="",prenom="",nom="",mdp="";
			stmt = conn.createStatement();
	    	String query1 = "Select * from ClientP where mailC = '"+mail+"' ";
	    	ResultSet rs = stmt.executeQuery(query1);
	    	if(rs.next()) {
	    		m=rs.getString(1);
	    		nom=rs.getString(2);
	    		prenom=rs.getString(3);
	    		mdp=rs.getString(4);
	    	}
	    	   clt = new Client(m,nom,prenom,mdp);
	    	System.out.println("yess "+clt.getMail());
	    	rs.close();
	    	stmt.close();
	    	conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clt;
	}
	
	@Override
	public Client create(Client obj) {
	   try {
		   Statement stmt = conn.createStatement();
		   String query1 = "Select mailU from Utilisateur where mailU = '"+obj.getMail()+"' ";
		   ResultSet rs = stmt.executeQuery(query1);
		   if(!rs.next()) {
	 		 String query2 = "INSERT INTO Utilisateur Values ('"+obj.getMail()+"')";
	 		 String query3 = "INSERT INTO ClientP Values ('"+obj.getMail()+"','"+obj.getNom()+"','"+obj.getPrenom()+"','"+obj.getPassword()+"')";
	 		 stmt.executeQuery(query2);
	 		 stmt.executeQuery(query3);
	 		 rs.close();
	 		 stmt.close();
	 		 conn.commit();
	 		 return obj;
		   } else {
	 		   System.out.println("mail d�ja utilis�");
		   }
	   	} catch (SQLException e) {
		   e.printStackTrace();
	   		}
	   return null; 
    }
    
	@Override
	public Client update(Client obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "Update ClientP SET nomC ='"+obj.getNom()+"' ,prenomC ='"+obj.getPrenom()+"',mdpasseC ='"+obj.getPassword()+"'"
					+ "WHERE mailC ='"+obj.getMail()+"'";
			stmt.executeQuery(query);
			stmt.close();
			conn.commit();
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Client obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "DELETE ON ClientP where mailC = '"+obj.getMail()+"'";
			stmt.executeQuery(query);
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Client find(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
