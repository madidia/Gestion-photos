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
			stmt = conn.createStatement();
	    	String query1 = "Select * from ClientP where mailC = '"+mail+"' ";
	    	ResultSet rs = stmt.executeQuery(query1);
	    	if(rs.next())
	    	   clt = new Client(rs.getString("mailC"), rs.getString("nomC") , rs.getString("prenomC") , rs.getString("mdpasseC"));
	    	rs.close();
	    	stmt.close();
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
	 		 return obj;
		   } else {
	 		   System.out.println("mail déja utilisé");
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
